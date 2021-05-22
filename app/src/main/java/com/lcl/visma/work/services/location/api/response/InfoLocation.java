package com.lcl.visma.work.services.location.api.response;

import java.util.List;

public class InfoLocation {

    private int place_id;
    private String licence;
    private String osm_type;
    private int osm_id;
    private String lat;
    private String lon;
    private int place_rank;
    private String category;
    private String type;
    private double importance;
    private String addresstype;
    private String name;
    private String display_name;
    private Address address;
    private List<String> boundingbox;

    public int getPlace_id() {
        return place_id;
    }

    public String getLicence() {
        return licence;
    }

    public String getOsm_type() {
        return osm_type;
    }

    public int getOsm_id() {
        return osm_id;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public int getPlace_rank() {
        return place_rank;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public double getImportance() {
        return importance;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public String getName() {
        return name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getBoundingbox() {
        return boundingbox;
    }
}
