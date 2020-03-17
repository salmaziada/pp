
package net.selsela.carRental.data.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Image implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("img_name")
    @Expose
    private String img_name;

    @SerializedName("flat_id")
    @Expose
    private Integer flat_id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param id
     * @param img_name
     */
    public Image(Integer id, String img_name) {
        super();
        this.id = id;
        this.img_name = img_name;
    }

    protected Image(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        img_name = in.readString();
        if (in.readByte() == 0) {
            flat_id = null;
        } else {
            flat_id = in.readInt();
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
        if (flat_id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(flat_id);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
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
                ", flat_id=" + flat_id +
                '}';
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public Integer getFlat_id() {
        return flat_id;
    }

    public void setFlat_id(Integer flat_id) {
        this.flat_id = flat_id;
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
        if ((other instanceof Image) == false) {
            return false;
        }
        Image rhs = ((Image) other);
        return new EqualsBuilder().append(id, rhs.id).append(img_name, rhs.img_name).isEquals();
    }

}
