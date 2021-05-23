package com.lcl.visma.work.services.eltiempo;

import com.lcl.visma.work.services.eltiempo.impl.WeatherServiceImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class WeatherModule {

    @Binds
    public abstract WeatherService bindWeatherService(
            WeatherServiceImpl wSrv
    );
}
