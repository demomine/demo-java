package com.lance.demo.java.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapDemoTest {
    MapDemo mapDemo = new MapDemo();
    @Test
    public void hashDemo() throws Exception {
        for (int i = 0; i < 100; i++) {
            mapDemo.hashDemo(i , i + "");
        }
        mapDemo.hashMap.forEach((key,value)-> System.out.println("key: "+ key));
    }

    @Test
    public void treeDemo() throws Exception {
        for (int i = 0; i < 100; i++) {
            mapDemo.treeDemo(i , i + "");
        }
        mapDemo.treeMap.forEach((key,value)-> System.out.println("key: "+ key));
    }

    @Test
    public void linkedHashDemo() throws Exception {
        for (int i = 0; i < 100; i++) {
            mapDemo.linkedHashDemo(i , i + "");
        }
        mapDemo.linkedHashMap.forEach((key,value)-> System.out.println("key: "+ key));
    }

    @Test
    public void linkedHashDemo2() throws Exception {
        for (int i = 0; i < 100; i++) {
            mapDemo.linkedHashDemo2(i , i + "");
        }
        mapDemo.linkedHashMap2.get(3);
        mapDemo.linkedHashMap2.get(3);
        mapDemo.linkedHashMap2.get(2);
        mapDemo.linkedHashMap2.get(9);
        mapDemo.linkedHashMap2.get(7);
        mapDemo.linkedHashMap2.get(3);
        mapDemo.linkedHashMap2.get(3);
        mapDemo.linkedHashMap2.forEach((key,value)-> System.out.println("key: "+ key));
    }
}