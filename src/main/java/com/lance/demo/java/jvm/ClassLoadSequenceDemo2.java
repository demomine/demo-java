package com.lance.demo.java.jvm;

public class ClassLoadSequenceDemo2 {
    public static void main(String[] args) {
        //staticFunction();
    }

    //static ClassLoadSequenceDemo2 sld = new ClassLoadSequenceDemo2();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }
/*
    ClassLoadSequenceDemo2() {
        System.out.println("3");
        System.out.println("a=" + a + "b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 100;
    static int b = 112;*/
}
