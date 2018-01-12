package com.appsomniac.swagger.config.network.ApiResponse;

import com.appsomniac.swagger.data.model.Vendor;
import com.google.gson.annotations.SerializedName;


public class LoginResponse {

    @SerializedName("data")
    private Vendor data;
    @SerializedName("success")
    private Boolean success;
    private String message;

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public Vendor getData() {
        return data;
    }
    public void setData(Vendor data) {
        this.data = data;
    }

    public Boolean getSuccess() {return success;}
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}