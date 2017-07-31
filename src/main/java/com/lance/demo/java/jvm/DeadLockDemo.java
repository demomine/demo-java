package com.lance.demo.java.jvm;

public class DeadLockDemo {
    private final Object objectA = new Object();
    private final Object objectB = new Object();

    /**
     * jps 获取pid
     * jstack -l $pid 查看死锁
     */
    public void dead() {
        new Thread(() -> {
            synchronized (objectA) {
                System.out.println(objectA);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectB) {
                    System.out.println(objectB);
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (objectB) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(objectB);
                synchronized (objectA) {
                    System.out.println(objectA);
                }
            }
        }).start();
    }
}
