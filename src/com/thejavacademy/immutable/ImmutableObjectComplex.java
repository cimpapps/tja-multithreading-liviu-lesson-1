package com.thejavacademy.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ImmutableObjectComplex {


    public static void main(String[] args) throws CloneNotSupportedException {
        ImmutableObjectComplex liviu = new ImmutableObjectComplex("Liviu", Arrays.asList(new Person(), new Person()));
        liviu.getChildren().get(0).setName("Alexandra");

    }
    private final String name;
    private final List<Person> children;

    public ImmutableObjectComplex(String name, List<Person> children) {
        this.name = name;
        this.children = children;
    }


    public String getName() {
        return name;
    }

    public List<Person> getChildren() throws CloneNotSupportedException {
        List<Person> clonedChildren = new ArrayList<>();
        for (Person child :
                children) {
            clonedChildren.add(child.clone());
        }
        return clonedChildren;
    }

    @Override
    public String toString() {
        return "AllmostImmutableObject{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}

class Person implements Cloneable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person person = new Person();
        person.setName(this.name);
        person.setAge(this.age);
        return person;
    }
}
