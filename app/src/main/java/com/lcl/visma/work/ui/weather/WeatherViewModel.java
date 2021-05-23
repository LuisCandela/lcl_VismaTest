package com.lcl.visma.work.ui.weather;

import android.content.Context;
import android.location.Location;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.Task;
import com.lcl.visma.work.R;
import com.lcl.visma.work.services.eltiempo.WeatherFactory;
import com.lcl.visma.work.services.eltiempo.WeatherService;
import com.lcl.visma.work.services.eltiempo.api.response.Provincia;
import com.lcl.visma.work.services.eltiempo.api.response.TiempoProvincia;
import com.lcl.visma.work.services.google.GoogleService;
import com.lcl.visma.work.services.google.GoogleServiceFactory;
import com.lcl.visma.work.services.location.LocationFactory;
import com.lcl.visma.work.services.location.LocationService;
import com.lcl.visma.work.services.location.api.response.Address;
import com.lcl.visma.work.services.permision.PermissionService;
import com.lcl.visma.work.ui.BaseFragment;
import com.lcl.visma.work.ui.BaseViewModel;

import java.util.List;

public class WeatherViewModel extends BaseViewModel {

    private MutableLiveData<List<Provincia>> provinciasMutableLiveData;
    private Context cntx;
    protected void initViewModel(final Context cntx) {
        this.cntx = cntx;
        gglSrv = GoogleServiceFactory.getInstance();
        wSrv = WeatherFactory.getInstance();
        // gglSrv = fragment.getGoogleService();
        // wSrv = fragment.getWeatherService();
        // locSrv = fragment.getLocationService();
        // locSrv = LocationFactory.getInstance();
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
     * checks if the user has given permission to access to location
     * @param activity FragmentActivity
     * @return boolean
     */
    public boolean checkLocationPermission(FragmentActivity activity) {
        if (!PermissionService.isLocationPermissionGranted(activity.getApplicationContext())) {
            return !PermissionService.requestLocationPermissions(activity);
        }
        return true;
    }

    /**
     * ask for the last user location and return an address object from that location.
     * @return MutableLiveData<Address>
     */
    public Task<Location> getCurrentLocation() {
        return LocationFactory.getInstance().getLastLocation(cntx);
       // return locSrv.getLastLocation(cntx);
    }

    public MutableLiveData<Address> getAddress(final Location location) {
        return LocationFactory.getInstance().getLocation(location.getLatitude(), location.getLongitude());
       // return locSrv.getLocation(location.getLatitude(), location.getLongitude());
    }

    /**
     * method to logOut on google
     */
    public void logOut() {
        gglSrv.logOut();
    }
}