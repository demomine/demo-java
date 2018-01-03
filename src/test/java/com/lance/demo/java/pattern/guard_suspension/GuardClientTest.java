package com.lance.demo.java.pattern.guard_suspension;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class GuardClientTest {
    GuardClient guardClient = new GuardClient();
    @Test
    public void demo() throws Exception{
        guardClient.demo();

        TimeUnit.SECONDS.sleep(10);
    }
}