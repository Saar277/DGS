package com.example.demo.entities;

import java.util.List;

public class Bird {
    private Position position;
    private int sensorId;

    public Bird(Position position, int sensorId) {
        this.position = position;
        this.sensorId = sensorId;
    }

    public static final List<Bird> getBirds = List.of(
            new Bird(new Position(1, 2, 3), 1),
            new Bird(new Position(4, 5, 6), 2),
            new Bird(new Position(7, 8, 9), 3),
            new Bird(null, 4)
    );

    public Position getPosition() {
        return position;
    }

    public int getSensorId() {
        return sensorId;
    }
}
