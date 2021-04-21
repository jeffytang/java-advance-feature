package com.twq.multithread;

// 要实现自己的线程的话，可以继承 java.lang.Thread 类
class FiveNumberPrinter extends Thread {

    // 通过构造方法设置线程的名字
    public FiveNumberPrinter(String threadName) {
        // 设置线程的名字
        super(threadName);
    }

    /**
     * 必须覆写 Thread 中的 run 方法
     * 这个方法中，放的就是这个线程需要执行的代码
     * 在 run 方法中执行的程序，我们也可以叫做任务 (task)
     */
    @Override
    public void run() {
        // 当前这个线程的任务(task)
        for (int i = 0; i < 5; i++) {
            // 让当前的线程 睡觉 1 秒
            // 这个时候当前线程发生了阻塞，进入阻塞状态
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程进入就绪状态
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        // 程序都是运行在单个线程中 线程的名字是 main 线程
        // 拿到当前的线程的名称
        System.out.println(Thread.currentThread().getName());

        // 在 main 方法中，创建 3 个 FiveNumberPrinter 线程
        FiveNumberPrinter printer1 = new FiveNumberPrinter("线程一");
        //printer1.setDaemon(true); // 将线程设置为 守护线程
        // windows 系统：优先级必须在 1 - 10 之内
        // Linux 系统：优先级没用
        // 设置优先级最高的线程
        //printer1.setPriority(1);
        FiveNumberPrinter printer2 = new FiveNumberPrinter("线程二");
        //printer2.setDaemon(true); // 将线程设置为 守护线程
        // 设置中等优先级的线程
        //printer2.setPriority(5);
        FiveNumberPrinter printer3 = new FiveNumberPrinter("线程三");
        //printer3.setDaemon(true); // 将线程设置为 守护线程
        // 设置最小优先级
        //printer3.setPriority(8);

        // 启动这 3 个线程
        printer1.start();
        printer2.start();
        printer3.start();



        // main 线程运行到这里的时候，main 线程结束了
        // 当 JVM 进程中只剩下守护线程的话，那么 JVM 将直接退出，不执行守护线程的任务
        System.out.println(Thread.currentThread().getName());

    }
}
