package com.appsomniac.swagger.data.model;

/**
 * Created by absolutelysaurabh on 26/12/17.
 */

public class PopUpPendingBookings {

    private String serviceName;
    private String serviceAmount;

    public PopUpPendingBookings(){

    }

    public String getServiceName(){
        return serviceName;
    }

    public String getServiceAmount(){
        return serviceAmount;
    }

    public void setSetviceName(String serviceName){
        this.serviceName = serviceName;
    }
    public void setServiceAmount(String serviceAmount){
        this.serviceAmount = serviceAmount;
    }
}
