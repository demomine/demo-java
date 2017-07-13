package com.lance.demo.java.queue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    PriorityBlockingQueue<CustomerPriorityQueue> priorityBlockingQueue = new PriorityBlockingQueue<>(200);
    ExecutorService putExecutor = Executors.newFixedThreadPool(10);
    ExecutorService getExecutor = Executors.newFixedThreadPool(10);


    public void offerPoll() throws Exception {
        for (int i = 0 ; i <100 ; i ++) {
            final int count = new Random().nextInt(1000);
            putExecutor.execute(()->priorityBlockingQueue.offer(new CustomerPriorityQueue(count)));
        }
        Thread.sleep(2000L);
        for (int i = 0 ; i <100 ; i ++) {
            getExecutor.execute(()-> System.out.println("poll " + priorityBlockingQueue.poll().count));
        }

    }


    class CustomerPriorityQueue implements Comparable<CustomerPriorityQueue> {
        private int count;

        public CustomerPriorityQueue(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(CustomerPriorityQueue o) {
            return Integer.compare(count, o.count);
        }
    }
}

