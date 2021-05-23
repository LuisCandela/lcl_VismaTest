package com.lcl.visma.work.services.google;

import com.lcl.visma.work.services.google.impl.GoogleServiceImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class GoogleModule {

    @Binds
    public abstract GoogleService bindGoogleService(
            GoogleServiceImpl gglSrv
    );
}
