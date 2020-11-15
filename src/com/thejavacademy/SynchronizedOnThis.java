package com.thejavacademy;

public class SynchronizedOnThis {
    public static void main(String[] args) {
        SyncOnThisIncrementor incrementor = new SyncOnThisIncrementor();
        Thread incThread = new Thread(() -> incrementor.incrementAndSleep3(10));
        Thread getNrThread = new Thread(() -> System.out.println(incrementor.getNumber()));

        incThread.start();
        //getNumber will not execute in the same time as incrementAndSleep3 because they are synchronized on the same monitor
        getNrThread.start();
    }
}

class SyncOnThisIncrementor {
    private int number;

    public void incrementAndSleep3(int nr) {
        synchronized (this) {
            System.out.println("incrementing the number");
            pause();
            number = number + nr;
        }
    }

    public int getNumber() {
        synchronized (this) {
            System.out.println("getting the number");
            pause();
            return number;
        }
    }

    private void pause() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
