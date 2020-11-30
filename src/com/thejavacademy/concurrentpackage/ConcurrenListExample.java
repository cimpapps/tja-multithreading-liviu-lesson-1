package com.thejavacademy.concurrentpackage;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrenListExample {
    public static void main(String[] args) {

        List<Integer> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 1000; i++) {
            final int k = i;
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {

                    list.add(k);
                }
                System.out.println("After threa " + Thread.currentThread() + " added size is" + list.size());
            }).start();
        }
    }

}
