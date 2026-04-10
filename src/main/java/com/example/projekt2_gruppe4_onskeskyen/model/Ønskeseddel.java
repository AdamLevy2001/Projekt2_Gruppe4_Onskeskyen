package com.example.projekt2_gruppe4_onskeskyen.model;

public class Ønskeseddel {

    int id;

    String navn;

    int userID;

    public Ønskeseddel(int id, String navn, int userID) {
        this.id = id;
        this.navn = navn;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
