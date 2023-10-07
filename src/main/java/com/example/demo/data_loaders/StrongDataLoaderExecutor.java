package com.example.demo.data_loaders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class StrongDataLoaderExecutor {
    @Bean(name = "StrongDataLoaderExecutor")
    Executor StrongDataLoaderExecutor() {
        return Executors.newCachedThreadPool();
    }
}
