package com.lance.demo.java.queue;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {
    LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(100);
    ExecutorService putExecutor = Executors.newFixedThreadPool(10);
    ExecutorService getExecutor = Executors.newFixedThreadPool(10);

    public void addRemove() throws Exception {
        putExecutor.execute(()->{
            while (true) {
                try {
                    final int count = new Random().nextInt(1000);
                    Thread.sleep(count);
                    linkedBlockingQueue.add(count + "");
                    getExecutor.execute(()-> {
                        try {
                            System.out.println("add " + count + "  " + Thread.currentThread().getName());
                        } catch (NoSuchElementException e) {
                            System.out.println("add error ");
                        }
                    });
                } catch (InterruptedException e) {
                    System.out.println("add error interrupted ");
                }
            }
        });

        getExecutor.execute(()->{
            while (true) {
                final int count = new Random().nextInt(500);
                try {
                    Thread.sleep(count);
                    getExecutor.execute(() -> {
                        try {
                            System.out.println("remove  " + linkedBlockingQueue.remove());
                        } catch (NoSuchElementException e) {
                            System.out.println("remove error ");
                        }
                    });
                } catch (InterruptedException e) {
                    System.out.println("remove error interrupted");
                }

            }

        });

    }


    public void offerPoll() throws Exception {
        putExecutor.execute(()->{
            while (true) {
                try {
                    final int count = new Random().nextInt(1000);
                    Thread.sleep(count);
                    linkedBlockingQueue.offer(count + "");
                    getExecutor.execute(()-> System.out.println(" offer " + count + "  " + Thread.currentThread().getName()));
                } catch (InterruptedException e) {
                    System.out.println("offer error interrupted");
                }
            }
        });

        getExecutor.execute(()->{
            while (true) {
                final int count = new Random().nextInt(500);
                try {
                    Thread.sleep(count);
                    getExecutor.execute(()-> System.out.println(" poll " + linkedBlockingQueue.poll()));
                } catch (InterruptedException e) {
                    System.out.println("poll error interrupted");
                }

            }

        });

    }



    public void putTake() throws Exception {
        putExecutor.execute(()->{
            while (true) {
                try {
                    final int count = new Random().nextInt(1000);
                    Thread.sleep(count);
                    linkedBlockingQueue.put(count + " ");
                    getExecutor.execute(()-> System.out.println("put " + count + "  " + Thread.currentThread().getName()));
                } catch (InterruptedException e) {
                    System.out.println("offer error interrupted");
                }
            }
        });

        getExecutor.execute(()->{
            while (true) {
                final int count = new Random().nextInt(500);
                try {
                    Thread.sleep(count);
                    getExecutor.execute(()-> {
                        try {
                            System.out.println("take  " + linkedBlockingQueue.take());
                        } catch (InterruptedException e) {
                            System.out.println("take error interrupted");
                        }
                    });
                } catch (InterruptedException e) {
                    System.out.println("poll error interrupted");
                }

            }

        });

    }
}
