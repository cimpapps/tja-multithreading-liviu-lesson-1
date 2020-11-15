package com.thejavacademy;

public class SynchronizedOnDifferentMonitors {
    public static void main(String[] args) {
        SyncOnDifferentIncrementor incrementor = new SyncOnDifferentIncrementor();
        Thread incThread = new Thread(() -> incrementor.incrementAndSleep3(10));
        Thread getNrThread = new Thread(() -> System.out.println(incrementor.getNumber()));

        // getNumber and incrementNumber can execute in parallel because they are synchronized on different monitors
        incThread.start();
        getNrThread.start();
    }
}

class SyncOnDifferentIncrementor {
    private int number;

    public void incrementAndSleep3(int nr) {
        synchronized (this) {
            System.out.println("incrementing the number");
            pause();
            number = number + nr;
            System.out.println("finished incremention");
        }
    }

    public int getNumber() {
        synchronized (SyncOnDifferentIncrementor.class) {
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
