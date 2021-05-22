package com.lcl.visma.work.services.eltiempo;

import androidx.lifecycle.MutableLiveData;

import com.lcl.visma.work.services.eltiempo.api.response.Provincia;
import com.lcl.visma.work.services.eltiempo.api.response.TiempoProvincia;

import java.util.List;

public interface WeatherService {

    /**
     * get the list of Provincias
     * @return MutableLiveData List
     */
    MutableLiveData<List<Provincia>> getLocations();

    /**
     * get the weather info from the given provincia
     * @param codProv provincia identifier
     * @return MutableLiveData TiempoProvincia
     */
    MutableLiveData<TiempoProvincia> getWeatherInfo(String codProv);
}
