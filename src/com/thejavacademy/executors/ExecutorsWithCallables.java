package com.thejavacademy.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsWithCallables {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Future<String> threadFuture = executor.submit(() -> Thread.currentThread().getName());

        System.out.println(threadFuture.isDone());
        System.out.println(threadFuture.get());
        System.out.println(threadFuture.isDone());

        executor.shutdown();
    }
}
