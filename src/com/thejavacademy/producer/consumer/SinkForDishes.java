package com.thejavacademy.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

public class SinkForDishes {

    private static final int MAX_SIZE = 5;
    private final Queue<String> dishes = new LinkedList<>();


    public void putDishesIntoSink(String dish) {
        synchronized (dishes) {
            System.out.println(dishes.size());
            System.out.println("Am pus vasul " + dish);
            while (dishes.size() >= MAX_SIZE) {

                System.out.println("Chiuveta e plina, mai repede spalatoreselor "  );
                waitDishes();
            }
            dishes.add(dish);
            dishes.notifyAll();
        }

    }

    public String getDishToWash() {
        synchronized (dishes) {
            System.out.println(dishes.size());
            while (dishes.isEmpty()) {
                System.out.println("Chiuveta e goala, da-mi sens vietii");
                waitDishes();
            }
            String dish = dishes.poll();
            dishes.notifyAll();
            return dish;
        }
    }








    private void waitDishes()  {
        try {
            dishes.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
