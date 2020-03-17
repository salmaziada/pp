
package net.selsela.carRental.data.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutData implements Parcelable {

    @SerializedName("page")
    @Expose
    private Page page;

    protected AboutData(Parcel in) {
    }

    public static final Creator<AboutData> CREATOR = new Creator<AboutData>() {
        @Override
        public AboutData createFromParcel(Parcel in) {
            return new AboutData(in);
        }

        @Override
        public AboutData[] newArray(int size) {
            return new AboutData[size];
        }
    };

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
