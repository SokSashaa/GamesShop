package com.example.lavanda;

public class CustomAdapterForCat {

    private String img;
    private String name;
    private String index;

    public CustomAdapterForCat(String imageView, String name, String index)
    {
        this.img = imageView;
        this.name = name;
        this.index = index;
    }

    public String getNames()
    {
        return this.name;
    }

    public String getImageViews() {
        return this.img;
    }


    public String getIndex() {
        return this.index;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setImageView(String imageView) {
        this.img = imageView;
    }
}
