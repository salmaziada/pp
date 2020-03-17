
package net.selsela.carRental.data.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TowerImage implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("img_name")
    @Expose
    private String img_name;

    @SerializedName("tower_id")
    @Expose
    private Integer tower_id;

    /**
     * No args constructor for use in serialization
     *
     */
    public TowerImage() {
    }

    /**
     *
     * @param id
     * @param img_name
     */
    public TowerImage(Integer id, String img_name) {
        super();
        this.id = id;
        this.img_name = img_name;
    }

    protected TowerImage(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        img_name = in.readString();
        if (in.readByte() == 0) {
            tower_id = null;
        } else {
            tower_id = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(img_name);
        if (tower_id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(tower_id);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TowerImage> CREATOR = new Creator<TowerImage>() {
        @Override
        public TowerImage createFromParcel(Parcel in) {
            return new TowerImage(in);
        }

        @Override
        public TowerImage[] newArray(int size) {
            return new TowerImage[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", img_name='" + img_name + '\'' +
                ", tower_id=" + tower_id +
                '}';
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public Integer getTower_id() {
        return tower_id;
    }

    public void setTower_id(Integer tower_id) {
        this.tower_id = tower_id;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(img_name).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TowerImage) == false) {
            return false;
        }
        TowerImage rhs = ((TowerImage) other);
        return new EqualsBuilder().append(id, rhs.id).append(img_name, rhs.img_name).isEquals();
    }

}
