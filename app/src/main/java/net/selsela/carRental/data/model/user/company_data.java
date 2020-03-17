package net.selsela.carRental.data.model.user;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.selsela.carRental.data.model.countries.Country;


public class company_data implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company_name")
    @Expose
    private String company_name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("activation_code")
    @Expose
    private Integer activationCode;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("token_expiration")
    @Expose
    private String tokenExpiration;
    @SerializedName("country_id")
    @Expose
    private int country_id;

    @SerializedName("comany_address")
    @Expose
    private String comany_address;


    @SerializedName("country")
    @Expose
    private Country country;


    /**
     * No args constructor for use in serialization
     */
    public company_data() {
    }

    public company_data(Integer id, String name, String email, String mobile, Integer status, String avatar, Integer activationCode, String token, String tokenExpiration,Country country) {
        super();
        this.id = id;
        this.company_name = name;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.logo = avatar;
        this.activationCode = activationCode;
        this.token = token;
        this.tokenExpiration = tokenExpiration;
        this.country=country;

    }

    protected company_data(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        company_name = in.readString();
        email = in.readString();
        mobile = in.readString();
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readInt();
        }
        logo = in.readString();
        if (in.readByte() == 0) {
            activationCode = null;
        } else {
            activationCode = in.readInt();
        }
        token = in.readString();
        tokenExpiration = in.readString();
        country_id = in.readInt();
        comany_address = in.readString();
        country = in.readParcelable(Country.class.getClassLoader());
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
        dest.writeString(mobile);
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(status);
        }
        dest.writeString(logo);
        if (activationCode == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(activationCode);
        }
        dest.writeString(token);
        dest.writeString(tokenExpiration);
        dest.writeInt(country_id);
        dest.writeString(comany_address);
        dest.writeParcelable(country, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<company_data> CREATOR = new Creator<company_data>() {
        @Override
        public company_data createFromParcel(Parcel in) {
            return new company_data(in);
        }

        @Override
        public company_data[] newArray(int size) {
            return new company_data[size];
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(Integer activationCode) {
        this.activationCode = activationCode;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(String tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }


    @Override
    public String toString() {
        return "company_data{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", logo='" + logo + '\'' +
                ", activationCode=" + activationCode +
                ", token='" + token + '\'' +
                ", tokenExpiration='" + tokenExpiration + '\'' +
                ", country_id=" + country_id +
                ", comany_address='" + comany_address + '\'' +
                ", country='" + country + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof company_data)) return false;

        company_data userData = (company_data) o;

        if (getMobile() != userData.getMobile()) return false;
        if (getId() != null ? !getId().equals(userData.getId()) : userData.getId() != null)
            return false;
        if (getCompany_name() != null ? !getCompany_name().equals(userData.getCompany_name()) : userData.getCompany_name() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(userData.getEmail()) : userData.getEmail() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(userData.getStatus()) : userData.getStatus() != null)
            return false;
        if (getLogo() != null ? !getLogo().equals(userData.getLogo()) : userData.getLogo() != null)
            return false;
        if (getActivationCode() != null ? !getActivationCode().equals(userData.getActivationCode()) : userData.getActivationCode() != null)
            return false;

        if (getCountry() != null ? !getCountry().equals(userData.getCountry()) : userData.getCountry() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(userData.getCountry()) : userData.getCountry() != null)
            return false;
        if (getTokenExpiration() != null ? !getTokenExpiration().equals(userData.getTokenExpiration()) : userData.getTokenExpiration() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCompany_name() != null ? getCompany_name().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getMobile() != null ? getMobile().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getLogo() != null ? getLogo().hashCode() : 0);
        result = 31 * result + (getActivationCode() != null ? getActivationCode().hashCode() : 0);
        result = 31 * result + (getToken() != null ? getToken().hashCode() : 0);
        result = 31 * result + (getTokenExpiration() != null ? getTokenExpiration().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);

        return result;
    }
}

