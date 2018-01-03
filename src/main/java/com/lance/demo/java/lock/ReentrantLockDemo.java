package com.lance.demo.java.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    ReentrantLock lock = new ReentrantLock();
    private int num = 0;

    public void demo() {
        for (int i = 0; i < 10000; i++) {
            new Thread(this::run).start();
        }
    }

    public void run() {
        System.out.println();
        num = num + 1;
        System.out.println(num);
    }
}
