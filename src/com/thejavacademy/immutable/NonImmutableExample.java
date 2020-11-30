package com.thejavacademy.immutable;

import java.util.Arrays;
import java.util.List;

public class NonImmutableExample {
    public static void main(String[] args) {
        AllmostImmutableObject allmostImmutableObject = new AllmostImmutableObject("Liviu", Arrays.asList("1", "2"));
        new Thread(() -> allmostImmutableObject.getChildren().add(String.valueOf(System.currentTimeMillis())));

    }
}

final class AllmostImmutableObject {

    private final String name;
    private final List<String> children;

    public AllmostImmutableObject(String name, List<String> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public List<String> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "AllmostImmutableObject{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
