package com.thejavacademy.immutable;

import java.util.ArrayList;
import java.util.List;

public class NonImmutableExample {
    public static void main(String[] args) {
        List<String> children = new ArrayList<>();
        children.add("1");
        children.add("2");
        AllmostImmutableObject allmostImmutableObject = new AllmostImmutableObject("Liviu", children);
        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    int k = j;
                    allmostImmutableObject.getChildren().add(String.valueOf(k));
                }
            }).start();
        }


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
        System.out.println(children.size());
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
