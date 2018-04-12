package com.lance.demo.java.nio;

import org.junit.Test;

public class NIODemoTest {

    @Test
    public void server() throws Exception{
        new NIODemo().server();
    }

    @Test
    public void client () throws Exception {
        new NIODemo().client();
    }
}