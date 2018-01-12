package com.appsomniac.swagger.config.network.ApiResponse;

import com.appsomniac.swagger.data.model.Bookings.Bookings;
import com.appsomniac.swagger.data.model.Vendor;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 10/1/18.
 */

public class BookingsResponse {

    @SerializedName("data")
    private ArrayList<Bookings> data;
    @SerializedName("success")
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<Bookings> getData() {
        return data;
    }

    public void setData(ArrayList<Bookings> data) {
        this.data = data;
    }

}
