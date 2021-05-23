package com.lcl.visma.work.services.location;

import com.lcl.visma.work.services.location.impl.LocationServiceImpl;

/**
 * @deprecated false Injection. user @Inject
 */
public class LocationFactory {

    private static LocationService lSrv;

    /**
     * method to create and return the same instance of LocationService
     *
     * @return LocationService
     */
    public static LocationService getInstance() {
        if (lSrv == null) {
            lSrv = new LocationServiceImpl();
        }
        return lSrv;
    }
}
