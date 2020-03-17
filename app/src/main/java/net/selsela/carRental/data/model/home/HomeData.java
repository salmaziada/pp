
package net.selsela.carRental.data.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeData implements Parcelable {

    @SerializedName("total_towers")
    @Expose
    private Integer totalTowers;
    @SerializedName("towers")
    @Expose
    private List<TowerDatum> towerData = null;

    protected HomeData(Parcel in) {
        if (in.readByte() == 0) {
            totalTowers = null;
        } else {
            totalTowers = in.readInt();
        }
        towerData = in.createTypedArrayList(TowerDatum.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (totalTowers == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalTowers);
        }
        dest.writeTypedList(towerData);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeData> CREATOR = new Creator<HomeData>() {
        @Override
        public HomeData createFromParcel(Parcel in) {
            return new HomeData(in);
        }

        @Override
        public HomeData[] newArray(int size) {
            return new HomeData[size];
        }
    };

    public Integer getTotalTowers() {
        return totalTowers;
    }

    public void setTotalTowers(Integer totalTowers) {
        this.totalTowers = totalTowers;
    }

    public List<TowerDatum> getTowerData() {
        return towerData;
    }

    public void setTowerData(List<TowerDatum> towerData) {
        this.towerData = towerData;
    }

}
