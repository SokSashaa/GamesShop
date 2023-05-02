package com.example.lavanda;

public class CustomAdapter {

    private String img;
    private String name;
    private String price;

    public CustomAdapter(String imageView, String name, String price)
    {
        this.img = imageView;
        this.name = name;
        this.price = price;
    }

    public String getNames()
    {
        return this.name;
    }

    public String getImageViews() {
        return this.img;
    }


    public String getPrice() {
        return this.price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageView(String imageView) {
        this.img = imageView;
    }
}
