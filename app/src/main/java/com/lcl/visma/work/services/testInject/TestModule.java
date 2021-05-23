package com.lcl.visma.work.services.testInject;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class TestModule {

    @Binds
    public abstract TestService bindAnalyticsService(
            TestServiceImpl testService
    );
}
