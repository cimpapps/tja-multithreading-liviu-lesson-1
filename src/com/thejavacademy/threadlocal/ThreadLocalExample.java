package com.thejavacademy.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal<AtomicInteger> threadLocal = ThreadLocal.withInitial(() -> new AtomicInteger(10));

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                AtomicInteger atomicInteger = threadLocal.get();
                System.out.println(atomicInteger);
                System.out.println(atomicInteger.addAndGet(10));
            }).start();
        }
    }
}
