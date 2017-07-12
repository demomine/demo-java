package com.lance.demo.java.tools;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public void semaphore() {
        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 10; i++) {
            Thread thread = new DemoThread(semaphore);
            thread.start();
        }
        System.out.println("finish");

    }


    class DemoThread extends Thread{
        Semaphore semaphore;

        DemoThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.println("before " + Thread.currentThread().getName());
                semaphore.acquire(2);
                System.out.println("after " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
