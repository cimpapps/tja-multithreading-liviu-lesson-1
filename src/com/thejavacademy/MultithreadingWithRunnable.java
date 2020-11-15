package com.thejavacademy;

public class MultithreadingWithRunnable {
    public static void main(String[] args) {
//        Runnable iteratorRunnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("Iteration: " + i + " thread " + Thread.currentThread().getName());
//                }
//            }
//        };
//        Runnable iteratorRunnable = () -> IntStream.range(0, 10)
//                .forEach(i -> System.out.println("Iteration: " + i + " thread " + Thread.currentThread().getName()));

        Runnable iteratorRunnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Iteration: " + i + " thread " + Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(iteratorRunnable, "counter1");
        Thread t2 = new Thread(iteratorRunnable, "counter2");
        t1.start();
        t2.start();

    }
}

