package com.example.projekt2_gruppe4_onskeskyen.model;

public class Wishlist {

    int id;

    String name;

    int userID;

    String ownerName;

    public Wishlist(int id, String name, int userID) {
        this.id = id;
        this.name = name;
        this.userID = userID;
    }

    public Wishlist(int id, String name, int userID, String ownerName) {
        this.id = id;
        this.name = name;
        this.userID = userID;
        this.ownerName = ownerName;
    }

    public Wishlist(String name, int userID) {
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

    public String getOwnerName(){
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
