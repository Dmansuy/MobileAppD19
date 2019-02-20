package com.dmansuy.lastprojectd19.model.beans.city;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityBean {
    @SerializedName("poste code")
    private String postCode;
    private String country;
    @SerializedName("country abbreviation")
    private String countryAbbreviation;
    private List<PlaceBean> places;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public List<PlaceBean> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceBean> places) {
        this.places = places;
    }
}
