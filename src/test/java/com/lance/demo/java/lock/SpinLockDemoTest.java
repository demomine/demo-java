package com.lance.demo.java.lock;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpinLockDemoTest {
    @Test
    public void spin() throws Exception {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        spinLockDemo.spin();
    }

}