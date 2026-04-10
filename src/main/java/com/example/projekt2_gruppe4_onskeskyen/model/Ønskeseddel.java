package com.example.projekt2_gruppe4_onskeskyen.model;

public class Ønskeseddel {

    int id;

    String navn;

    int user_ID;

    public Ønskeseddel(int id, String navn, int user_ID) {
        this.id = id;
        this.navn = navn;
        this.user_ID = user_ID;
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

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }
}
