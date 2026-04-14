package com.example.projekt2_gruppe4_onskeskyen.model;

public class Wish {

    int id;

    String name;

    String description;

    double price;

    String link;

    int wishlistId;

    public Wish() {}

    public Wish(int id, String name, String description, double price, String link, int wishlistId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.wishlistId = wishlistId;
    }

    public Wish(String name, String description, double price, String link, int wishlistId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.wishlistId = wishlistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }
}
