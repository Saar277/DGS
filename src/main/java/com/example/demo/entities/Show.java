package com.example.demo.entities;

import java.util.List;

public class Show {
    private final String title;
    private final int releaseYear;

    public Show(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public static final List<Show> getShows = List.of(
            new Show("Stranger Things", 2017),
            new Show("Ozark", 2016),
            new Show("The Crown", 2016),
            new Show("Dead to Me", 2019),
            new Show("Orange is the New Black", 2013)
    );

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
