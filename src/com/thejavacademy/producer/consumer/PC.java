package com.thejavacademy.producer.consumer;

import java.util.Random;

public class PC {

    public static void main(String[] args) {

        SinkForDishes sink = new SinkForDishes();
        Barbat barbat = new Barbat(sink);
        Barbat barbat1 = new Barbat(sink);
        Barbat barbat2 = new Barbat(sink);
        Barbat barbat3 = new Barbat(sink);
        Barbat barbat4 = new Barbat(sink);
        Femeie femeie = new Femeie(sink);
        barbat.start();
        barbat1.start();
        barbat2.start();
        barbat3.start();
        barbat4.start();
        femeie.start();

    }

}

class Barbat extends Thread{
    private final Random random = new Random();
    private long startTime;
    private SinkForDishes sink;

    public Barbat(SinkForDishes sink) {
        this.sink = sink;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        long now = System.currentTimeMillis();
        while (now - startTime < 30000) {
            int timeForTask = random.nextInt(5000);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Vreau sa pun vas in chiuveta, vas" + timeForTask );
            sink.putDishesIntoSink("vas" + timeForTask);
            now = System.currentTimeMillis();
        }
    }
}



class Femeie extends Thread{
    private final Random random = new Random();

    private long startTime;
    private SinkForDishes sink;

    public Femeie(SinkForDishes sink) {
        this.sink = sink;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        long now = System.currentTimeMillis();
        while (now - startTime < 30000) {
            int timeForTask = random.nextInt(5000);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("vreau sa spal");
            String dishToWash = sink.getDishToWash();
            System.out.println("Spal vasul " + dishToWash);
            now = System.currentTimeMillis();
        }
    }
}
