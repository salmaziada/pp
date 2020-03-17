
package net.selsela.carRental.data.model.config;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlatStatus implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("invoices")
    @Expose
    private Object invoices;
    @SerializedName("name")
    @Expose
    private String name;

    protected FlatStatus(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
    }

    public static final Creator<FlatStatus> CREATOR = new Creator<FlatStatus>() {
        @Override
        public FlatStatus createFromParcel(Parcel in) {
            return new FlatStatus(in);
        }

        @Override
        public FlatStatus[] newArray(int size) {
            return new FlatStatus[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getInvoices() {
        return invoices;
    }

    public void setInvoices(Object invoices) {
        this.invoices = invoices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        dest.writeString(name);
    }
}
