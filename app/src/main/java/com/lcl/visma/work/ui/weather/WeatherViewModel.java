package com.lcl.visma.work.ui.weather;

import android.content.Context;

import com.lcl.visma.work.R;
import com.lcl.visma.work.services.google.GoogleService;
import com.lcl.visma.work.services.google.GoogleServiceFactory;
import com.lcl.visma.work.ui.BaseViewModel;

public class WeatherViewModel extends BaseViewModel {

    private Context cntx;

    // TODO: see dependencies injection
    private GoogleService gglSrv;

    protected void initViewModel(final Context cntx) {
        this.cntx = cntx;
        gglSrv = GoogleServiceFactory.getInstance();
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

    /**
     * method to logOut on google
     */
    public void logOut() {
        gglSrv.logOut();
    }
}