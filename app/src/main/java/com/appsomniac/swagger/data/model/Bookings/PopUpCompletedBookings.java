package com.appsomniac.swagger.data.model.Bookings;

import com.google.gson.annotations.SerializedName;

/**
 * Created by absolutelysaurabh on 10/1/18.
 */

public class PopUpCompletedBookings {

    @SerializedName("success")
    private Boolean success;
    @SerializedName("message")
    private String message;

    public PopUpCompletedBookings(){

    }

    public String getMessage(){
        return message;
    }

    public Boolean getSuccess(){
        return success;
    }

    public void setSetviceName(String message){
        this.message = message;
    }
    public void setServiceAmount(Boolean success){
        this.success = success;
    }
}
