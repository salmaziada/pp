package net.selsela.carRental.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import net.selsela.carRental.data.model.countries.Area;
import net.selsela.carRental.data.model.countries.City;
import net.selsela.carRental.data.model.countries.Country;


public class AddressSaved{
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("area")
    @Expose
    private Area area;

    public AddressSaved() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
