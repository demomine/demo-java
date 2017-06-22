package com.lance.demo.java.thread;

/**
 * Created by perdonare on 2017/6/21.
 */
public class ThreadDemo {

    class ThreadInstance extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("......running....");
                try {
                    sleep(200l);
                } catch (InterruptedException e) {
                    System.out.println(".....sleep interrupted....");
                    interrupted();
                }
            }
        }
    }

    class ThreadInstance2 extends Thread{
        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    i++;
                    i--;
                    if (isInterrupted()) {//调用后不会重置线程状态
                        System.out.println("......interrupted....");
                        if (i == 1000) {
                            return;
                        }

                    }
                }

                System.out.println("......running....");
            }
        }
    }

    class ThreadInstance3 extends Thread{
        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    i++;
                    i--;
                    if (interrupted()) {//调用后会重置线程状态
                        System.out.println("......interrupted....");
                        if (i == 0) {
                            return;
                        }

                    }
                }

                System.out.println("......running....");
            }
        }
    }


    public ThreadInstance interrupted() {
        ThreadInstance threadInstance = new ThreadInstance();
        threadInstance.start();
        return threadInstance;
    }

    public ThreadInstance2 interrupted2() {
        ThreadInstance2 threadInstance = new ThreadInstance2();
        threadInstance.start();
        return threadInstance;
    }

    public ThreadInstance3 interrupted3() {
        ThreadInstance3 threadInstance = new ThreadInstance3();
        threadInstance.start();
        return threadInstance;
    }
}
