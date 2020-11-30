package com.thejavacademy.singleton;

public class StaticInstanceSingletonExample {
    public static final StaticInstanceSingletonExample SINGLETON = new StaticInstanceSingletonExample();

    private StaticInstanceSingletonExample() {
    }

    public void doSomething() {
        System.out.println("I am doing something");
    }
}
