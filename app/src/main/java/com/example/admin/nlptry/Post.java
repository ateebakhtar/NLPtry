package com.example.admin.nlptry;

import com.google.gson.annotations.SerializedName;

public class Post
{
    private int userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String text;

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    private String productName;

    private String brandName;

    private int manufacturingYear;



    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
