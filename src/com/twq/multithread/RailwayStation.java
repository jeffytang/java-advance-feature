package com.twq.multithread;

import java.util.concurrent.TimeUnit;

/**
 *  火车站类
 */
public class RailwayStation {
    public static final int NO_TICKET_FLAG = -99999;
    private String name;
    // 默认有 6 张票，票号分别是 0 1 2 3 4 5
    // 所有线程共有的资源
    private int tickets = 5;
    // 对象用于同步的锁
    private Object lock = new Object();

    public RailwayStation(String name) {
        this.name = name;
    }

    /**
     *  获取一张票
     *  提供给售票窗口调用的
     * @return  票号
     */
    public int getTicket() {
        // synchronized 关键词，能保证在同一时刻只能有一个线程进入到这个方法
        // synchronized 用于同步，这边是修饰一个方法，同步一个方法，解决并发问题
        // synchronized 还可以修饰代码块
        // this 表示当前对象，这边使用到了 this 这个对象的锁
        // 当多线程执行到这里来的时候，实际上它们都会去争取拿到 this 这个对象的锁
        // 哪一个线程抢到了锁之后，就有资格进入同步代码块，执行同步代码块
        // 锁可以是任意对象的锁，对象要求是全局的对象
        synchronized(lock) { // 临界区
            // 当线程唤醒了后，需要继续判断一次
            while (tickets < 0) { // 没有票的时候
                // 当前的买票的线程需要等待
                try {
                    lock.wait(5000); // 线程阻塞
                    if (tickets < 0) {
                        // 没有买到票
                        return NO_TICKET_FLAG;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 模拟出票，睡一会儿
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 拿到票号
            int ticketNum = tickets--;
            // 返回票号
            return ticketNum;
            // 当线程执行完同步代码块，它会释放拿到的对象的锁
        }
    }

    /**
     *  退票的方法
     */
    public void addTicket() {
        // 有可能：退票的线程抢不过买票的线程
        synchronized(lock) { // 保护资源，解决并发问题
            // 模拟退票
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 增加票号
            // 共同资源，操作共同资源，需要临界区来保护
            tickets++;

            // 通知等待买票的线程进行买票
            lock.notifyAll();
        }
    }
}
