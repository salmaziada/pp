
package net.selsela.carRental.data.model.notification;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("client_id")
    @Expose
    private Integer clientId;
    @SerializedName("company_id")
    @Expose
    private Integer companyId;

    @SerializedName("problem_id")
    @Expose
    private Integer problem_id;
    @SerializedName("is_seen")
    @Expose
    private Integer isSeen;
    @SerializedName("send_at")
    @Expose
    private String sendAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

    @SerializedName("created_at_text")
    @Expose
    private String  created_at_text;

    protected Notification(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        message = in.readString();
        type = in.readString();
        action = in.readString();
        if (in.readByte() == 0) {
            ownerId = null;
        } else {
            ownerId = in.readInt();
        }
        if (in.readByte() == 0) {
            clientId = null;
        } else {
            clientId = in.readInt();
        }
        if (in.readByte() == 0) {
            companyId = null;
        } else {
            companyId = in.readInt();
        }
        if (in.readByte() == 0) {
            problem_id = null;
        } else {
            problem_id = in.readInt();
        }
        if (in.readByte() == 0) {
            isSeen = null;
        } else {
            isSeen = in.readInt();
        }
        sendAt = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        created_at_text = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(title);
        dest.writeString(message);
        dest.writeString(type);
        dest.writeString(action);
        if (ownerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ownerId);
        }
        if (clientId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(clientId);
        }
        if (companyId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(companyId);
        }
        if (problem_id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(problem_id);
        }
        if (isSeen == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isSeen);
        }
        dest.writeString(sendAt);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(created_at_text);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Notification> CREATOR = new Creator<Notification>() {
        @Override
        public Notification createFromParcel(Parcel in) {
            return new Notification(in);
        }

        @Override
        public Notification[] newArray(int size) {
            return new Notification[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public Integer getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(Integer problem_id) {
        this.problem_id = problem_id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getIsSeen() {
        return isSeen;
    }

    public String getCreated_at_text() {
        return created_at_text;
    }

    public void setCreated_at_text(String created_at_text) {
        this.created_at_text = created_at_text;
    }

    public void setIsSeen(Integer isSeen) {
        this.isSeen = isSeen;
    }

    public String getSendAt() {
        return sendAt;
    }

    public void setSendAt(String sendAt) {
        this.sendAt = sendAt;
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

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

}
