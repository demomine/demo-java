package com.lance.demo.java.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ReentrantLockDemoTest {

    @Test
    public void demo() throws Exception{
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        reentrantLockDemo.demo();
        TimeUnit.SECONDS.sleep(10);

    }
}