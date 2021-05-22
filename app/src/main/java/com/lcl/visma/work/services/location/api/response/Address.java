package com.lcl.visma.work.services.location.api.response;

public class Address {
    private String road;
    private String neighbourhood;
    private String village;
    private String municipality;
    private String state;
    private String postcode;
    private String county;
    private String country;
    private String country_code;

    public String getRoad() {
        return road;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getVillage() {
        return village;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCounty() {
        return county;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry_code() {
        return country_code;
    }
}
