
package net.selsela.carRental.data.model.client_proplem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProblemData implements Parcelable {

    @SerializedName("problems")
    @Expose
    private List<Datum> problems = null;

    protected ProblemData(Parcel in) {
        problems = in.createTypedArrayList(Datum.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(problems);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProblemData> CREATOR = new Creator<ProblemData>() {
        @Override
        public ProblemData createFromParcel(Parcel in) {
            return new ProblemData(in);
        }

        @Override
        public ProblemData[] newArray(int size) {
            return new ProblemData[size];
        }
    };

    public List<Datum> getProblem() {
        return problems;
    }

    public void setProblem(List<Datum> problem) {
        this.problems = problem;
    }
}
