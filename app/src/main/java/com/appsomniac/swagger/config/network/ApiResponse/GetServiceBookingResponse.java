package com.appsomniac.swagger.config.network.ApiResponse;

import com.appsomniac.swagger.data.model.Bookings.PopUpPendingBookings;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 10/1/18.
 */

public class GetServiceBookingResponse {

    @SerializedName("data")
    private ArrayList<PopUpPendingBookings> data;
    @SerializedName("success")
    private Boolean success;
    private String message;

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<PopUpPendingBookings> getData() {
        return data;
    }
    public void setData(ArrayList<PopUpPendingBookings> data) {
        this.data = data;
    }

    public Boolean getSuccess() {return success;}
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
