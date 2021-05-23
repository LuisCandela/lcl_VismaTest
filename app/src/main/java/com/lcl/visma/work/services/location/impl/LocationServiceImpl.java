package com.lcl.visma.work.services.location.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lcl.visma.work.BuildConfig;
import com.lcl.visma.work.services.location.LocationService;
import com.lcl.visma.work.services.location.api.LocationAPI;
import com.lcl.visma.work.services.location.api.response.Address;
import com.lcl.visma.work.services.location.api.response.InfoLocation;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * service to obtain the last known location
 * https://developer.android.com/training/location/retrieve-current
 */
public class LocationServiceImpl implements LocationService {

    private LocationAPI api;

    @Inject
    public LocationServiceImpl() { getRetrofitConfiguration(); }

    /**
     * Provides access to the Fused Location Provider API.
     */
    private FusedLocationProviderClient mFusedLocationClient;

    private MutableLiveData<Address> location;

    @SuppressLint("MissingPermission")
    @Override
    public Task<Location> getLastLocation(final Context cntx) {
        if (mFusedLocationClient == null) {
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(cntx);
        }
        return mFusedLocationClient.getLastLocation();
    }

    @Override
    public MutableLiveData<Address> getLocation(final double latitude,final double longitude) {
        location = new MutableLiveData<Address>();
        api.getGeoReverse(latitude, longitude, "jsonv2").enqueue(new Callback<InfoLocation>() {
            @Override
            public void onResponse(Call<InfoLocation> call, Response<InfoLocation> response) {
                if (response.body() != null && response.body().getAddress() != null) {
                    location.setValue(response.body().getAddress());
                }
            }

            @Override
            public void onFailure(Call<InfoLocation> call, Throwable t) {
                Log.e("LocationsError", "Error retrieving address from rest data", t);
            }
        });

        return location;
    }


    /**
     * init the retrofit config and LocationAPI
     */
    private void getRetrofitConfiguration() {
        Gson gson = new GsonBuilder().setLenient().create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_NOMONATIM)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        if (api == null) {
            api = retrofit.create(LocationAPI.class);
        }
    }

}
