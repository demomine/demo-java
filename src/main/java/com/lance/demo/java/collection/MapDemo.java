package com.lance.demo.java.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author perdonare
 */
public class MapDemo {
    Map<Integer, String> hashMap = new HashMap<>();
    Map<Integer, String> treeMap = new TreeMap<>();
    Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
    Map<Integer, String> linkedHashMap2 = new LinkedHashMap<>(16,0.75f,true);

    public void hashDemo(Integer key, String value) {
        hashMap.put(key, value);
    }

    public void treeDemo(Integer key, String value) {
        treeMap.put(key, value);
    }

    public void linkedHashDemo(Integer key, String value) {
        linkedHashMap.put(key, value);
    }

    public void linkedHashDemo2(Integer key, String value) {
        linkedHashMap2.put(key, value);
    }
}
