package com.thejavacademy.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

    public static void main(String[] args) {

//        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newCachedThreadPool();
//        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000000; i++) {
            executor.submit(() -> System.out.println(Thread.currentThread()));
        }


        executor.shutdown();
    }
}
