package com.lance.demo.java.thread;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by perdonare on 2017/6/21.
 */
public class ThreadDemoTest {
    @Test
    public void interrupted() throws Exception {
        ThreadDemo threadDemo = new ThreadDemo();
        ThreadDemo.ThreadInstance interrupted = threadDemo.interrupted();
        Thread.sleep(1000l);
        interrupted.interrupt();
        Thread.sleep(1000l);
    }

    @Test
    public void interrupted2() throws Exception {
        ThreadDemo threadDemo = new ThreadDemo();
        ThreadDemo.ThreadInstance2 interrupted = threadDemo.interrupted2();
        Thread.sleep(1000l);
        interrupted.interrupt();
        Thread.sleep(1000l);
    }


    @Test
    public void interrupted3() throws Exception {
        ThreadDemo threadDemo = new ThreadDemo();
        ThreadDemo.ThreadInstance3 interrupted = threadDemo.interrupted3();
        Thread.sleep(1000l);
        interrupted.interrupt();
        Thread.sleep(1000l);
    }
}