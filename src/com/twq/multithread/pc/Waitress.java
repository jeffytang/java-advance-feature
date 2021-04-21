package com.twq.multithread.pc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *  服务员
 */
public class Waitress implements Runnable {

    private BlockingQueue<Food> foodWindow;
    private String name;

    public Waitress(BlockingQueue<Food> foodWindow, String name) {
        this.foodWindow = foodWindow;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) { // 服务员需要时时刻刻的工作
            // 拿菜
            Food food = null;
            try {
                food = this.foodWindow.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "上菜：" + food);
            // 上菜
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
