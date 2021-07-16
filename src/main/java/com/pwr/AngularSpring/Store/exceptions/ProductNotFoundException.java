package com.pwr.AngularSpring.Store.exceptions;


public class ProductNotFoundException extends Exception{
    private String msg;

    public ProductNotFoundException(String msg){
        super(msg);
    }

}
