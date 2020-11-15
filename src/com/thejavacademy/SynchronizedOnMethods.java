package com.thejavacademy;

public class SynchronizedOnMethods {
    public static void main(String[] args) {
        SyncIncrementor incrementor = new SyncIncrementor();
        Thread incThread = new Thread(() -> incrementor.incrementAndSleep3(10));
        Thread getNrThread = new Thread(() -> System.out.println(incrementor.getNumber()));

        incThread.start();
        //getNumber will not execute in the same time as incrementAndSleep3 because they are synchronized on the same monitor
        getNrThread.start();
    }
}

class SyncIncrementor {
    private int number;

    /*
    synchronized on methods is the same thing as wrapping with synchronized(this) the whole body of the method
     */
    public synchronized void incrementAndSleep3(int nr)  {
        System.out.println("incrementing the number");
        pause();
        number = number + nr;
    }

    public synchronized int getNumber()  {
        System.out.println("getting the number");
        pause();
        return number;
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
