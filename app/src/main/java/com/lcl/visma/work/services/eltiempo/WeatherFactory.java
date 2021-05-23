package com.lcl.visma.work.services.eltiempo;

import com.lcl.visma.work.services.eltiempo.impl.WeatherServiceImpl;

/**
 * @deprecated false Injection. user @Inject
 */
public class WeatherFactory {

    private static WeatherService wServ;

    /**
     * method to create and return the same instance of WeatherService
     *
     * @return WeatherService
     */
    public static WeatherService getInstance() {
        if (wServ == null) {
            wServ = new WeatherServiceImpl();
        }
        return wServ;
    }
}
