package com.lance.demo.java.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicBarrierDemoTest {
    @Test
    public void cyclicBarrier() throws Exception {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        cyclicBarrierDemo.cyclicBarrier();
        Thread.sleep(10000L);
    }

}