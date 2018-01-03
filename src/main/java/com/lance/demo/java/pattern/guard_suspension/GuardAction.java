package com.lance.demo.java.pattern.guard_suspension;

import java.util.concurrent.Callable;

public abstract class GuardAction<V> implements Callable<V>{
    protected Predicate predicate;

    public GuardAction(Predicate predicate) {
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }
}
