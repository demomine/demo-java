package com.lance.demo.java.collection;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by perdonare on 2017/6/14.
 */
public class DequeueDemo {
    public void hello() {
        Deque<String> deque = new LinkedBlockingDeque<>();
        deque.offerFirst("first1");
        deque.offer("first2");//相当于 offerLast
        deque.offerLast("last1");
        System.out.println(deque);
        deque.forEach(item->{
            System.out.println(deque.peekFirst());
            deque.pollFirst();
        });
    }
}
