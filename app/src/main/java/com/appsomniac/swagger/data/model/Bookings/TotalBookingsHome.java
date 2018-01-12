package com.appsomniac.swagger.data.model.Bookings;

/**
 * Created by absolutelysaurabh on 21/12/17.
 */

public class TotalBookingsHome {

    String number;
    String title;

    public TotalBookingsHome(){

    }

    public TotalBookingsHome(String number, String title){

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
