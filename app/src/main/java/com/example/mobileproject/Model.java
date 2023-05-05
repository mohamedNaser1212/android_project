package com.example.mobileproject;

public class Model {
    int position;
    String status;
    String name;
    int image;
    String description;

    public Model(String name, int image,String status,String description) {
        this.name = name;
        this.image = image;
        this.status = status;
        this.description=description;
}
}