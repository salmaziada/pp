
package net.selsela.carRental.data.model.invoice;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.selsela.carRental.data.model.config.ContractType;
import net.selsela.carRental.data.model.config.InvoiceStatus;
import net.selsela.carRental.data.model.home.TowerDatum;

public class Invoice implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("invoice_date")
    @Expose
    private String invoiceDate;
    @SerializedName("invoice_value")
    @Expose
    private double invoice_value;
    @SerializedName("contract_id")
    @Expose
    private Integer contractId;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("inv_status_id")
    @Expose
    private Integer invStatusId;
    @SerializedName("invoice_type")
    @Expose
    private String invoiceType;
    @SerializedName("invoice_title")
    @Expose
    private String invoiceTitle;
    @SerializedName("payment_type")
    @Expose
    private Integer paymentType;
    @SerializedName("is_knet")
    @Expose
    private Integer isKnet;
    @SerializedName("knet_token")
    @Expose
    private String knetToken;
    @SerializedName("knet_response_id")
    @Expose
    private Integer knetResponseId;
    @SerializedName("is_payed")
    @Expose
    private Integer isPayed;
    @SerializedName("file")
    @Expose
    private Object file;
    @SerializedName("paid_to")
    @Expose
    private Object paidTo;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;


    @SerializedName("contract_type")
    @Expose
    private ContractType contract_type;
    @SerializedName("tower")
    @Expose
    private TowerDatum tower;
    @SerializedName("remain_days")
    @Expose
    private Integer remainDays;
    @SerializedName("contract_title")
    @Expose
    private String contractTitle;
    @SerializedName("created_at_text")
    @Expose
    private String createdAtText;
    @SerializedName("knet_url")
    @Expose
    private String knetUrl;
    @SerializedName("client_name")
    @Expose
    private String clientName;
    @SerializedName("status")
    @Expose
    private InvoiceStatus status;

    @SerializedName("flat_number")
    @Expose
    private int flat_number;

    @SerializedName("floor_number")
    @Expose
    private int floor_number;
    @SerializedName("tower_name")
    @Expose
    private String tower_name;

    @SerializedName("invoice")
    @Expose
    private Invoice invoice = null;

    protected Invoice(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        invoiceDate = in.readString();
        invoice_value = in.readDouble();
        if (in.readByte() == 0) {
            contractId = null;
        } else {
            contractId = in.readInt();
        }
        if (in.readByte() == 0) {
            ownerId = null;
        } else {
            ownerId = in.readInt();
        }
        if (in.readByte() == 0) {
            invStatusId = null;
        } else {
            invStatusId = in.readInt();
        }
        invoiceType = in.readString();
        invoiceTitle = in.readString();
        if (in.readByte() == 0) {
            paymentType = null;
        } else {
            paymentType = in.readInt();
        }
        if (in.readByte() == 0) {
            isKnet = null;
        } else {
            isKnet = in.readInt();
        }
        knetToken = in.readString();
        if (in.readByte() == 0) {
            knetResponseId = null;
        } else {
            knetResponseId = in.readInt();
        }
        if (in.readByte() == 0) {
            isPayed = null;
        } else {
            isPayed = in.readInt();
        }
        updatedAt = in.readString();
        createdAt = in.readString();
        contract_type = in.readParcelable(ContractType.class.getClassLoader());
        tower = in.readParcelable(TowerDatum.class.getClassLoader());
        if (in.readByte() == 0) {
            remainDays = null;
        } else {
            remainDays = in.readInt();
        }
        contractTitle = in.readString();
        createdAtText = in.readString();
        knetUrl = in.readString();
        clientName = in.readString();
        status = in.readParcelable(InvoiceStatus.class.getClassLoader());
        flat_number = in.readInt();
        floor_number = in.readInt();
        tower_name = in.readString();
        invoice = in.readParcelable(Invoice.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(invoiceDate);
        dest.writeDouble(invoice_value);
        if (contractId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(contractId);
        }
        if (ownerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ownerId);
        }
        if (invStatusId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(invStatusId);
        }
        dest.writeString(invoiceType);
        dest.writeString(invoiceTitle);
        if (paymentType == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(paymentType);
        }
        if (isKnet == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isKnet);
        }
        dest.writeString(knetToken);
        if (knetResponseId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(knetResponseId);
        }
        if (isPayed == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isPayed);
        }
        dest.writeString(updatedAt);
        dest.writeString(createdAt);
        dest.writeParcelable(contract_type, flags);
        dest.writeParcelable(tower, flags);
        if (remainDays == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(remainDays);
        }
        dest.writeString(contractTitle);
        dest.writeString(createdAtText);
        dest.writeString(knetUrl);
        dest.writeString(clientName);
        dest.writeParcelable(status, flags);
        dest.writeInt(flat_number);
        dest.writeInt(floor_number);
        dest.writeString(tower_name);
        dest.writeParcelable(invoice, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Invoice> CREATOR = new Creator<Invoice>() {
        @Override
        public Invoice createFromParcel(Parcel in) {
            return new Invoice(in);
        }

        @Override
        public Invoice[] newArray(int size) {
            return new Invoice[size];
        }
    };

    public int getFlat_number() {
        return flat_number;
    }

    public void setFlat_number(int flat_number) {
        this.flat_number = flat_number;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getInvoice_value() {
        return invoice_value;
    }

    public void setInvoice_value(double invoice_value) {
        this.invoice_value = invoice_value;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getInvStatusId() {
        return invStatusId;
    }

    public void setInvStatusId(Integer invStatusId) {
        this.invStatusId = invStatusId;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getIsKnet() {
        return isKnet;
    }

    public void setIsKnet(Integer isKnet) {
        this.isKnet = isKnet;
    }

    public String getKnetToken() {
        return knetToken;
    }

    public void setKnetToken(String knetToken) {
        this.knetToken = knetToken;
    }

    public Integer getKnetResponseId() {
        return knetResponseId;
    }

    public void setKnetResponseId(Integer knetResponseId) {
        this.knetResponseId = knetResponseId;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    public Object getFile() {
        return file;
    }

    public void setFile(Object file) {
        this.file = file;
    }

    public Object getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(Object paidTo) {
        this.paidTo = paidTo;
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

    public TowerDatum getTower() {
        return tower;
    }

    public void setTower(TowerDatum tower) {
        this.tower = tower;
    }

    public Integer getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(Integer remainDays) {
        this.remainDays = remainDays;
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    public String getCreatedAtText() {
        return createdAtText;
    }

    public void setCreatedAtText(String createdAtText) {
        this.createdAtText = createdAtText;
    }

    public String getKnetUrl() {
        return knetUrl;
    }

    public void setKnetUrl(String knetUrl) {
        this.knetUrl = knetUrl;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public String getTower_name() {
        return tower_name;
    }

    public ContractType getContract_type() {
        return contract_type;
    }

    public void setContract_type(ContractType contract_type) {
        this.contract_type = contract_type;
    }

    public void setTower_name(String tower_name) {
        this.tower_name = tower_name;
    }
}
