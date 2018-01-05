package com.lance.demo.java.pattern.two_phase_termination;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TerminateClient {
    private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    private final Producer producer = new Producer();
    private final Consumer consumer = new Consumer();

    public void demo() throws Exception{
        init();
        Thread.sleep(500);
        shutdown();
    }

    private void init() {
        producer.start();
        consumer.start();
    }

    private void shutdown() {

        //生产者线程停止后再停止消费者线程
        producer.terminate(true);
        consumer.terminate();
    }

    private class Consumer extends TerminationThread{
        @Override
        protected void doTerminate() {

        }

        @Override
        protected void doCleanUp(Exception ex) {

        }

        @Override
        protected void doRun() {
            String poll = queue.poll();
            System.out.println(poll);
            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
            } finally {
                terminationToken.reservations.decrementAndGet();
            }

        }
    }

    private class Producer extends TerminationThread{
        private int i = 0;
        @Override
        protected void doTerminate() {

        }

        @Override
        protected void doCleanUp(Exception ex) {

        }

        @Override
        protected void doRun() {
            queue.offer(i+++"");
            this.terminationToken.reservations.incrementAndGet();
        }
    }
}
