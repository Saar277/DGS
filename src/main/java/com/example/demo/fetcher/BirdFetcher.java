package com.example.demo.fetcher;

import com.example.demo.entities.Bird;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class BirdFetcher {
    @DgsQuery
    public List<Bird> birds(@InputArgument Integer sensorId) {
        List<Bird> birds = Bird.getBirds;

        if (sensorId != null) {
            birds = birds.stream().filter(bird -> bird.getSensorId() == sensorId)
                    .collect(Collectors.toList());
        }

        return birds;
    }
}
