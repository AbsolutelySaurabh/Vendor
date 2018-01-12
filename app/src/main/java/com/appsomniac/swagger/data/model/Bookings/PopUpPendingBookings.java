package com.appsomniac.swagger.data.model.Bookings;

import com.google.gson.annotations.SerializedName;

/**
 * Created by absolutelysaurabh on 26/12/17.
 */

public class PopUpPendingBookings {

    @SerializedName("booking_service")
    private String booking_service;
    @SerializedName("booking_amount")
    private String booking_amount;

    public PopUpPendingBookings(){

    }

    public String getBooking_service(){
        return booking_service;
    }

    public String getBooking_amount(){
        return booking_amount;
    }

    public void setSetviceName(String serviceName){
        this.booking_service = serviceName;
    }
    public void setServiceAmount(String serviceAmount){
        this.booking_amount = serviceAmount;
    }
}
