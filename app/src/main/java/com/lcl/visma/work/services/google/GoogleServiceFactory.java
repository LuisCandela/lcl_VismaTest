package com.lcl.visma.work.services.google;

import com.lcl.visma.work.services.google.impl.GoogleServiceImpl;

/**
 * class to return the same instance of GoogleService
 */
public class GoogleServiceFactory {

    private static GoogleService gglServ;

    /**
     * method to create and return the same instance of GoogleService
     * @return GoogleService
     */
    public static GoogleService getInstance(){
        if(gglServ == null){
            gglServ = new GoogleServiceImpl();
        }
        return gglServ;
    }
}
