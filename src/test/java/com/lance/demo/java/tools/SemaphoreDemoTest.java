package com.lance.demo.java.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class SemaphoreDemoTest {
    @Test
    public void semaphore() throws Exception {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        semaphoreDemo.semaphore();
        Thread.sleep(10000L);
    }

}