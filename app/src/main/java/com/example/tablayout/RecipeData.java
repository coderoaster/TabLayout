package com.example.tablayout;

public class RecipeData {

    String name;
    String imgurl;

    public RecipeData(String name, String imgurl) {
        this.name = name;
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
