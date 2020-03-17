
package net.selsela.carRental.data.model.client_proplem;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class company implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company_name")
    @Expose
    private String company_name;
    @SerializedName("email")
    @Expose
    private String email;




    @SerializedName("country_id")
    @Expose
    private int country_id;

    @SerializedName("comany_address")
    @Expose
    private String comany_address;
    @SerializedName("status")
    @Expose
    private int status;


    protected company(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        company_name = in.readString();
        email = in.readString();
        country_id = in.readInt();
        comany_address = in.readString();
        status = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(company_name);
        dest.writeString(email);
        dest.writeInt(country_id);
        dest.writeString(comany_address);
        dest.writeInt(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<company> CREATOR = new Creator<company>() {
        @Override
        public company createFromParcel(Parcel in) {
            return new company(in);
        }

        @Override
        public company[] newArray(int size) {
            return new company[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getComany_address() {
        return comany_address;
    }

    public void setComany_address(String comany_address) {
        this.comany_address = comany_address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
