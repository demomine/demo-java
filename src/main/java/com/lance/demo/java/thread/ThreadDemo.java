package com.lance.demo.java.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by perdonare on 2017/6/21.
 */
public class ThreadDemo {
    private final Object object = new Object();
    private int count;
    class ThreadInstance extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("......running....");
                try {
                    sleep(200l);
                } catch (InterruptedException e) {
                    System.out.println(".....sleep interrupted....");
                    interrupted();
                }
            }
        }
    }

    class ThreadInstance2 extends Thread{
        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    i++;
                    i--;
                    if (isInterrupted()) {//调用后不会重置线程状态
                        System.out.println("......interrupted....");
                        if (i == 1000) {
                            return;
                        }

                    }
                }

                System.out.println("......running....");
            }
        }
    }

    class ThreadInstance3 extends Thread{
        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    i++;
                    i--;
                    if (interrupted()) {//调用后会重置线程状态
                        System.out.println("......interrupted....");
                        if (i == 0) {
                            return;
                        }

                    }
                }

                System.out.println("......running....");
            }
        }
    }


    public ThreadInstance interrupted() {
        ThreadInstance threadInstance = new ThreadInstance();
        threadInstance.start();
        return threadInstance;
    }

    public ThreadInstance2 interrupted2() {
        ThreadInstance2 threadInstance = new ThreadInstance2();
        threadInstance.start();
        return threadInstance;
    }

    public ThreadInstance3 interrupted3() {
        ThreadInstance3 threadInstance = new ThreadInstance3();
        threadInstance.start();
        return threadInstance;
    }

    public void notifyDemo() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                try {
                    supportNotify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }

    private void supportNotify() throws InterruptedException {
        synchronized (object) {
            System.out.println("thread enter: "+ Thread.currentThread().getName());
            count++;
            if (count == 5) {
                // object.notify();
                object.notifyAll();
                System.out.println("thread notify: "+ Thread.currentThread().getName());
            }
            System.out.println("thread wait: "+ Thread.currentThread().getName());
            object.wait();
        }
        System.out.println("thread out: "+ Thread.currentThread().getName());
    }
}
