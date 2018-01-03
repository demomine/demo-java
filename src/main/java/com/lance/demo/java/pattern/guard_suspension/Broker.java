package com.lance.demo.java.pattern.guard_suspension;

import java.util.concurrent.Callable;

public interface Broker {
    <V> V callWithGuard(GuardAction<V> guardAction) throws Exception;

    void signalAfter(Callable<Boolean> stateOperation) throws Exception;

    void broadcastAfter(Callable<Boolean> stateOperation) throws Exception;
}
