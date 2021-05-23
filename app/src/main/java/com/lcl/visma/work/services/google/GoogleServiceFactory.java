package com.lcl.visma.work.services.google;

import com.lcl.visma.work.services.google.impl.GoogleServiceImpl;

/**
 * @deprecated false Injection. user @Inject
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
