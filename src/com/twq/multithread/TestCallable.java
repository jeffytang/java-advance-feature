package com.twq.multithread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 通过实现 java.util.concurrent.Callable 接口，来封装一个线程需要执行的任务
class SumTask implements Callable<Integer> {
    // 开始数字
    private int startNum;
    // 结束数字
    private int endNum;

    public SumTask(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        int result = 0;
        for (int i = startNum; i <= endNum; i++) {
            result += i;
        }
        return result;
    }
}

public class TestCallable {
    public static void main(String[] args) {
        // 第一个线程需要做的事情：计算 1 到 999 的和
        SumTask sumTask1 = new SumTask(1, 999);
        // 需要将 Callable 的子类包装转换成 FutureTask
        FutureTask<Integer> futureTask1 = new FutureTask<>(sumTask1);
        // FutureTask 是 java.lang.Runnable 的子类
        // 那么我们可以将 FutureTask 传给 Thread 的构造方法
        Thread t1 = new Thread(futureTask1);

        // 第二个线程需要做的事情：计算 1000 到 9999 的和
        SumTask sumTask2 = new SumTask(1000, 9999);
        FutureTask<Integer> futureTask2 = new FutureTask<>(sumTask2);
        Thread t2 = new Thread(futureTask2);

        // 第三个线程需要做的事情：计算 10000 到 99999 的和
        SumTask sumTask3 = new SumTask(10000, 99999);
        FutureTask<Integer> futureTask3 = new FutureTask<>(sumTask3);
        Thread t3 = new Thread(futureTask3);

        // 启动第一个线程
        t1.start();
        t2.start();
        t3.start();

        // 在 main 线程中拿到 3 个线程计算的结果
        try {
            int result1 = futureTask1.get();
            int result2 = futureTask2.get();
            int result3 = futureTask3.get();
            System.out.println("第一个线程的值：" + result1);
            System.out.println("第二个线程的值：" + result2);
            System.out.println("第三个线程的值：" + result3);
            System.out.println("结果是：" + (result1 + result2 + result3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
