package com.thejavacademy.concurrentpackage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class UtilConcurrentPackageJava {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.set(true);

//        int nonAtomic = 0;
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> System.out.println(++nonAtomic)).start();
//
//        }
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(atomicInteger.addAndGet(1))).start();
        }
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(5);
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < atomicIntegerArray.length(); j++) {
                final int k = j;
                new Thread(() -> {
                    System.out.println(atomicIntegerArray.addAndGet(k, 1));
                    System.out.println(atomicIntegerArray);
                }).start();
            }
        }
    }
}


