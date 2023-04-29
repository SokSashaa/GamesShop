package com.example.lavanda;

import android.widget.ImageView;

public class PrAdapter {
    private String[] imageView;
    private String[] name;
    private String[] price;

    public PrAdapter(String[] imageView,String[] name,String[] price)
    {
        this.imageView = imageView;
        this.name = name;
        this.price = price;
    }

    public String getName(int index)
    {
        return this.name[index];
    }
    public String[] getNames()
    {
        return this.name;
    }

    public String[] getImageViews() {
        return this.imageView;
    }

    public String getImageViews(int index) {
        return this.imageView[index];
    }

    public String[] getPrice() {
        return this.price;
    }

    public String getPrice(int index) {
        return this.price[index];
    }

    public void setName(String name,int index) {
        this.name[index] = name;
    }

    public void setPrice(String price,int index) {
        this.price[index] = price;
    }

    public void setImageView(String imageView,int index) {
        this.imageView[index] = imageView;
    }
}
