package com.appsomniac.swagger.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by absolutelysaurabh on 8/1/18.
 */

public class HomeFragData {

    @SerializedName("recieved_booking_today")
    private String recieved_booking_today;
    @SerializedName("completed_booking_today")
    private String completed_booking_today;
    @SerializedName("pending_booking_today")
    private String pending_booking_today;
    @SerializedName("recieved_booking")
    private String recieved_booking;
    @SerializedName("completed_booking")
    private String completed_booking;
    @SerializedName("pending_booking")
    private String pending_booking;
    @SerializedName("store_rating")
    private String store_rating;
    @SerializedName("review_num")
    private String review_num;
    @SerializedName("success")
    private Boolean success;


    public String getRecieved_booking_today(){
        return recieved_booking_today;
    }

    public String getCompleted_booking_today(){
        return completed_booking_today;
    }
    public String getPending_booking_today(){
        return pending_booking_today;
    }
    public String getCompleted_booking(){
        return completed_booking;
    }
    public String getPending_booking(){
        return pending_booking;
    }
    public String getStore_rating(){
        return store_rating;
    }
    public String getRecieved_booking(){
        return recieved_booking;
    }
    public String getReview_num(){
        return review_num;
    }

    public Boolean getSuccess(){
        return success;
    }

    public void setRecieved_booking_today(String recieved_booking_today){
        this.recieved_booking_today = recieved_booking_today;
    }
    public void setCompleted_booking_today(String completed_booking_today){
        this.completed_booking_today = completed_booking_today;
    }

    public void setPending_booking_today(String pending_booking_today){
        this.pending_booking_today = pending_booking_today;
    }

    public void setRecieved_booking(String recieved_booking){
        this.recieved_booking = recieved_booking;
    }

    public void setCompleted_booking(String recieved_booking_today){
        this.completed_booking = completed_booking;
    }
    public void setPending_booking(String pending_booking){
        this.pending_booking = pending_booking;
    }
    public void setStore_rating(String store_rating){
        this.store_rating = store_rating;
    }
    public void setReview_num(String review_num){
        this.review_num = review_num;
    }
    public void setSuccess(Boolean success){
        this.success = success;
    }

}
