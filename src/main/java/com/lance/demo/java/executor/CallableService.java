package com.lance.demo.java.executor;

import java.util.concurrent.Callable;

/**
 * Created by perdonare on 2017/5/27.
 */
public class CallableService implements Callable<String>{
    private int count;

    public CallableService(int count) {
        this.count = count;
    }

    public String call() throws Exception {
        System.out.println("calling......" + count);
        if (count == 50) {
            throw new Exception("50 error");
        }
        return "a" + count + "a";
    }
}
