
package net.selsela.carRental.data.model.client_proplem;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class oneProblemData implements Parcelable {

    @SerializedName("problem")
    @Expose
    private Datum problem = null;

    protected oneProblemData(Parcel in) {
        problem = in.readParcelable(Datum.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(problem, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<oneProblemData> CREATOR = new Creator<oneProblemData>() {
        @Override
        public oneProblemData createFromParcel(Parcel in) {
            return new oneProblemData(in);
        }

        @Override
        public oneProblemData[] newArray(int size) {
            return new oneProblemData[size];
        }
    };

    public Datum getProblem() {
        return problem;
    }

    public void setProblem(Datum problem) {
        this.problem = problem;
    }
}
