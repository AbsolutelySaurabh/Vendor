package com.appsomniac.swagger.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by absolutelysaurabh on 8/1/18.
 */

public class EnquiryData {

    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private Boolean success;

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public Boolean getSuccess(){
        return success;
    }
    public void setSuccess(Boolean success){
        this.success = success;
    }
}
