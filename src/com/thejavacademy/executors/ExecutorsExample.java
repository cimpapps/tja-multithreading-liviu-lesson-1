package com.thejavacademy.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

    public static void main(String[] args) {


        System.out.println(Thread.currentThread());
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newCachedThreadPool();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread());
                }
            });
        }
        System.out.println("Catalin");


        executor.shutdown();
    }
}
