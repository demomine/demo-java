package com.lance.demo.java.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedBlockingQueueDemoTest {
    LinkedBlockingQueueDemo linkedBlockingQueueDemo = new LinkedBlockingQueueDemo();
    @Test
    public void addRemove() throws Exception {
        linkedBlockingQueueDemo.addRemove();
        Thread.sleep(100000L);
    }

    @Test
    public void offerPoll() throws Exception {
        linkedBlockingQueueDemo.offerPoll();
        Thread.sleep(100000L);
    }

    @Test
    public void putTake() throws Exception {
        linkedBlockingQueueDemo.putTake();
        Thread.sleep(100000L);
    }

}