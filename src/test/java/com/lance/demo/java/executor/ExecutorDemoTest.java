package com.lance.demo.java.executor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by perdonare on 2017/6/13.
 */
public class ExecutorDemoTest {
    ExecutorDemo executorDemo = new ExecutorDemo();
    @Test
    public void executeSingleThreadExecutor() throws Exception {
        executorDemo.executeSingleThreadExecutor();
    }

}