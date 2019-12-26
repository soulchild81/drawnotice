package com.soulchild.drawnotice.model;

import lombok.*;

public class Release {
    public String month;
    public String day;
    public String model;
    public String release_type;
    public String image;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRelease_type() {
        return release_type;
    }

    public void setRelease_type(String release_type) {
        this.release_type = release_type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Builder
    public void setRelease(String month , String day , String model , String release_type , String image){
        this.month = month;
        this.day = day+"일";
        this.model = model;
        this.release_type = release_type;
        this.image = image;

    }
}
