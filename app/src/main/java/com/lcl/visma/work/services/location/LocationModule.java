package com.lcl.visma.work.services.location;

import com.lcl.visma.work.services.location.impl.LocationServiceImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class LocationModule {

    @Binds
    public abstract LocationService bindWeatherService(
            LocationServiceImpl wSrv
    );
}
