package net.selsela.carRental.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import net.selsela.carRental.R;
import net.selsela.carRental.SelselaApplication;
import net.selsela.carRental.data.local.PreferencesHelper;
import net.selsela.carRental.data.local.UserSession;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.countries.Country;
import net.selsela.carRental.injection.component.ActivityComponent;
import net.selsela.carRental.injection.component.DaggerActivityComponent;
import net.selsela.carRental.injection.module.ActivityModule;
import net.selsela.carRental.ui.main.MainActivity;
import net.selsela.carRental.ui.main.SplachActivity;
import net.selsela.carRental.util.DialogFactory;
import net.selsela.carRental.util.ErrorResponseAdapter;
import net.selsela.carRental.util.ViewUtil;
import net.selsela.carRental.util.language.LanguageUtils;
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;
import com.treebo.internetavailabilitychecker.InternetConnectivityListener;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Abstract activity that every other Activity in this application must implement. It handles
 * creation of Dagger components and makes sure that instances of ConfigPersistentComponent survive
 * across configuration changes.
 */
public class BaseActivity extends AppCompatActivity implements MvpView, InternetConnectivityListener {

    private ActivityComponent mActivityComponent;
    public InternetAvailabilityChecker mInternetAvailabilityChecker;
    public static boolean hasConnection;
    @Inject
    public LanguageUtils languageUtils;
    @Inject
    public PreferencesHelper preferencesHelper;
    @Inject
    public
    UserSession mUserSession;
    @Nullable
    @BindView(R.id.my_toolbar)
    public Toolbar toolbar;

    @Nullable
    @BindView(R.id.progress)
    ProgressBar progressBar;
    public String activityTitle;

    @Nullable
    @BindView(R.id.pullToRefresh)
    public SwipeRefreshLayout pullToRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        mInternetAvailabilityChecker = InternetAvailabilityChecker.getInstance();
        mInternetAvailabilityChecker.addInternetConnectivityListener(this);
        languageUtils.initLocal();
        if (pullToRefresh != null)
            pullToRefresh.setColorSchemeResources(R.color.bron, R.color.accent);



    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        PreferencesHelper sharedPreferencesHelper = new PreferencesHelper(newBase);
        LanguageUtils utils = new LanguageUtils(newBase, sharedPreferencesHelper);
        Context base = utils.setLocale(utils.getCurrentLang());
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(SelselaApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {
        Timber.d("onInternetConnectivityChanged  %s ", hasConnection);
        hasConnection = isConnected;
    }

    public static boolean hasInternetConnection() {
        Timber.d("hasInternetConnection  %s ", hasConnection);
        return hasConnection;
    }

    protected void logout() {
        mUserSession.destroySession();
    }

    public boolean isArabic() {
        return languageUtils.isArabic();
    }

    public void hasActiveInternetConnection(boolean b) {
        if (!b) {
            Timber.d("no connection");
            ViewUtil.createSnackbar(getWindow().getDecorView().getRootView(), getResources().getString(R.string.no_connection)).show();
        }
    }

//    public String getCurrency() {
//
//        ConfigData configData = preferencesHelper.getCurrentUserSetting();
////        String cur = configData.getConfig().getCurrency();
////        String cur_en = configData.getConfig().getCurrencyEn();
//        return isArabic() ? cur : cur_en;
//    }

    public void initToolbar() {
        if (toolbar != null) {
            Timber.d("initToolbar %s", activityTitle);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            this.setTitle(activityTitle);

            //toolbar.setTitle(activityTitle);
        }
    }


    @Override
    public void showSuccessDialog(String message) {
        DialogFactory.showSuccsesDialog(this, message);

    }

    @Override
    public void showAlertDialog(String message) {
        DialogFactory.showAlertDialog(this, message);

    }

    @Override
    public void isSuccess(Boolean status) {

    }

    @Override
    public void showProgressView(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else
            progressBar.setVisibility(View.GONE);

    }

    @Override
    public void onRequestEnd() {
        stopRefreshing();

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void onRequestStart() {
        startRefreshing();
    }

    public void stopRefreshing() {
        if (pullToRefresh != null) {
            pullToRefresh.postDelayed(new Runnable() {
                @Override
                public void run() {

                    pullToRefresh.setRefreshing(false);
                }
            }, 100);
        }
    }

    public void startRefreshing() {
        if (pullToRefresh != null) {
            pullToRefresh.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pullToRefresh.setRefreshing(true);
                }
            }, 100);
        }
    }

    public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("finish", true); // if you are checking for this in your other Activities
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



    protected void reOpenApp() {
        this.finish();
        Intent intent = new Intent(this, SplachActivity.class);
        intent.putExtra("finish", true); // if you are checking for this in your other Activities
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void showMessageDialog(String s) {
        if (s != null && !s.isEmpty()) {
            MaterialDialog dialog = new MaterialDialog.Builder(this)
                    .content(s)
                    .contentGravity(GravityEnum.START)
                    .positiveText(R.string.dialog_action_ok)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            dialog.dismiss();
                        }
                    })
                    .build();
            dialog.show();
        }
    }


    @Override
    public void showMessageDialog(BaseResponse response) {
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .customView(R.layout.error_layout, false)
                .contentGravity(GravityEnum.START)
                .title(response.getResponseMessage())
                .positiveText(R.string.dialog_action_ok)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .build();
        if (response.getErrors() != null && response.getErrors().size() > 0) {
            View view = dialog.getCustomView();
            RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
            ErrorResponseAdapter errorResponseAdapter = new ErrorResponseAdapter(response.getErrors());
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(errorResponseAdapter);
        }
        dialog.show();

    }

    public void hideToolbar() {
        if (toolbar != null && getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
    public boolean isUserLogged() {
        return mUserSession.hasActiveSession();
    }

    public String getCurrency() {
        if (preferencesHelper.getAddress().getCountry()!=null) {
            Country configData = preferencesHelper.getAddress().getCountry();
            String cur = configData.getCurrency_ar();
            String cur_en = configData.getCurrency_en();
            return isArabic() ? cur : cur_en;
        }
        return null;
    }
}
