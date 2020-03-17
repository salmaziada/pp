
package net.selsela.carRental.data.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Floor implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tower_id")
    @Expose
    private Integer towerId;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("flat")
    @Expose
    private List<Flat> flat = null;

    protected Floor(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            towerId = null;
        } else {
            towerId = in.readInt();
        }
        label = in.readString();
        flat = in.createTypedArrayList(Flat.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (towerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(towerId);
        }
        dest.writeString(label);
        dest.writeTypedList(flat);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Floor> CREATOR = new Creator<Floor>() {
        @Override
        public Floor createFromParcel(Parcel in) {
            return new Floor(in);
        }

        @Override
        public Floor[] newArray(int size) {
            return new Floor[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTowerId() {
        return towerId;
    }

    public void setTowerId(Integer towerId) {
        this.towerId = towerId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Flat> getFlat() {
        return flat;
    }

    public void setFlat(List<Flat> flat) {
        this.flat = flat;
    }

}
