package com.twq.multithread.sync;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    public static void main(String[] args) {
        Boss boss = new Boss("老板");

        // 创建一个栅栏
        // parties: 需要等待多少个线程结束
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, boss);

        // 启动 3 个工人的线程
        Worker worker1 = new Worker("小明", cyclicBarrier);
        Worker worker2 = new Worker("小张", cyclicBarrier);
        Worker worker3 = new Worker("小李", cyclicBarrier);

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);
        Thread t3 = new Thread(worker3);

        t1.start();
        t2.start();
        t3.start();
    }
}
