package com.lcl.visma.work.services.eltiempo.impl;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lcl.visma.work.BuildConfig;
import com.lcl.visma.work.services.eltiempo.WeatherService;
import com.lcl.visma.work.services.eltiempo.api.ElTiempoAPI;
import com.lcl.visma.work.services.eltiempo.api.response.Provincia;
import com.lcl.visma.work.services.eltiempo.api.response.Provincias;
import com.lcl.visma.work.services.eltiempo.api.response.TiempoProvincia;

import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * class to getInfo from https://www.el-tiempo.net/api
 */
public class WeatherServiceImpl implements WeatherService {

    private ElTiempoAPI api;

    private MutableLiveData<List<Provincia>> provincias;

    @Inject
    public WeatherServiceImpl(){
        getRetrofitConfiguration();
    }

    @Override
    public MutableLiveData<List<Provincia>> getLocations(){
        // this list of Provincias is not an object that will change a lot in time
        // so we can only make the call once and cache the result on a private field
        if(provincias == null){
            provincias = new MutableLiveData<>();
            api.getInfoProvincias().enqueue(new Callback<Provincias>() {
                @Override
                public void onResponse(Call<Provincias> call, Response<Provincias> response) {
                    provincias.setValue(response.body().getProvincias());
                }

                @Override
                public void onFailure(Call<Provincias> call, Throwable t) {
                    provincias.setValue(null);
                    Log.d("WeatherLocationsError" , "Error retrieving provincias from rest data", t);
                }
            });
        }
        return provincias;
    }

    @Override
    public MutableLiveData<TiempoProvincia> getWeatherInfo(final String codProv) {
        final MutableLiveData<TiempoProvincia> tiempoProvinciaMutableLiveData = new MutableLiveData<>();
        api.getInfoProvincia(codProv).enqueue(new Callback<TiempoProvincia>() {
            @Override
            public void onResponse(Call<TiempoProvincia> call, Response<TiempoProvincia> response) {
                tiempoProvinciaMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<TiempoProvincia> call, Throwable t) {
                tiempoProvinciaMutableLiveData.setValue(null);
                Log.d("LocationsError" , "Error retrieving weather info from rest data", t);
            }
        });
        return tiempoProvinciaMutableLiveData;
    }

    /**
     * init the retrofit config and ElTiempoAPI
     */
    private void getRetrofitConfiguration() {
        Gson gson = new GsonBuilder().setLenient().create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_EL_TIEMPO)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        if (api == null) {
            api = retrofit.create(ElTiempoAPI.class);
        }
    }
}
