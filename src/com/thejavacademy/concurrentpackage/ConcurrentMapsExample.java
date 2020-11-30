package com.thejavacademy.concurrentpackage;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentMapsExample {
    public static void main(String[] args) {
        // use ConcurrentHashMap instead of hashmap when sharing maps between threads
        Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        // use ConcurrentSkipListMap instead of TreeMap when sharing maps between threads
        Map<Integer, Integer> connecurrentTreeMap = new ConcurrentSkipListMap<>();


    }
}
