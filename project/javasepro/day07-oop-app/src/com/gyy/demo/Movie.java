package com.gyy.demo;

public class Movie {
    private int id;
    private String title;
    private double price;
    private double score;
    private String director;
    private String actor;
    private double count;

    public Movie() {
    }

    public Movie(int id, String title, double price, double score, String director, String actor, double count) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.score = score;
        this.director = director;
        this.actor = actor;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}