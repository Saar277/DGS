package com.example.demo.fetcher;

import com.example.demo.data_loaders.ActorsDataLoader;
import com.example.demo.entities.Actor;
import com.example.demo.entities.Show;
import com.netflix.graphql.dgs.*;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@DgsComponent
public class ShowFetcher {
    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter, @InputArgument Integer releaseYearFilter) {
        List<Show> shows = Show.getShows;

        if (titleFilter != null) {
            shows = shows.stream().filter(s -> s.getTitle().contains(titleFilter))
                    .collect(Collectors.toList());
        }

        if (releaseYearFilter != null) {
            shows = shows.stream().filter(s -> s.getReleaseYear() == releaseYearFilter)
                    .collect(Collectors.toList());
        }

        return shows;
    }

    @DgsData(parentType = "Show", field = "actors")
    public CompletableFuture<List<Actor>> actorsForShow(DgsDataFetchingEnvironment dfe) {
        DataLoader<String, List<Actor>> dataLoader = dfe.getDataLoader(ActorsDataLoader.class);
        Show show = dfe.getSource();

        return dataLoader.load(show.getTitle());
    }

    //    @DgsData(parentType = "Show", field = "actors")
//    public List<Actor> actors(DgsDataFetchingEnvironment dfe) {
//
//        Show show = dfe.getSource();
//        return Actor.getActorsForShow(show.getTitle());
//    }
}
