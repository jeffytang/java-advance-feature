package com.twq.multithread;

// 通过实现 java.lang.Runnable 接口来封装一个线程需要做的任务
class FiveNumberPrinterRunnable implements Runnable {

    @Override
    public void run() {
        // 当前这个线程的任务(task)
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

public class TestRunnable {
    public static void main(String[] args) {
        // 创建线程需要运行的任务
        FiveNumberPrinterRunnable task = new FiveNumberPrinterRunnable();

        // 创建三个线程
        Thread t1 = new Thread(task, "线程一");
        Thread t2 = new Thread(task, "线程二");
        Thread t3 = new Thread(task, "线程三");

        // 启动三个线程
        t1.start();
        t2.start();
        t3.start();

        // 线程的创建和启动最终还是通过 java.lang.Thread 类来实现，只不过线程要执行的任务，可以放在：
        // 1. Thread 的子类中的 run 方法中
        // 2. 我们可以将任务封装到 Runnable 的子类中的 run 方法中
    }
}
