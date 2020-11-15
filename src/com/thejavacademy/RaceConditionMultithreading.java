package com.thejavacademy;

public class RaceConditionMultithreading {

    public static void main(String[] args) {
        // This is a counter with race condition, it might miss some value increments, the final value is not predicatable
        CounterWithRaceCondition counter = new CounterWithRaceCondition();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(counter, "Counter with Race Condition " + i);
            t.start();
        }

        //this counter will increment correctly each time, not missing a value, and should lead to 10_000_000
        SafeCounter safeCounter = new SafeCounter();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(safeCounter, "Safe counter " + i);
            t.start();
        }
    }

}

class CounterWithRaceCondition implements Runnable {
    private int counter = 0;

    @Override
    /*
    if multiple thread will share an instance of this CounterWithRaceCondition, then the int counter will try to be
     increased in parallel
     counter++ operation in fact involve 3 operations   READ VALUE -> MODIFY VALUE -> WRITE VALUE
     When Thread1 will modify the counter, but not finally written in memory, Thread2 will read the value without seeing
     the changes from Thread1
     */
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }
        System.out.println(counter + "   " + Thread.currentThread().getName());
    }
}

class SafeCounter implements Runnable {
    private int counter = 0;

    @Override
    //because of synchronized keyword only 1 Thread at a time can execute this method.
    public synchronized void run() {
        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }
        System.out.println(counter + "   " + Thread.currentThread().getName());
    }
}
