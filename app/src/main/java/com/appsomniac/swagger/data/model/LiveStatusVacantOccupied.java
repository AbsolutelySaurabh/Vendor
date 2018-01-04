package com.appsomniac.swagger.data.model;

/**
 * Created by absolutelysaurabh on 23/12/17.
 */

public class LiveStatusVacantOccupied {

    private String number;
    private String vacantOrOccupied;

    public LiveStatusVacantOccupied(String number, String vacantOrOccupied){

        this.number = number;
        this.vacantOrOccupied = vacantOrOccupied;
    }

    public String getNumber(){
        return number;
    }

    public String getVacantOrOccupied(){
        return vacantOrOccupied;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setVacantOrOccupied(String vacantOrOccupied){
        this.vacantOrOccupied = vacantOrOccupied;
    }

}
