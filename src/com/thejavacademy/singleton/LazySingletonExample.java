package com.thejavacademy.singleton;

public class LazySingletonExample {

    private static volatile LazySingletonExample SINGLETON = null;

    private LazySingletonExample() {
    }

    public static LazySingletonExample getInstance() {
        if (SINGLETON == null) {
            synchronized (LazySingletonExample.class) {
                if (SINGLETON == null) {
                    SINGLETON = new LazySingletonExample();
                }
            }
        }
        return SINGLETON;
    }

    public void doSomething() {
        System.out.println("I am doing something");
    }
}
