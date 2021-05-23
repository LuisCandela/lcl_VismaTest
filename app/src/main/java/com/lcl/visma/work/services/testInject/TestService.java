package com.lcl.visma.work.services.testInject;

import javax.inject.Inject;

public class TestService {

    private String a = "Hola";

    @Inject
    public TestService(){
        a = "Hola2";
    }

    public String getA(){
        return a;
    }
}
