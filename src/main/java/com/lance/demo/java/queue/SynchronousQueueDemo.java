package com.lance.demo.java.queue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    ExecutorService putExecutor = Executors.newFixedThreadPool(10);
    ExecutorService getExecutor = Executors.newFixedThreadPool(10);
    SynchronousQueue<String> stringSynchronousQueue = new SynchronousQueue<>();


    public void putTake() {
        putExecutor.execute(() -> {
            while (true) {
                int count = new Random().nextInt(1000);
                try {
                    Thread.sleep(count);
                    putExecutor.execute(() -> {
                        try {
                            stringSynchronousQueue.put(count + "");
                            System.out.println("put " + count);
                        } catch (InterruptedException e) {
                            System.out.println("put error");
                        }
                    });
                } catch (InterruptedException e) {
                    System.out.println("put error");
                }
            }

        });

        getExecutor.execute(() -> {
            while (true) {
                int count = new Random().nextInt(1000);
                try {
                    Thread.sleep(count);
                    System.out.println(stringSynchronousQueue.take());
                } catch (InterruptedException e) {
                    System.out.println("take error");
                }
            }

        });
    }
}
