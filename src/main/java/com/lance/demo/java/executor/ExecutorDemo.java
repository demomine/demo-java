package com.lance.demo.java.executor;

import java.util.concurrent.*;

/**
 * Created by perdonare on 2017/6/13.
 */
public class ExecutorDemo {
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    ExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    ExecutorService cachedExecutor = Executors.newCachedThreadPool();
    ExecutorService fixedExecutor = Executors.newFixedThreadPool(10);
    ExecutorService scheduledExecutor = Executors.newScheduledThreadPool(10);
    ExecutorService workStealingExecutor = Executors.newWorkStealingPool();

    public void executeSingleThreadExecutor() {
        for (int i = 0; i < 100; i++) {
            int ii = i;
            singleThreadExecutor.execute(()-> System.out.println("running....."+ ii));
            Future<String> countString = singleThreadExecutor.submit(new CallableService(i));
            try {
                System.out.println(countString.get());
            } catch (InterruptedException e) {
                System.out.println("interrupt");
            } catch (ExecutionException e) {
                System.out.println("execution exception");
            }
        }
        scheduledExecutor.shutdown();

    }
}
