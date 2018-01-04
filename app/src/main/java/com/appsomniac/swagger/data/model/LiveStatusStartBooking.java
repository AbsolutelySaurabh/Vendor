package com.appsomniac.swagger.data.model;

/**
 * Created by absolutelysaurabh on 23/12/17.
 */

public class LiveStatusStartBooking {

    private String name;
    private String date;
    private String time;
    private String amount;

    public LiveStatusStartBooking(String name, String date, String time, String amount){
        this.name = name;
        this.date = date;
        this.time = time;
        this.amount = amount;

    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getAmount(){
        return amount;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setAmount(String amount){
        this.amount = amount;
    }

}
