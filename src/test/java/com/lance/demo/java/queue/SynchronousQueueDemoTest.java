package com.lance.demo.java.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class SynchronousQueueDemoTest {
    @Test
    public void putTake() throws Exception {
        SynchronousQueueDemo synchronousQueueDemo = new SynchronousQueueDemo();
        synchronousQueueDemo.putTake();
        Thread.sleep(10000);
    }

}