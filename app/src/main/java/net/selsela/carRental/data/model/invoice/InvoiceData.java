
package net.selsela.carRental.data.model.invoice;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvoiceData implements Parcelable {



    @SerializedName("invoices")
    @Expose
    private List<Invoice> invoices = null;

    protected InvoiceData(Parcel in) {
        invoices = in.createTypedArrayList(Invoice.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(invoices);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<InvoiceData> CREATOR = new Creator<InvoiceData>() {
        @Override
        public InvoiceData createFromParcel(Parcel in) {
            return new InvoiceData(in);
        }

        @Override
        public InvoiceData[] newArray(int size) {
            return new InvoiceData[size];
        }
    };

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

}
