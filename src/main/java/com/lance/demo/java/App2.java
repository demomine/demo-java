package com.lance.demo.java;

import java.lang.reflect.AnnotatedType;

/**
 * Created by perdonare on 2017/5/27.
 */
public class App2 {
    public static void main(String[] args) {
        AnnotatedType[] annotatedInterfaces = SomeService.class.getAnnotatedInterfaces();
        System.out.println("sdf");
    }
}
