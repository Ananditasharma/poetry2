package com.example.poetry;

public class List_data {
    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    private String poetry;
    private String image;

    public List_data(int id, String title, String shortdesc, double rating, String poetry, String image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.poetry = poetry;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public String getPoetry() {
        return poetry;
    }

    public String getImage() {
        return image;
    }
}
