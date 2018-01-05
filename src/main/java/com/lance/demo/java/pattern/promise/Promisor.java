package com.lance.demo.java.pattern.promise;

public class Promisor<V> {
    private volatile boolean doneFlag = false;
    private V v;
    private Thread thread;

    public Promisor(Callable<V> task) {
        this.thread = new Thread(()-> v = task.call());
        thread.start();
    }

    public V getResult() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doneFlag = true;
        return v;
    }

    public boolean isDone() {
        return doneFlag;
    }
}
