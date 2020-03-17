
package net.selsela.carRental.data.model.notification;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotoficationData implements Parcelable {

    @SerializedName("notifications")
    @Expose
    private List<Notification> notifications = null;

    protected NotoficationData(Parcel in) {
        notifications = in.createTypedArrayList(Notification.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(notifications);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NotoficationData> CREATOR = new Creator<NotoficationData>() {
        @Override
        public NotoficationData createFromParcel(Parcel in) {
            return new NotoficationData(in);
        }

        @Override
        public NotoficationData[] newArray(int size) {
            return new NotoficationData[size];
        }
    };

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

}
