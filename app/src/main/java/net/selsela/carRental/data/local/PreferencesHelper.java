package net.selsela.carRental.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

import net.selsela.carRental.data.model.AddressSaved;
import net.selsela.carRental.data.model.config.ConfigData;
import net.selsela.carRental.data.model.user.company_data;
import net.selsela.carRental.injection.ApplicationContext;

@Singleton
public class PreferencesHelper {

    public static final String PREF_FILE_NAME = "android_buffet_pref_file";
    public static final String SHARED_PREF = "ah_firebase_buffet";
    private static final String GUEST_name = "GUEST_name";
    private static final String GUEST_mobile = "GUEST_mobile";
    private final SharedPreferences mPref;
    private static final String ADDRESS = "Address";

    private final String currentUserKey = "userSession_buffet";
    private final String currentUserSettingKey = "currentUserSettingKey_buffet";
    private final String GUEST = "GUEST";
    private final String currentSelectedCountry = "currentSelectedCountry";
    private final String first_run = "first_run";
    @NonNull
    Gson gson = new GsonBuilder().create();

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }

    public void addUserSession(company_data user) {
        Timber.d("user %s", user);
        String jsonUser = gson.toJson(user);
        mPref.edit().putString(currentUserKey, jsonUser).apply();
    }

    public company_data getCurrentUser() {
        String jsonUser = mPref.getString(currentUserKey, null);
        return gson.fromJson(jsonUser, company_data.class);
    }

    public void removeUserSession() {
        mPref.edit().putString(currentUserKey, "").apply();
    }

    public void addUserSetting(ConfigData settingData) {
        String jsonUser = gson.toJson(settingData);
        mPref.edit().putString(currentUserSettingKey, jsonUser).apply();
    }

    public ConfigData getCurrentUserSetting() {
        String jsonUser = mPref.getString(currentUserSettingKey, null);
        return gson.fromJson(jsonUser, ConfigData.class);
    }

    public void setAddress(AddressSaved address) {
        String jsonUser = gson.toJson(address);
        mPref.edit().putString(ADDRESS, jsonUser).apply();
    }

    public AddressSaved getAddress() {
        String jsonUser = mPref.getString(ADDRESS, null);
        return gson.fromJson(jsonUser, AddressSaved.class);
    }
    public String getNotifToken() {
        return mPref.getString(SHARED_PREF, "");
    }

    public void setNotifToken(String token) {
        mPref.edit().putString(SHARED_PREF, token).apply();
    }

    public void addWithKey(String key, String value) {
        mPref.edit().putString(key, value).apply();
    }

    public void addWithKey(String key, int value) {
        mPref.edit().putInt(key, value).apply();
    }

    public void deleteWithKey(String key) {
        mPref.edit().putString(key, "").apply();
    }

    @Nullable
    public String getWithKey(String key) {
        return mPref.getString(key, "");
    }

    public boolean isFirstRun() {
        return mPref.getBoolean(first_run, true);
    }

    public void setFirstRun(boolean b) {
        mPref.edit().putBoolean(first_run, b).apply();
    }
}
