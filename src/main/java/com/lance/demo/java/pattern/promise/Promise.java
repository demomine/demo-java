package com.lance.demo.java.pattern.promise;

public class Promise<V> {
    public Promisor<V>  compute(Callable<V> task) {
        return new Promisor<>(task);
    }
}
