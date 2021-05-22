package com.lcl.visma.work.services.eltiempo.api;

import com.lcl.visma.work.services.eltiempo.api.response.Provincias;
import com.lcl.visma.work.services.eltiempo.api.response.TiempoProvincia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ElTiempoAPI {
    @GET("provincias")
    Call<Provincias> getInfoProvincias();

    @GET("provincias/{id}")
    Call<TiempoProvincia> getInfoProvincia(@Path("id") String codprov);
}
