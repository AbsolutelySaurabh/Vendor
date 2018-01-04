package com.appsomniac.swagger.data.model;

/**
 * Created by absolutelysaurabh on 21/12/17.
 */

public class TodayBookingsHome {

    String number;
    String title;

    public TodayBookingsHome(){

    }

    public TodayBookingsHome(String number, String title){

        this.number = number;
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }
}
