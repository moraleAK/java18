package com.canno.java18.thread;

import static java.lang.Thread.sleep;

/**
 * @author Gin
 * @since 2018/9/22 00:42
 */
public class MyThreadLocal {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final MyThreadLocal test = new MyThreadLocal();


        test.set();
        System.out.println(test.getLong());

        for(int i = 0 ; i < 100000; i++){
            MyThread thread = new MyThread();
            thread.setThreadLocal(test);
            thread.start();
            thread.join();
        }

        System.out.println(test.getLong());
//        System.out.println(test.getString());

    }

    static class MyThread extends Thread{
        public MyThreadLocal threadLocal;
        public void run() {
            threadLocal.set();
            System.out.println(threadLocal.getLong());
//                System.out.println(test.getString());
        };

        public MyThreadLocal getThreadLocal() {
            return threadLocal;
        }

        public void setThreadLocal(MyThreadLocal threadLocal) {
            this.threadLocal = threadLocal;
        }
    }
}
