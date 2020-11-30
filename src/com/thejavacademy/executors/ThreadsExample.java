package com.thejavacademy.executors;


public class ThreadsExample {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            new Thread(() -> System.out.println(Thread.currentThread())).start();
        }

    }
}
