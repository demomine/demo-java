package com.lance.demo.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    @Test
    public void capacity() throws Exception {
        int a = 100;
        System.out.println( a + (a>>1));
    }

    @Test
    public void addNull() throws Exception {
        List list = new ArrayList();
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());
        System.out.println(list);

    }
}
