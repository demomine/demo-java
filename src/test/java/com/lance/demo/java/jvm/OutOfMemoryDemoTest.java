package com.lance.demo.java.jvm;

import org.junit.Test;

public class OutOfMemoryDemoTest {
    OutOfMemoryDemo heapOutOfMemoryDemo = new OutOfMemoryDemo();
    @Test
    public void heap() throws Exception {
        OutOfMemoryDemo heapOutOfMemoryDemo = new OutOfMemoryDemo();
        heapOutOfMemoryDemo.heap();
    }


    @Test
    public void stack() throws Exception {
        heapOutOfMemoryDemo.stack();
    }
}