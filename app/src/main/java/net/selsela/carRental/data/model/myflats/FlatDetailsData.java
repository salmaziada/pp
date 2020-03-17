
package net.selsela.carRental.data.model.myflats;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.selsela.carRental.data.model.home.Floor;

import java.util.List;

public class FlatDetailsData implements Parcelable {

    @SerializedName("floor")
    @Expose
    private List<Floor> floor = null;

    protected FlatDetailsData(Parcel in) {
        floor = in.createTypedArrayList(Floor.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(floor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FlatDetailsData> CREATOR = new Creator<FlatDetailsData>() {
        @Override
        public FlatDetailsData createFromParcel(Parcel in) {
            return new FlatDetailsData(in);
        }

        @Override
        public FlatDetailsData[] newArray(int size) {
            return new FlatDetailsData[size];
        }
    };

    public List<Floor> getFloor() {
        return floor;
    }

    public void setFloor(List<Floor> floor) {
        this.floor = floor;
    }
}
