package com.lcl.visma.work.services.eltiempo.api.response;

import com.google.gson.annotations.SerializedName;

public class Comautonoma {
    @SerializedName("ID")
    private String iD;
    @SerializedName("CODAUTON")
    private String cod_auton;
    @SerializedName("CODCOMUN")
    private String cod_comun;
    @SerializedName("NOMBRE")
    private String nombre;

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getCod_auton() {
        return cod_auton;
    }

    public void setCod_auton(String cod_auton) {
        this.cod_auton = cod_auton;
    }

    public String getCod_comun() {
        return cod_comun;
    }

    public void setCod_comun(String cod_comun) {
        this.cod_comun = cod_comun;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}