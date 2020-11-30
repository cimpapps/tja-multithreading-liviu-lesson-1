package com.thejavacademy.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsWithCallables {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);

        Future<String> threadFuture = executor.submit(() -> {
            // ccalcule si iarasi calcule
            System.out.println("salut inainte de sleep");
            Thread.sleep(1000);
            // TransactionList
            System.out.println("salut Liviu");
            return Thread.currentThread().getName();
        });

        System.out.println(threadFuture.isDone());
        System.out.println("Salut catalin");
        System.out.println(threadFuture.get());

        System.out.println("salut dupa get");
        System.out.println(threadFuture.isDone());

        executor.shutdown();
    }
}
