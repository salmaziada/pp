
package net.selsela.carRental.data.model.client_proplem;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import net.selsela.carRental.data.model.config.ProblemPlace;
import net.selsela.carRental.data.model.config.ProblemStatus;
import net.selsela.carRental.data.model.home.Flat;
import net.selsela.carRental.data.model.home.FlatService;

import java.util.List;

public class Datum implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("client_id")
    @Expose
    private Integer clientId;
    @SerializedName("flat_id")
    @Expose
    private Integer flatId;
    @SerializedName("company_id")
    @Expose
    private Integer companyId;
    @SerializedName("tower_id")
    @Expose
    private Integer towerId;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("pro_status_id")
    @Expose
    private Integer proStatusId;
    @SerializedName("service_id")
    @Expose
    private Integer serviceId;
    @SerializedName("place_id")
    @Expose
    private Integer placeId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("service")
    @Expose
    private FlatService service;
    @SerializedName("company")
    @Expose
    private company company;
    @SerializedName("status")
    @Expose
    private ProblemStatus status;
    @SerializedName("place")
    @Expose
    private ProblemPlace place;
    @SerializedName("flat")
    @Expose
    private Flat flat;
    @SerializedName("confirm")
    @Expose
    private List<Confirm> confirm = null;

    protected Datum(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            clientId = null;
        } else {
            clientId = in.readInt();
        }
        if (in.readByte() == 0) {
            flatId = null;
        } else {
            flatId = in.readInt();
        }
        if (in.readByte() == 0) {
            companyId = null;
        } else {
            companyId = in.readInt();
        }
        if (in.readByte() == 0) {
            towerId = null;
        } else {
            towerId = in.readInt();
        }
        details = in.readString();
        if (in.readByte() == 0) {
            proStatusId = null;
        } else {
            proStatusId = in.readInt();
        }
        if (in.readByte() == 0) {
            serviceId = null;
        } else {
            serviceId = in.readInt();
        }
        if (in.readByte() == 0) {
            placeId = null;
        } else {
            placeId = in.readInt();
        }
        createdAt = in.readString();
        updatedAt = in.readString();
        service = in.readParcelable(FlatService.class.getClassLoader());
        company = in.readParcelable(net.selsela.carRental.data.model.client_proplem.company.class.getClassLoader());
        status = in.readParcelable(ProblemStatus.class.getClassLoader());
        place = in.readParcelable(ProblemPlace.class.getClassLoader());
        flat = in.readParcelable(Flat.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (clientId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(clientId);
        }
        if (flatId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(flatId);
        }
        if (companyId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(companyId);
        }
        if (towerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(towerId);
        }
        dest.writeString(details);
        if (proStatusId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(proStatusId);
        }
        if (serviceId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(serviceId);
        }
        if (placeId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(placeId);
        }
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeParcelable(service, flags);
        dest.writeParcelable(company, flags);
        dest.writeParcelable(status, flags);
        dest.writeParcelable(place, flags);
        dest.writeParcelable(flat, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getFlatId() {
        return flatId;
    }

    public void setFlatId(Integer flatId) {
        this.flatId = flatId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getTowerId() {
        return towerId;
    }

    public void setTowerId(Integer towerId) {
        this.towerId = towerId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getProStatusId() {
        return proStatusId;
    }

    public void setProStatusId(Integer proStatusId) {
        this.proStatusId = proStatusId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public List<Confirm> getConfirm() {
        return confirm;
    }

    public void setConfirm(List<Confirm> confirm) {
        this.confirm = confirm;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }



    public company getCompany() {
        return company;
    }

    public void setCompany(company company) {
        this.company = company;
    }

    public ProblemStatus getStatus() {
        return status;
    }

    public void setStatus(ProblemStatus status) {
        this.status = status;
    }

    public FlatService getService() {
        return service;
    }

    public void setService(FlatService service) {
        this.service = service;
    }

    public ProblemPlace getPlace() {
        return place;
    }

    public void setPlace(ProblemPlace place) {
        this.place = place;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

}
