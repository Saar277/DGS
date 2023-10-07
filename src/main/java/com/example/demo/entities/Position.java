package com.example.demo.entities;

public class Position {
    private int lat;
    private int lon;
    private int alt;

    public Position(int lat, int lon, int alt) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }

    public int getAlt() {
        return alt;
    }
}
