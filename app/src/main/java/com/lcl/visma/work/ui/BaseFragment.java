package com.lcl.visma.work.ui;

import androidx.fragment.app.Fragment;

import com.lcl.visma.work.services.eltiempo.WeatherService;
import com.lcl.visma.work.services.google.GoogleService;
import com.lcl.visma.work.services.location.LocationService;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BaseFragment extends Fragment {

    // dont like this solution but from https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419#android-classes
    // En la actualidad, la versión de Hilt admite las siguientes clases de Android:
    // -Application (mediante @HiltAndroidApp)
    // -Activity
    // -Fragment
    // -View
    // -Service
    // -BroadcastReceiver
    // TODO: see how to move this injection to BaseViewModel
    @Inject
    public GoogleService gglSrv;
    @Inject
    public WeatherService wSrv;
  //  @Inject
    public LocationService locSrv;

    public GoogleService getGoogleService() {
        return gglSrv;
    }

    public WeatherService getWeatherService() {
        return wSrv;
    }

    public LocationService getLocationService() {
        return locSrv;
    }
}
