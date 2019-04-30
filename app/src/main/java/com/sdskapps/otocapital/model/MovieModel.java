package com.sdskapps.otocapital.model;

public class MovieModel {


    String name,image,back_image,rating,desc;

    public MovieModel(){
        //TODO default constructor
    }

    public MovieModel(String name,String back_image, String image, String rating,String desc) {
        this.name = name;
        this.image = image;
        this.back_image = back_image;
        this.rating = rating;
        this.desc = desc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBack_image() {
        return back_image;
    }

    public void setBack_image(String back_image) {
        this.back_image = back_image;
    }
}
