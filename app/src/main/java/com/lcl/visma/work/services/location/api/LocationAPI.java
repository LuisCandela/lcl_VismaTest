package com.lcl.visma.work.services.location.api;

import com.lcl.visma.work.services.location.api.response.InfoLocation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocationAPI {

    @GET("reverse.php")
    Call<InfoLocation> getGeoReverse(@Query("lat") double latitude, @Query("lon") double longitude, @Query("format") String format);
}
