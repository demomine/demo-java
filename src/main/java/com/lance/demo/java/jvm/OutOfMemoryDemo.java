package com.lance.demo.java.jvm;

import java.util.ArrayList;
import java.util.List;


public class OutOfMemoryDemo {
    private int i;

    /**
     * VM参数 : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    public void heap() {
        List<OutOfMemoryDemo> list = new ArrayList<>();
        while (true) {
            list.add(new OutOfMemoryDemo());
        }
    }

    /**
     * VM参数 : -Xss128k
     */
    public void stack() {
        i++;
        stack();
    }
}
