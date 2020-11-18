package com.thejavacademy.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCWithArrayBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<String> sink = new ArrayBlockingQueue<>(5);
        Thread barbat = new Thread(() -> {
            while (true){
            System.out.println(sink.size());
            System.out.println("vreau sa pun vas in chiuveta");
            try {
                sink.put("a");
//                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        });

        Thread femeie = new Thread(() -> {
            while (true) {


                System.out.println(sink.size());
                System.out.println("vreau sa spal");
                try {
                    String dish = sink.take();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        barbat.start();
        femeie.start();

    }
}
