
package net.selsela.carRental.data.model.countries;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryData implements Parcelable {

    @SerializedName("countries")
    @Expose
    private List<Country> countries = null;

    protected CountryData(Parcel in) {
        countries = in.createTypedArrayList(Country.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(countries);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CountryData> CREATOR = new Creator<CountryData>() {
        @Override
        public CountryData createFromParcel(Parcel in) {
            return new CountryData(in);
        }

        @Override
        public CountryData[] newArray(int size) {
            return new CountryData[size];
        }
    };

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

}
