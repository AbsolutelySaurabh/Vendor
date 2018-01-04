package com.appsomniac.swagger.data.model;

import java.io.Serializable;

/**
 * Created by Varavut on 9/28/2014.
 */
public class Drawer implements Serializable {
    private String name;
    private String imageUrl;
    private String description;
    private String textColour;

    public Drawer(){

    }

    public Drawer(String name, String imageUrl, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTextColour(){
        return textColour;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTextColour(String textColour){
        this.textColour = textColour;
    }
}
