
package net.selsela.carRental.data.model.client_proplem;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Confirm implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("problem_id")
    @Expose
    private Integer problemId;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("company_id")
    @Expose
    private Integer companyId;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("confirmed")
    @Expose
    private String confirmed;
    @SerializedName("rejected")
    @Expose
    private Integer rejected;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    protected Confirm(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            problemId = null;
        } else {
            problemId = in.readInt();
        }
        if (in.readByte() == 0) {
            ownerId = null;
        } else {
            ownerId = in.readInt();
        }
        if (in.readByte() == 0) {
            companyId = null;
        } else {
            companyId = in.readInt();
        }
        if (in.readByte() == 0) {
            cost = null;
        } else {
            cost = in.readInt();
        }
        details = in.readString();
        confirmed = in.readString();
        if (in.readByte() == 0) {
            rejected = null;
        } else {
            rejected = in.readInt();
        }
        updatedAt = in.readString();
        createdAt = in.readString();
    }

    public static final Creator<Confirm> CREATOR = new Creator<Confirm>() {
        @Override
        public Confirm createFromParcel(Parcel in) {
            return new Confirm(in);
        }

        @Override
        public Confirm[] newArray(int size) {
            return new Confirm[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRejected() {
        return rejected;
    }

    public void setRejected(Integer rejected) {
        this.rejected = rejected;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (problemId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(problemId);
        }
        if (ownerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ownerId);
        }
        if (companyId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(companyId);
        }
        if (cost == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cost);
        }
        dest.writeString(details);
        dest.writeString(confirmed);
        if (rejected == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(rejected);
        }
        dest.writeString(updatedAt);
        dest.writeString(createdAt);
    }
}
