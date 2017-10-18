package com.lance.demo.java.collection;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by perdonare on 2017/6/14.
 */
public class ListDemo<E> extends AbstractList<E>{
    private final static int DEFAULT_CAPACITY = 10;

    private int capacity;

    private E[] nodeData;

    private int index = 0;

    public ListDemo() {
        this(DEFAULT_CAPACITY);
    }

    public ListDemo(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public E get(int index) {
        return nodeData[index];
    }

    @Override
    public int size() {
        return nodeData.length;
    }

    @Override
    public boolean add(E e) {
        if (index + 1 >= nodeData.length) {
            capacity = nodeData.length * 2;
            E[] tempData = Arrays.copyOf(nodeData, capacity);
            tempData[nodeData.length] = e;
            nodeData = tempData;
        } else {
            nodeData[index + 1] = e;
        }
        index++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int length = c.size();
        if (index + 1 + c.size() > nodeData.length) {
            capacity = nodeData.length * 2 + c.size();
            E[] tempData = Arrays.copyOf(nodeData, capacity);
            for (int i = nodeData.length; i < nodeData.length + c.size(); i++) {
                //tempData[i] = c.toArray()
            }
        }
        return false;
    }
}
