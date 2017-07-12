package com.lance.demo.java.tools;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    void cyclicBarrier() throws Exception {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("execute finish" + Thread.currentThread().getName());
        });

        Thread threadA = new DemoThread(cyclicBarrier);
        Thread threadB = new DemoThread(cyclicBarrier);
        threadA.start();
        threadB.start();
        cyclicBarrier.await();
        cyclicBarrier.reset();
        threadA = new DemoThread(cyclicBarrier);
        threadB = new DemoThread(cyclicBarrier);
        threadA.start();
        threadB.start();
        cyclicBarrier.await();


    }

    class DemoThread extends Thread{
        private CyclicBarrier cyclicBarrier;
        DemoThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(new Random().nextInt() +"   " +Thread.currentThread().getName());
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
