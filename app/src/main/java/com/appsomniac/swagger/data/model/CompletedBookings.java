package com.appsomniac.swagger.data.model;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class CompletedBookings {

    private String guest_name;
    private String date;
    private String time;
    private String amount_collected;
    private String user_feedback;

    public void CompletedBookings(String guest_name, String date, String time, String amount_collected, String user_feedback) {
        this.date = date;
        this.guest_name = guest_name;
        this.time = time;
        this.amount_collected = amount_collected;
        this.user_feedback = user_feedback;
    }

    public String getGuest_name(){
        return guest_name;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }

    public String getAmount_collected(){
        return amount_collected;
    }

    public String getUser_feedback(){
        return user_feedback;
    }

    public void setGuest_name(String guest_name){
        this.guest_name = guest_name;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }
    public void setAmount_collected(String amount_collected){
        this.amount_collected = amount_collected;
    }

    public void setUser_feedback(String user_feedback){
        this.user_feedback = user_feedback;
    }

}
