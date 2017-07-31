package com.lance.demo.java.thread;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by perdonare on 2017/6/21.
 */
public class ThreadDemoTest {
    ThreadDemo threadDemo = new ThreadDemo();
    @Test
    public void interrupted() throws Exception {
        ThreadDemo.ThreadInstance interrupted = threadDemo.interrupted();
        Thread.sleep(1000l);
        interrupted.interrupt();
        Thread.sleep(1000l);
    }

    @Test
    public void interrupted2() throws Exception {
        ThreadDemo.ThreadInstance2 interrupted = threadDemo.interrupted2();
        Thread.sleep(1000);
        interrupted.interrupt();
        Thread.sleep(1000);
    }


    @Test
    public void interrupted3() throws Exception {
        ThreadDemo.ThreadInstance3 interrupted = threadDemo.interrupted3();
        Thread.sleep(1000);
        interrupted.interrupt();
        Thread.sleep(1000);
    }

    @Test
    public void notifyDemo() throws Exception {
        threadDemo.notifyDemo();
        Thread.sleep(50000);
    }
}