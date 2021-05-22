package com.lcl.visma.work.ui.weather;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.lcl.visma.work.R;
import com.lcl.visma.work.services.eltiempo.WeatherFactory;
import com.lcl.visma.work.services.eltiempo.WeatherService;
import com.lcl.visma.work.services.eltiempo.api.response.Provincia;
import com.lcl.visma.work.services.eltiempo.api.response.TiempoProvincia;
import com.lcl.visma.work.services.google.GoogleService;
import com.lcl.visma.work.services.google.GoogleServiceFactory;
import com.lcl.visma.work.ui.BaseViewModel;

import java.util.List;

public class WeatherViewModel extends BaseViewModel {

    private Context cntx;

    private MutableLiveData<List<Provincia>> provinciasMutableLiveData;

    // TODO: see dependencies injection
    private GoogleService gglSrv;
    private WeatherService wSrv;

    protected void initViewModel(final Context cntx) {
        this.cntx = cntx;
        gglSrv = GoogleServiceFactory.getInstance();
        wSrv = WeatherFactory.getInstance();

        provinciasMutableLiveData = wSrv.getLocations();
    }

    /**
     * get the fragment header txt.
     */
    public String getHeader(){
       StringBuilder txt = new StringBuilder(cntx.getString(R.string.weather_head_1));
        txt.append(gglSrv.getSignedInName(cntx));
        txt.append(cntx.getString(R.string.weather_head_2));

        return txt.toString();
    }

    public MutableLiveData<List<Provincia>> getProvincias() {
        return provinciasMutableLiveData;
    }

    public MutableLiveData<TiempoProvincia> getWeatherInfo(String codProv) {
        return wSrv.getWeatherInfo(codProv);
    }

    /**
     * method to logOut on google
     */
    public void logOut() {
        gglSrv.logOut();
    }
}