
package net.selsela.carRental.data.model.myflats;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sketch implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sk_name")
    @Expose
    private String skName;
    @SerializedName("flat_id")
    @Expose
    private Integer flatId;

    protected Sketch(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        skName = in.readString();
        if (in.readByte() == 0) {
            flatId = null;
        } else {
            flatId = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(skName);
        if (flatId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(flatId);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Sketch> CREATOR = new Creator<Sketch>() {
        @Override
        public Sketch createFromParcel(Parcel in) {
            return new Sketch(in);
        }

        @Override
        public Sketch[] newArray(int size) {
            return new Sketch[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkName() {
        return skName;
    }

    public void setSkName(String skName) {
        this.skName = skName;
    }

    public Integer getFlatId() {
        return flatId;
    }

    public void setFlatId(Integer flatId) {
        this.flatId = flatId;
    }

}
