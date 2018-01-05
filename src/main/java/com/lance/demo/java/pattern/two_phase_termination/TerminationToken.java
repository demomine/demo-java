package com.lance.demo.java.pattern.two_phase_termination;

import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TerminationToken {
    private volatile boolean terminated;

    public final AtomicInteger reservations = new AtomicInteger();

    public final Queue<WeakReference<Terminatable>> queue = new ConcurrentLinkedQueue<>();

    public boolean isTerminated() {
        return terminated;
    }

    protected void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    protected void register(Terminatable terminatable) {
        queue.add(new WeakReference<>(terminatable));
    }

    protected void notifyTerminate(Terminatable terminatable) {
        WeakReference<Terminatable> termination;
        while ((termination = queue.poll())!= null) {
            Terminatable queuedTerminatable = termination.get();
            if (queuedTerminatable!=null && terminatable != queuedTerminatable) {
                queuedTerminatable.terminate();
            }
        }
    }
}
