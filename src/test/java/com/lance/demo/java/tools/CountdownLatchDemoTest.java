package com.lance.demo.java.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountdownLatchDemoTest {
    @Test
    public void originalDemo() throws Exception {
        CountdownLatchDemo countdownLatchDemo = new CountdownLatchDemo();
        countdownLatchDemo.originalDemo();
        Thread.sleep(10000L);
    }

    @Test
    public void countdownDemo() throws Exception{
        CountdownLatchDemo countdownLatchDemo = new CountdownLatchDemo();
        countdownLatchDemo.countdownDemo();
        Thread.sleep(10000L);
    }

}