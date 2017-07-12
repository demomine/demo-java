package com.lance.demo.java.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class DelayQueueDemoTest {
    @Test
    public void delay() throws Exception {
        DelayQueueDemo delayQueueDemo = new DelayQueueDemo();
        delayQueueDemo.delay();
        Thread.sleep(10000L);
    }
}