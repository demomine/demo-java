package com.lance.demo.java.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBlockingQueueDemoTest {
    @Test
    public void offerPoll() throws Exception {
        ArrayBlockingQueueDemo arrayBlockingQueueDemo = new ArrayBlockingQueueDemo();
        arrayBlockingQueueDemo.offerPoll();
        Thread.sleep(100000L);
    }

    @Test
    public void addRemove() throws Exception {
        ArrayBlockingQueueDemo arrayBlockingQueueDemo = new ArrayBlockingQueueDemo();
        arrayBlockingQueueDemo.addRemove();
        Thread.sleep(100000L);
    }

    @Test
    public void putTake() throws Exception {
        ArrayBlockingQueueDemo arrayBlockingQueueDemo = new ArrayBlockingQueueDemo();
        arrayBlockingQueueDemo.putTake();
        Thread.sleep(100000L);
    }

}