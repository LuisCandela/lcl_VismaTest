package com.lcl.visma.work.ui;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.lcl.visma.work.services.eltiempo.WeatherService;
import com.lcl.visma.work.services.google.GoogleService;
import com.lcl.visma.work.services.location.LocationService;

@SuppressLint("StaticFieldLeak")
public class BaseViewModel extends ViewModel {

    // declaration of all the variables that might be used on all the ViewModels
    // protected Context cntx;

    // this services should be injected here but hint only suport injection on
    // -Application (mediante @HiltAndroidApp)
    // -Activity
    // -Fragment
    // -View
    // -Service
    // -BroadcastReceiver
    // TODO: see how to move this injection to BaseViewModel :
    // https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419#android-classes
    protected GoogleService gglSrv;
    protected WeatherService wSrv;
   // protected LocationService locSrv;
}
