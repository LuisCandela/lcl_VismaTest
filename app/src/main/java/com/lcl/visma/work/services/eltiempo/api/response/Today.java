package com.lcl.visma.work.services.eltiempo.api.response;

import com.google.gson.annotations.SerializedName;

public class Today {
    @SerializedName("p")
    private String informacion;

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}