package com.example.demo.entities;

import java.util.*;
import java.util.stream.Collectors;

public class Actor {
    private String name;
    private String forShow;

    public Actor(String name, String forShow) {
        this.name = name;
        this.forShow = forShow;
    }

    public static final List<Actor> getActors = List.of(
            new Actor("saar", "Ozark"),
            new Actor("brio", "Ozark"),
            new Actor("shefa", "Ozark"),
            new Actor("shoshan", "The Crown"),
            new Actor("paamon", "Stranger Things"),
            new Actor("balistit", "Dead to Me"),
            new Actor("bar", "Orange is the New Black")
    );

    public static final List<Actor> getActorsForShow(String show) {
        return getActors.stream().filter(s -> s.forShow.contains(show))
                .collect(Collectors.toList());
    }

    public static final List<Actor> getActorsForShows(List<String> shows) {
        List<Actor> actorsForShows = new ArrayList<>();

        for (String show : shows) {
            actorsForShows.addAll(getActorsForShow(show));
        }

        System.out.println(actorsForShows.get(0).getName());

        return actorsForShows;
    }

    public static final Map<String, List<Actor>> getActorsForShowInMap(Set<String> shows) {
        Map<String, List<Actor>> map = new HashMap<>();

        for (String show : shows) {
            map.put(show, getActorsForShow(show));
        }

        return map;
    }

    public String getName() {
        return name;
    }

    public String getForShowId() {
        return forShow;
    }
}
