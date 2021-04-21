package com.twq.multithread.sync;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable{
    private String name;
    private CountDownLatch countDownLatch;
    // 栅栏
    private CyclicBarrier cyclicBarrier;

    public Worker(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    public Worker(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(name + "第一阶段开始工作");

        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "第一阶段工作完成");
        // 计数器 -1
        // countDownLatch.countDown();

        // 当工人线程完成了第一个阶段的工作的时候，在这里等一一等
        // 等待所有的工人线程都完成了第一阶段的工作
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(name + "第二阶段开始工作");

        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "第二阶段工作完成");
    }
}
