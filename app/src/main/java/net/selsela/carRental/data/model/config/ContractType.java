
package net.selsela.carRental.data.model.config;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContractType implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("invoice_date_control")
    @Expose
    private Integer invoiceDateControl;
    @SerializedName("name")
    @Expose
    private String name;

    protected ContractType(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            invoiceDateControl = null;
        } else {
            invoiceDateControl = in.readInt();
        }
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (invoiceDateControl == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(invoiceDateControl);
        }
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ContractType> CREATOR = new Creator<ContractType>() {
        @Override
        public ContractType createFromParcel(Parcel in) {
            return new ContractType(in);
        }

        @Override
        public ContractType[] newArray(int size) {
            return new ContractType[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceDateControl() {
        return invoiceDateControl;
    }

    public void setInvoiceDateControl(Integer invoiceDateControl) {
        this.invoiceDateControl = invoiceDateControl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
