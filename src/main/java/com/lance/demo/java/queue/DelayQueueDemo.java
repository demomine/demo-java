package com.lance.demo.java.queue;

import java.util.Random;
import java.util.concurrent.*;

public class DelayQueueDemo {
    final  long a = System.currentTimeMillis()+5000L;

    public void delay() {
        ExecutorService putExecutor = Executors.newFixedThreadPool(30);
        ExecutorService getExecutor = Executors.newFixedThreadPool(30);
        DelayQueue<CustomerDelayQueue> delayQueue = new DelayQueue<>();
        putExecutor.execute(()->{
            while (true) {
                try {
                    final int count = new Random().nextInt(1000);
                    Thread.sleep(count);
                    putExecutor.execute(()-> {
                        System.out.println("put " + count + " " + Thread.currentThread().getName());
                        delayQueue.put(new CustomerDelayQueue(count));
                    });
                } catch (InterruptedException e) {
                    System.out.println("put error interrupted");
                }
            }
        });


        getExecutor.execute(()->{
            while (true) {
                try {
                    final int count = new Random().nextInt(1000);
                    Thread.sleep(count);
                    putExecutor.execute(()-> {
                        try {
                            System.out.println("take " + delayQueue.take().getCount() + " " + Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            System.out.println("take error interrupted");
                        }
                    });
                } catch (InterruptedException e) {
                    System.out.println("take error interrupted");
                }
            }
        });
    }




    class CustomerDelayQueue implements Delayed{
        private int count;

        public CustomerDelayQueue(int count) {
            this.count = count;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long d =  unit.convert(a - System.currentTimeMillis(),TimeUnit.SECONDS);
            System.out.println("delay: " + d);
            return d;
        }

        @Override
        public int compareTo(Delayed delayed) {
            return Integer.compare(count, ((CustomerDelayQueue) delayed).count);
        }

        public int getCount() {
            return count;
        }
    }
}
