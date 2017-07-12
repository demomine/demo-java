package com.lance.demo.java.tools;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {
    void originalDemo() throws Exception{

        Thread threadA = new Thread(()-> System.out.println(Thread.currentThread().getName()));
        Thread threadB = new Thread(()-> System.out.println(Thread.currentThread().getName()));

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("execute finish");
    }


    void countdownDemo() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread threadA = new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        Thread threadB = new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        threadA.start();
        threadB.start();
        countDownLatch.await();
        System.out.println("execute finish");
    }


}
