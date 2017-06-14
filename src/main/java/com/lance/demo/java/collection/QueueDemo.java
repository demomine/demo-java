package com.lance.demo.java.collection;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by perdonare on 2017/6/14.
 */
public class QueueDemo {
    public void hello() {
        Queue<String> queue = new ArrayBlockingQueue<>(10);
        queue.offer("first1");
        queue.offer("first2");
        queue.add("last1");
        System.out.println(queue);
        queue.forEach(item->{
            System.out.println(queue.peek());
            System.out.println(queue.element());
            queue.remove();
        });
        queue.peek();
        queue.element();
    }
}
