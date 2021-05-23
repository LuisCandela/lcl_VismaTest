package com.lcl.visma.work.services.testInject;

import javax.inject.Inject;

public class TestServiceImpl implements TestService{

    private String a = "Hola";

    @Inject
    public TestServiceImpl(){
        a = "Hola2";
    }

    public String getData(){
        return a;
    }
}
