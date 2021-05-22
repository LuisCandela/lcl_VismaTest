package com.lcl.visma.work.services.eltiempo;

import androidx.lifecycle.MutableLiveData;

import com.lcl.visma.work.services.eltiempo.api.response.Provincia;

import java.util.List;

public interface WeatherService {

    /**
     * get the list of Provincias
     * @return MutableLiveData List
     */
    MutableLiveData<List<Provincia>> getLocations();
}
