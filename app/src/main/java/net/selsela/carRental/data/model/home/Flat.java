
package net.selsela.carRental.data.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.selsela.carRental.data.model.client_proplem.Datum;
import net.selsela.carRental.data.model.myflats.Sketch;

public class Flat implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("tower_id")
    @Expose
    private Integer towerId;
    @SerializedName("floor_id")
    @Expose
    private Integer floorId;
    @SerializedName("nums_rooms")
    @Expose
    private Integer numsRooms;
    @SerializedName("with_furniture")
    @Expose
    private Integer withFurniture;
    @SerializedName("flat_area")
    @Expose
    private double flatArea;
    @SerializedName("rent_cost")
    @Expose
    private double rentCost;
    @SerializedName("sale_cost")
    @Expose
    private double saleCost;
    @SerializedName("flat_status_id")
    @Expose
    private Integer flatStatusId;
    @SerializedName("tower_name")
    @Expose
    private String towerName;
    @SerializedName("tower_address")
    @Expose
    private String towerAddress;
    @SerializedName("floor_number")
    @Expose
    private String floorNumber;
    @SerializedName("flat_number")
    @Expose
    private String flatNumber;
    @SerializedName("flat_services")
    @Expose
    private List<FlatService> flatServices = null;
    @SerializedName("image")
    @Expose
    private List<Image> images = null;
    @SerializedName("flat_image")
    @Expose
    private String flatImage;
    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("status")
    @Expose
    private Status status;

    @SerializedName("problem")
    @Expose
    private Datum problem;
    @SerializedName("contract_kind")
    @Expose
    private String contract_kind;
    @SerializedName("sketch")
    @Expose
    private List<Sketch> sketch = null;
    @SerializedName(" flat_status_id")
    @Expose
    private int flat_status_id;

    @SerializedName("has_join")
    @Expose
    private int has_join;

    protected Flat(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        label = in.readString();
        if (in.readByte() == 0) {
            towerId = null;
        } else {
            towerId = in.readInt();
        }
        if (in.readByte() == 0) {
            floorId = null;
        } else {
            floorId = in.readInt();
        }
        if (in.readByte() == 0) {
            numsRooms = null;
        } else {
            numsRooms = in.readInt();
        }
        if (in.readByte() == 0) {
            withFurniture = null;
        } else {
            withFurniture = in.readInt();
        }
        flatArea = in.readDouble();
        rentCost = in.readDouble();
        saleCost = in.readDouble();
        if (in.readByte() == 0) {
            flatStatusId = null;
        } else {
            flatStatusId = in.readInt();
        }
        towerName = in.readString();
        towerAddress = in.readString();
        floorNumber = in.readString();
        flatNumber = in.readString();
        flatServices = in.createTypedArrayList(FlatService.CREATOR);
        images = in.createTypedArrayList(Image.CREATOR);
        flatImage = in.readString();
        currency = in.readString();
        status = in.readParcelable(Status.class.getClassLoader());
        problem = in.readParcelable(Datum.class.getClassLoader());
        contract_kind = in.readString();
        sketch = in.createTypedArrayList(Sketch.CREATOR);
        flat_status_id = in.readInt();
        has_join = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(label);
        if (towerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(towerId);
        }
        if (floorId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(floorId);
        }
        if (numsRooms == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numsRooms);
        }
        if (withFurniture == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(withFurniture);
        }
        dest.writeDouble(flatArea);
        dest.writeDouble(rentCost);
        dest.writeDouble(saleCost);
        if (flatStatusId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(flatStatusId);
        }
        dest.writeString(towerName);
        dest.writeString(towerAddress);
        dest.writeString(floorNumber);
        dest.writeString(flatNumber);
        dest.writeTypedList(flatServices);
        dest.writeTypedList(images);
        dest.writeString(flatImage);
        dest.writeString(currency);
        dest.writeParcelable(status, flags);
        dest.writeParcelable(problem, flags);
        dest.writeString(contract_kind);
        dest.writeTypedList(sketch);
        dest.writeInt(flat_status_id);
        dest.writeInt(has_join);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Flat> CREATOR = new Creator<Flat>() {
        @Override
        public Flat createFromParcel(Parcel in) {
            return new Flat(in);
        }

        @Override
        public Flat[] newArray(int size) {
            return new Flat[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFlatArea(double flatArea) {
        this.flatArea = flatArea;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public void setSaleCost(double saleCost) {
        this.saleCost = saleCost;
    }

    public Datum getProblem() {
        return problem;
    }

    public void setProblem(Datum problem) {
        this.problem = problem;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContract_kind() {
        return contract_kind;
    }

    public List<Sketch> getSketch() {
        return sketch;
    }

    public void setSketch(List<Sketch> sketch) {
        this.sketch = sketch;
    }

    public void setContract_kind(String contract_kind) {
        this.contract_kind = contract_kind;
    }

    public Integer getTowerId() {
        return towerId;
    }

    public void setTowerId(Integer towerId) {
        this.towerId = towerId;
    }

    public String getCurrency() {
        return currency;
    }

    public int getFlat_status_id() {
        return flat_status_id;
    }

    public void setFlat_status_id(int flat_status_id) {
        this.flat_status_id = flat_status_id;
    }

    public int getHas_join() {
        return has_join;
    }

    public void setHas_join(int has_join) {
        this.has_join = has_join;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getNumsRooms() {
        return numsRooms;
    }

    public void setNumsRooms(Integer numsRooms) {
        this.numsRooms = numsRooms;
    }

    public Integer getWithFurniture() {
        return withFurniture;
    }

    public void setWithFurniture(Integer withFurniture) {
        this.withFurniture = withFurniture;
    }

    public double getFlatArea() {
        return flatArea;
    }

    public void setFlatArea(Integer flatArea) {
        this.flatArea = flatArea;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Integer rentCost) {
        this.rentCost = rentCost;
    }

    public double getSaleCost() {
        return saleCost;
    }

    public void setSaleCost(Integer saleCost) {
        this.saleCost = saleCost;
    }

    public Integer getFlatStatusId() {
        return flatStatusId;
    }

    public void setFlatStatusId(Integer flatStatusId) {
        this.flatStatusId = flatStatusId;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public String getTowerAddress() {
        return towerAddress;
    }

    public void setTowerAddress(String towerAddress) {
        this.towerAddress = towerAddress;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public List<FlatService> getFlatServices() {
        return flatServices;
    }

    public void setFlatServices(List<FlatService> flatServices) {
        this.flatServices = flatServices;
    }

    public String getFlatImage() {
        return flatImage;
    }

    public void setFlatImage(String flatImage) {
        this.flatImage = flatImage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
