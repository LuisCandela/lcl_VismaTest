package com.lcl.visma.work.services.eltiempo.api.response;

import java.util.ArrayList;
import java.util.List;

public class TiempoProvincia {
    private String title;
    private Today today;
    private Tomorrow tomorrow;
    private List<Ciudad> ciudades;
    private Provincia provincia;
    private Comautonoma comautonoma;
    private String metadescripcion;
    private String keywords;

    public TiempoProvincia() {
        this.title = "";
        this.today = new Today();
        this.today.setInformacion("");
        this.tomorrow = new Tomorrow();
        this.tomorrow.setInformacion("");
        this.ciudades = new ArrayList<>();
        this.provincia = new Provincia();
        this.comautonoma = new Comautonoma();
        this.metadescripcion = "";
        this.keywords = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Today getToday() {
        return today;
    }

    public void setToday(Today today) {
        this.today = today;
    }

    public Tomorrow getTomorrow() {
        return tomorrow;
    }

    public void setTomorrow(Tomorrow tomorrow) {
        this.tomorrow = tomorrow;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Comautonoma getComautonoma() {
        return comautonoma;
    }

    public void setComautonoma(Comautonoma comautonoma) {
        this.comautonoma = comautonoma;
    }

    public String getMetadescripcion() {
        return metadescripcion;
    }

    public void setMetadescripcion(String metadescripcion) {
        this.metadescripcion = metadescripcion;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}