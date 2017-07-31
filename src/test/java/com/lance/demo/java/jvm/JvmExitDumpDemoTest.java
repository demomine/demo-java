package com.lance.demo.java.jvm;

import org.junit.Test;

import static org.junit.Assert.*;

public class JvmExitDumpDemoTest {
    @Test
    public void dump() throws Exception {
        JvmExitDumpDemo jvmExitDumpDemo = new JvmExitDumpDemo();
        jvmExitDumpDemo.dump();
        Thread.sleep(10000000L);
    }

}