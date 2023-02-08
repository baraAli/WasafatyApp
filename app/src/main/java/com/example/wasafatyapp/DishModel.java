package com.example.wasafatyapp;

public class DishModel {
    String imgUrl;
    String title;
    String dishDesc;
    String videoUrl;
    String id;

    public DishModel(){

    }

    public DishModel(String id, String imgUrl, String title, String descr, String videoUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.title = title;
        this.dishDesc = descr;
        this.videoUrl = videoUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    public String getId() {
        return id;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDishDesc() {
        return dishDesc;
    }

    public void setDishDesc(String dishDesc) {
        this.dishDesc = dishDesc;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
