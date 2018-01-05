package com.lance.demo.java.pattern.promise;

import java.util.concurrent.TimeUnit;

public class PromiseClient {
    public void demo() {
        Promise<String> promise = new Promise<>();
        Promisor<String> promisor = promise.compute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello promise";
        });

        System.out.println("is done " + promisor.isDone());

        System.out.println("normal work");

        System.out.println("get result " + promisor.getResult());

    }

    public void demoAsync() {
        Promise<String> promise = new Promise<>();
        Promisor<String> promisor = promise.compute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello promise";
        });

        new Thread(() -> {
            System.out.println("thread is done " + promisor.isDone());

            System.out.println("thread normal work");

            System.out.println("thread get result " + promisor.getResult());
        }).start();


        System.out.println("is done " + promisor.isDone());

        System.out.println("normal work");

        System.out.println("get result " + promisor.getResult());

    }
}
