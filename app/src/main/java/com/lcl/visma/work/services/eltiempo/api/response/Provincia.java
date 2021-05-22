package com.lcl.visma.work.services.eltiempo.api.response;

import com.google.gson.annotations.SerializedName;

public class Provincia {
    @SerializedName("NOMBRE_PROVINCIA")
    private String nombre;
    @SerializedName("CODAUTON")
    private String cod_autonomia;
    @SerializedName("COMUNIDAD_CIUDAD_AUTONOMA")
    private String comunidad_ciudad_autonoma;
    @SerializedName("CAPITAL_PROVINCIA")
    private String capital_provincia;
    @SerializedName("CODPROV")
    private String cod;

    public String getNombre() {
        return nombre;
    }

    public String getCod_autonomia() {
        return cod_autonomia;
    }

    public String getComunidad_ciudad_autonoma() {
        return comunidad_ciudad_autonoma;
    }

    public String getCapital_provincia() {
        return capital_provincia;
    }

    public String getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                ", cod_autonomia='" + cod_autonomia + '\'' +
                ", comunidad_ciudad_autonoma='" + comunidad_ciudad_autonoma + '\'' +
                ", capital_provincia='" + capital_provincia + '\'' +
                ", cod='" + cod + '\'' +
                '}';
    }
}

