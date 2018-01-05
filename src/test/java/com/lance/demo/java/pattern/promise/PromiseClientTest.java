package com.lance.demo.java.pattern.promise;

import org.junit.Test;

public class PromiseClientTest {
    PromiseClient promiseClient = new PromiseClient();
    @Test
    public void demo() {
        promiseClient.demo();
    }
    @Test
    public void demoAsync() {
        promiseClient.demoAsync();
    }
}