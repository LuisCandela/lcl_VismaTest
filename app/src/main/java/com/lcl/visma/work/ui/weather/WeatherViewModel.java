package com.lcl.visma.work.ui.weather;

import android.content.Context;

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
     * method to logOut on google
     */
    public void logOut() {
        gglSrv.logOut();
    }
}