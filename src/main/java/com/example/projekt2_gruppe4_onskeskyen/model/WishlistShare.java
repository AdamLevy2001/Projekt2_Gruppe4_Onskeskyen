package com.example.projekt2_gruppe4_onskeskyen.model;

public class WishlistShare {
    private int id;
    private int wishlistId;
    private int userId;

    public WishlistShare(int id, int wishlistId, int userId) {
        this.id=id;
        this.wishlistId=wishlistId;
        this.userId=userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
