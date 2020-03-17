
package net.selsela.carRental.data.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TowerDatum implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("establish_date")
    @Expose
    private String establishDate;
    @SerializedName("nums_flat")
    @Expose
    private Integer numsFlat;
    @SerializedName("nums_floor")
    @Expose
    private Integer numsFloor;
    @SerializedName("hidden")
    @Expose
    private Integer hidden;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("free_flats")
    @Expose
    private Integer freeFlats;
    @SerializedName("is_available")
    @Expose
    private Integer isAvailable;
    @SerializedName("total_flats")
    @Expose
    private Integer totalFlats;
    @SerializedName("tower_address")
    @Expose
    private String towerAddress;
    @SerializedName("has_problem")
    @Expose
    private Integer hasProblem;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("tower_images")
    @Expose
    private List<TowerImage> towerImages = null;
    @SerializedName("floor")
    @Expose
    private List<Floor> floor = null;


    protected TowerDatum(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        establishDate = in.readString();
        if (in.readByte() == 0) {
            numsFlat = null;
        } else {
            numsFlat = in.readInt();
        }
        if (in.readByte() == 0) {
            numsFloor = null;
        } else {
            numsFloor = in.readInt();
        }
        if (in.readByte() == 0) {
            hidden = null;
        } else {
            hidden = in.readInt();
        }
        if (in.readByte() == 0) {
            ownerId = null;
        } else {
            ownerId = in.readInt();
        }
        if (in.readByte() == 0) {
            freeFlats = null;
        } else {
            freeFlats = in.readInt();
        }
        if (in.readByte() == 0) {
            isAvailable = null;
        } else {
            isAvailable = in.readInt();
        }
        if (in.readByte() == 0) {
            totalFlats = null;
        } else {
            totalFlats = in.readInt();
        }
        towerAddress = in.readString();
        if (in.readByte() == 0) {
            hasProblem = null;
        } else {
            hasProblem = in.readInt();
        }
        image = in.readString();
        name = in.readString();
        address = in.readParcelable(Address.class.getClassLoader());
        towerImages = in.createTypedArrayList(TowerImage.CREATOR);
        floor = in.createTypedArrayList(Floor.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(establishDate);
        if (numsFlat == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numsFlat);
        }
        if (numsFloor == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numsFloor);
        }
        if (hidden == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hidden);
        }
        if (ownerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ownerId);
        }
        if (freeFlats == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(freeFlats);
        }
        if (isAvailable == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isAvailable);
        }
        if (totalFlats == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalFlats);
        }
        dest.writeString(towerAddress);
        if (hasProblem == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hasProblem);
        }
        dest.writeString(image);
        dest.writeString(name);
        dest.writeParcelable(address, flags);
        dest.writeTypedList(towerImages);
        dest.writeTypedList(floor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TowerDatum> CREATOR = new Creator<TowerDatum>() {
        @Override
        public TowerDatum createFromParcel(Parcel in) {
            return new TowerDatum(in);
        }

        @Override
        public TowerDatum[] newArray(int size) {
            return new TowerDatum[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public Integer getNumsFlat() {
        return numsFlat;
    }

    public void setNumsFlat(Integer numsFlat) {
        this.numsFlat = numsFlat;
    }

    public Integer getNumsFloor() {
        return numsFloor;
    }

    public void setNumsFloor(Integer numsFloor) {
        this.numsFloor = numsFloor;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getFreeFlats() {
        return freeFlats;
    }

    public void setFreeFlats(Integer freeFlats) {
        this.freeFlats = freeFlats;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getTotalFlats() {
        return totalFlats;
    }

    public void setTotalFlats(Integer totalFlats) {
        this.totalFlats = totalFlats;
    }

    public String getTowerAddress() {
        return towerAddress;
    }

    public void setTowerAddress(String towerAddress) {
        this.towerAddress = towerAddress;
    }

    public Integer getHasProblem() {
        return hasProblem;
    }

    public void setHasProblem(Integer hasProblem) {
        this.hasProblem = hasProblem;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<TowerImage> getTowerImages() {
        return towerImages;
    }

    public void setTowerImages(List<TowerImage> towerImages) {
        this.towerImages = towerImages;
    }

    public List<Floor> getFloor() {
        return floor;
    }

    public void setFloor(List<Floor> floor) {
        this.floor = floor;
    }

}
