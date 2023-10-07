package com.example.demo.data_loaders;

import com.example.demo.entities.Actor;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.MappedBatchLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

import static com.example.demo.entities.Actor.*;

@DgsDataLoader(name = "actorsDataLoader")
public class ActorsDataLoader implements MappedBatchLoader<String, List<Actor>> {
    @Autowired
    @Qualifier("StrongDataLoaderExecutor")
    Executor strongExecutor;


    @Override
    public CompletionStage<Map<String, List<Actor>>> load(Set<String> set) {
        return CompletableFuture.supplyAsync(() -> getActorsForShowInMap(set), strongExecutor);
    }
}
