
package net.selsela.carRental.data.model.countries;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("currency_ar")
    @Expose
    private String currency_ar;
    @SerializedName("currency_en")
    @Expose
    private String currency_en;
    @SerializedName("city")
    @Expose
    private List<City> city = null;
    @SerializedName("prefix")
    @Expose
    private int  prefix;

    @SerializedName("flag")
    @Expose
    private String  flag;


    protected Country(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        currency_ar = in.readString();
        currency_en = in.readString();
        city = in.createTypedArrayList(City.CREATOR);
        prefix = in.readInt();
        flag = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeString(currency_ar);
        dest.writeString(currency_en);
        dest.writeTypedList(city);
        dest.writeInt(prefix);
        dest.writeString(flag);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public String getCurrency_ar() {
        return currency_ar;
    }

    public void setCurrency_ar(String currency_ar) {
        this.currency_ar = currency_ar;
    }

    public String getCurrency_en() {
        return currency_en;
    }

    public void setCurrency_en(String currency_en) {
        this.currency_en = currency_en;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
