package net.selsela.carRental.data.model.user;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserBody implements Parcelable {
    // all update require these two fields
    @SerializedName("company_id")
    @Expose
    private int company_id;
    @SerializedName("id")
    @Expose
    private int id;
    //////////////reg
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("confirm_password")
    @Expose
    private String confirm_password;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("flat_id")
    @Expose
    private int flat_id;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("old_password")
    @Expose
    private String old_password;
    @SerializedName("confirm_new_password")
    @Expose
    private String confirm_new_password;
    @SerializedName("new_password")
    @Expose
    private String new_password;

    @SerializedName("problem_id")
    @Expose
    private int problem_id;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("notification_id")
    @Expose
    private int notification_id;

    @SerializedName("country_id")
    @Expose
    private int  country_id;
    @SerializedName("place_id")
    @Expose
    private int  place_id;
    @SerializedName("service_id")
    @Expose
    private int  service_id;
    @SerializedName("tower_id")
    @Expose
    private int tower_id;
    @SerializedName("cost")
    @Expose
    private double cost;




    String local_pass;
    public UserBody() {
    }


    protected UserBody(Parcel in) {
        company_id = in.readInt();
        id = in.readInt();
        token = in.readString();
        name = in.readString();
        username = in.readString();
        password = in.readString();
        email = in.readString();
        mobile = in.readString();
        confirm_password = in.readString();
        key = in.readString();
        type = in.readInt();
        flat_id = in.readInt();
        details = in.readString();
        title = in.readString();
        old_password = in.readString();
        confirm_new_password = in.readString();
        new_password = in.readString();
        problem_id = in.readInt();
        status = in.readInt();
        notification_id = in.readInt();
        country_id = in.readInt();
        place_id = in.readInt();
        service_id = in.readInt();
        tower_id = in.readInt();
        cost = in.readDouble();
        local_pass = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(company_id);
        dest.writeInt(id);
        dest.writeString(token);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(email);
        dest.writeString(mobile);
        dest.writeString(confirm_password);
        dest.writeString(key);
        dest.writeInt(type);
        dest.writeInt(flat_id);
        dest.writeString(details);
        dest.writeString(title);
        dest.writeString(old_password);
        dest.writeString(confirm_new_password);
        dest.writeString(new_password);
        dest.writeInt(problem_id);
        dest.writeInt(status);
        dest.writeInt(notification_id);
        dest.writeInt(country_id);
        dest.writeInt(place_id);
        dest.writeInt(service_id);
        dest.writeInt(tower_id);
        dest.writeDouble(cost);
        dest.writeString(local_pass);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserBody> CREATOR = new Creator<UserBody>() {
        @Override
        public UserBody createFromParcel(Parcel in) {
            return new UserBody(in);
        }

        @Override
        public UserBody[] newArray(int size) {
            return new UserBody[size];
        }
    };

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getTower_id() {
        return tower_id;
    }

    public void setTower_id(int tower_id) {
        this.tower_id = tower_id;
    }

    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailL() {
        return email;
    }

    public void setEmailL(String emailL) {
        this.email = emailL;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public String getConfirm_new_password() {
        return confirm_new_password;
    }

    public void setConfirm_new_password(String confirm_new_password) {
        this.confirm_new_password = confirm_new_password;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getKey() {
        return key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlat_id() {
        return flat_id;
    }

    public void setFlat_id(int flat_id) {
        this.flat_id = flat_id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public String getLocal_pass() {
        return local_pass;
    }

    public void setLocal_pass(String local_pass) {
        this.local_pass = local_pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBody)) return false;

        UserBody userBody = (UserBody) o;

        if (getCompany_id() != userBody.getCompany_id()) return false;
        if (getToken() != null ? !getToken().equals(userBody.getToken()) : userBody.getToken() != null)
            return false;
        if (getName() != null ? !getName().equals(userBody.getName()) : userBody.getName() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(userBody.getUsername()) : userBody.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(userBody.getPassword()) : userBody.getPassword() != null)
            return false;
        if (getEmailL() != null ? !getEmailL().equals(userBody.getEmailL()) : userBody.getEmailL() != null)
            return false;
        if (getMobile() != null ? !getMobile().equals(userBody.getMobile()) : userBody.getMobile() != null)
            return false;
        if (getConfirm_password() != null ? !getConfirm_password().equals(userBody.getConfirm_password()) : userBody.getConfirm_password() != null)
            return false;
        return getKey() != null ? getKey().equals(userBody.getKey()) : userBody.getKey() == null;
    }

    @Override
    public int hashCode() {
        int result = getCompany_id();
        result = 31 * result + (getToken() != null ? getToken().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getEmailL() != null ? getEmailL().hashCode() : 0);
        result = 31 * result + (getMobile() != null ? getMobile().hashCode() : 0);
        result = 31 * result + (getConfirm_password() != null ? getConfirm_password().hashCode() : 0);
        result = 31 * result + (getKey() != null ? getKey().hashCode() : 0);
        return result;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }
}
