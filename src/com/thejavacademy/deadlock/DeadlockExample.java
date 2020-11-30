package com.thejavacademy.deadlock;

public class DeadlockExample {

    public static void main(String[] args) {

        NumberHolder numberHolder = new NumberHolder();
        NumberHolder numberHolder2 = new NumberHolder();
        Thread thread1 = new Thread(() -> numberHolder.incrementNumber());
        Thread thread2 = new Thread(() -> numberHolder2.getNumber());
        thread1.start();
        thread2.start();

    }

}

class NumberHolder {

    private int numberA;
    private int numberB;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void incrementNumber() {
        System.out.println(Color.GREEN.getColor() + " " + Thread.currentThread() + " trying to get lock a ");
        synchronized (lock1) {
            System.out.println(Color.GREEN.getColor() + " " + Thread.currentThread() + " got lock a ");
            sleep();
            System.out.println(Color.GREEN.getColor() + " " + Thread.currentThread() + " trying to get lock b ");
            synchronized (lock2) {
                System.out.println(Color.GREEN.getColor() + " " + Thread.currentThread() + " got lock b ");
                sleep();
                numberA += numberB;
            }
        }
    }


    public void getNumber() {
        System.out.println(Color.BLUE.getColor() + " " + Thread.currentThread() + " trying to get lock b ");
        synchronized (lock2) {
            System.out.println(Color.BLUE.getColor() + " " + Thread.currentThread() + " got lock b ");
            sleep();
            System.out.println(Color.BLUE.getColor() + " " + Thread.currentThread() + " trying to get lock a ");
            synchronized (lock1) {
                System.out.println(Color.BLUE.getColor() + " " + Thread.currentThread() + " got lock a ");
                sleep();
                numberA += numberB;
                System.out.println(numberA);
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    enum Color {

        // Regular Colors. Normal color, no bold, background color etc.
        BLACK("\033[0;30m"),    // BLACK
        RED("\033[0;31m"),      // RED
        GREEN("\033[0;32m"),    // GREEN
        YELLOW("\033[0;33m"),   // YELLOW
        BLUE("\033[0;34m"),     // BLUE
        MAGENTA("\033[0;35m"),  // MAGENTA
        CYAN("\033[0;36m"),     // CYAN
        WHITE("\033[0;37m");   // WHITE

        private final String color;

        Color(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

}
