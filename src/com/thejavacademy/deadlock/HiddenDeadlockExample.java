package com.thejavacademy.deadlock;

public class HiddenDeadlockExample {
    public static void main(String[] args) {

        Person liviu = new Person("Liviu");
        Person catalin = new Person("Catalin");

        new Thread(() -> liviu.sayHello(catalin)).start();
        new Thread(() -> catalin.sayHello(liviu)).start();

    }
}

class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }


    public synchronized void sayHello(Person person) {
        System.out.println(Thread.currentThread() + " has lock for person " + this.name);
        System.out.println(name +" saying hello to " + person.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " has lock for person " + this.name + " and wants the lock for " + person.getName());
        sayHelloBack(person);
    }

    private void sayHelloBack(Person person) {
        System.out.println(Thread.currentThread() + " has lock for person " + this.name);
        System.out.println(Thread.currentThread() + " has lock for person " + this.name + " and wants the lock for " + person.getName());
        person.sayHello(this);
    }

    public String getName() {
        return name;
    }
}
