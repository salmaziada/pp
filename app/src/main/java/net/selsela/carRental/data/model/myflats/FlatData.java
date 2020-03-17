
package net.selsela.carRental.data.model.myflats;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import net.selsela.carRental.data.model.home.Flat;

public class FlatData implements Parcelable {

    @SerializedName("flats")
    @Expose
    private List<Flat> flats = null;

    protected FlatData(Parcel in) {
        flats = in.createTypedArrayList(Flat.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(flats);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FlatData> CREATOR = new Creator<FlatData>() {
        @Override
        public FlatData createFromParcel(Parcel in) {
            return new FlatData(in);
        }

        @Override
        public FlatData[] newArray(int size) {
            return new FlatData[size];
        }
    };

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

}
