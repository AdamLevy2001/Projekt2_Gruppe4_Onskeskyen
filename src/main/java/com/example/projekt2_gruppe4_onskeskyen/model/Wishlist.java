package com.example.projekt2_gruppe4_onskeskyen.model;

public class Wishlist {

    int id;

    String name;

    int userID;

    public Wishlist(int id, String name, int userID) {
        this.id = id;
        this.name = name;
        this.userID = userID;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
