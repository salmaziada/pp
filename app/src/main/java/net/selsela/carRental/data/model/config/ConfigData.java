
package net.selsela.carRental.data.model.config;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.selsela.carRental.data.model.home.FlatService;

public class ConfigData implements Parcelable {

    @SerializedName("config")
    @Expose
    private Config config;


    @SerializedName("problem_status")
    @Expose
    private List<ProblemStatus> problemStatus = null;
    @SerializedName("problem_places")
    @Expose
    private List<ProblemPlace> problemPlaces = null;
    @SerializedName("services")
    @Expose
    private List<FlatService> services = null;

    protected ConfigData(Parcel in) {
        config = in.readParcelable(Config.class.getClassLoader());
        problemStatus = in.createTypedArrayList(ProblemStatus.CREATOR);
        problemPlaces = in.createTypedArrayList(ProblemPlace.CREATOR);
        services = in.createTypedArrayList(FlatService.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(config, flags);
        dest.writeTypedList(problemStatus);
        dest.writeTypedList(problemPlaces);
        dest.writeTypedList(services);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ConfigData> CREATOR = new Creator<ConfigData>() {
        @Override
        public ConfigData createFromParcel(Parcel in) {
            return new ConfigData(in);
        }

        @Override
        public ConfigData[] newArray(int size) {
            return new ConfigData[size];
        }
    };

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }





    public List<ProblemStatus> getProblemStatus() {
        return problemStatus;
    }

    public void setProblemStatus(List<ProblemStatus> problemStatus) {
        this.problemStatus = problemStatus;
    }

    public List<ProblemPlace> getProblemPlaces() {
        return problemPlaces;
    }

    public void setProblemPlaces(List<ProblemPlace> problemPlaces) {
        this.problemPlaces = problemPlaces;
    }

    public List<FlatService> getServices() {
        return services;
    }

    public void setServices(List<FlatService> services) {
        this.services = services;
    }
}
