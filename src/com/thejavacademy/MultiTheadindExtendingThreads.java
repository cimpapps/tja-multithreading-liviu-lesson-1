package com.thejavacademy;

public class MultiTheadindExtendingThreads {

    public static void main(String[] args) throws InterruptedException {

        Thread counter1 = new IteratorThead("counter1");
        Thread counter2 = new IteratorThead("counter2");

        //starting threads
        System.out.println("Before starting Threads");
        counter1.start();
        counter2.start();
        System.out.println("After executing start instruction");

        System.out.println(counter1.isAlive()); //will print true
        //Makes Main Thread to wait for counter1 thread to finish execution, after that passes to the next instruction
        counter1.join();
        System.out.println(counter1.isAlive()); // will print FALSE because it was waited to finish execution
        //Makes Main Thread to wait for counter2 thread to finish execution, after that passes to the next instruction
        counter2.join();
        System.out.println("After thread execution");
        // waits for 1000 millis for this thread until
        Thread.currentThread().join(1000);
        System.out.println("Ending main thread "+ Thread.currentThread());
    }
}

class IteratorThead extends Thread {

    public IteratorThead(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration: " + i + " thread " + this.getName());
        }
    }
}
