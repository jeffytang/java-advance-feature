package com.twq.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadPool {
    public static void main(String[] args) {
        // 使用 java.util.concurrent.Executors 中的静态方法创建线程池
        // 创建一个大小为 2 的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // newSingleThreadExecutor ：线程池中只会有一个线程
        // newCachedThreadPool ：主要是为了节省创建线程的时间
        //      如果线程池中有线程的话，那么直接用，如果没有的线程的话，那么就创建，创建完后肯定是放在线程池中

        // 第一个线程需要做的事情：计算 1 到 999 的和
        SumTask sumTask1 = new SumTask(1, 999);
        // 向线程池中提交一个任务
        Future<Integer> future1 = executorService.submit(sumTask1);

        // 第二个线程需要做的事情：计算 1000 到 9999 的和
        SumTask sumTask2 = new SumTask(1000, 9999);
        Future<Integer> future2 = executorService.submit(sumTask2);

        // 第三个线程需要做的事情：计算 10000 到 99999 的和
        SumTask sumTask3 = new SumTask(10000, 99999);
        Future<Integer> future3 = executorService.submit(sumTask3);

        // 拿到线程执行的返回值
        try {
            int result1 = future1.get();
            int result2 = future2.get();
            int result3 = future3.get();
            System.out.println("第一个线程的值：" + result1);
            System.out.println("第二个线程的值：" + result2);
            System.out.println("第三个线程的值：" + result3);
            System.out.println("结果是：" + (result1 + result2 + result3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 向线程池中提交一个 Runnable 的任务
        executorService.submit(new FiveNumberPrinterRunnable());

        executorService.shutdown();
    }
}
