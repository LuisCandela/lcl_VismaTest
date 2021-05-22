package com.lcl.visma.work.services.location;

import android.content.Context;
import android.location.Location;

import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.Task;
import com.lcl.visma.work.services.location.api.response.Address;

public interface LocationService {

    /**
     * Provides access to the Fused Location Provider API.
     * @return Task Location
     */
    Task<Location> getLastLocation(Context cntx);

    /**
     * gets location from latitude and longitude
     * @param latitude double
     * @param longitude double
     * @return Location
     */
    MutableLiveData<Address> getLocation(double latitude, double longitude);
}
