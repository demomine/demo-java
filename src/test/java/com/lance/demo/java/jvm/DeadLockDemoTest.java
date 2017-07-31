package com.lance.demo.java.jvm;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeadLockDemoTest {
    @Test
    public void dead() throws Exception {
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        deadLockDemo.dead();
        Thread.sleep(10000000);
    }

}