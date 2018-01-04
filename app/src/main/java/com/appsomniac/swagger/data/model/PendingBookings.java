package com.appsomniac.swagger.data.model;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class PendingBookings {

    private String guest_name;
    private String date;
    private String time;
    private String amount_to_collect;
    private String services;

    public void PendingBookings(String guest_name, String date, String time, String amount_to_collect, String services) {
        this.date = date;
        this.guest_name = guest_name;
        this.time = time;
        this.amount_to_collect = amount_to_collect;
        this.services = services;
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

    public String getAmount_to_collect(){
        return amount_to_collect;
    }

    public String getServices(){
        return services;
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
    public void setAmount_to_collect(String amount_to_collect){
        this.amount_to_collect = amount_to_collect;
    }

    public void setServices(String services){
        this.services = services;
    }
}
