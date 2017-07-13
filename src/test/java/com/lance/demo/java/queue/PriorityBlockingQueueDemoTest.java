package com.lance.demo.java.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityBlockingQueueDemoTest {
    private PriorityBlockingQueueDemo priorityBlockingQueueDemo = new PriorityBlockingQueueDemo();
    @Test
    public void offerPoll() throws Exception {
        priorityBlockingQueueDemo.offerPoll();
        Thread.sleep(10000L);
    }

}