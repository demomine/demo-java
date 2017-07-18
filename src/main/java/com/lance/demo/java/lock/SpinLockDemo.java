package com.lance.demo.java.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    private AtomicReference<Thread> sign =new AtomicReference<>();
    private  int sum = 0;

    public void spin() throws Exception{
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()->{
                this.lock();
                this.sum += 1;
                this.unlock();
            });
            t.start();
        }
        System.out.println(this.sum);

    }

    private void lock(){
        Thread current = Thread.currentThread();
        while(!sign .compareAndSet(null, current)){
        }
    }

    private void unlock (){
        Thread current = Thread.currentThread();
        sign .compareAndSet(current, null);
    }

}
