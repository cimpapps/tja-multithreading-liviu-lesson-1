package com.thejavacademy.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableExample {
    public static void main(String[] args) {
        ImmutableObject allmostImmutableObject = new ImmutableObject("Liviu", Arrays.asList("1", "2"));
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> allmostImmutableObject.getChildren().add(String.valueOf(System.currentTimeMillis())));
        }
        // READ MODIFY WRITE

    }
}

final class ImmutableObject {

    private final String name;
    private final List<String> children;

    public ImmutableObject(String name, List<String> children) {
        this.name = name;
        this.children = children;
    }


    public String getName() {
        return name;
    }

    public List<String> getChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public String toString() {
        return "AllmostImmutableObject{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
