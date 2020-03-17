
package net.selsela.carRental.data.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlatService implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("name")
    @Expose
    private String name;

    protected FlatService(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        icon = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(icon);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FlatService> CREATOR = new Creator<FlatService>() {
        @Override
        public FlatService createFromParcel(Parcel in) {
            return new FlatService(in);
        }

        @Override
        public FlatService[] newArray(int size) {
            return new FlatService[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
