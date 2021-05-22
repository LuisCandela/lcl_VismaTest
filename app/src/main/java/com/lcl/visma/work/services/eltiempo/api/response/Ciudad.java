package com.lcl.visma.work.services.eltiempo.api.response;

public class Ciudad {
    private String id;
    private String idProvince;
    private String name;
    private String nameProvince;
    private StateSky stateSky;
    private Temperaturas temperatures;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(String idProvince) {
        this.idProvince = idProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public StateSky getStateSky() {
        return stateSky;
    }

    public void setStateSky(StateSky stateSky) {
        this.stateSky = stateSky;
    }

    public Temperaturas getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(Temperaturas temperatures) {
        this.temperatures = temperatures;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id='" + id + '\'' +
                ", idProvince='" + idProvince + '\'' +
                ", name='" + name + '\'' +
                ", nameProvince='" + nameProvince + '\'' +
                ", stateSky=" + stateSky +
                ", temperatures=" + temperatures +
                '}';
    }
}