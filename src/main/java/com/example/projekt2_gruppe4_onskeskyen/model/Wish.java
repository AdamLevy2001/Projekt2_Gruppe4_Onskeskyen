package com.example.projekt2_gruppe4_onskeskyen.model;

public class Wish {

    int id;

    String name;

    String description;

    double price;

    String link;

    int wishlist_ID;

    public Wish(int id, String name, String description, double price, String link, int wishlist_ID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.wishlist_ID = wishlist_ID;
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

    public int getWishlist_ID() {
        return wishlist_ID;
    }

    public void setWishlist_ID(int wishlist_ID) {
        this.wishlist_ID = wishlist_ID;
    }
}
