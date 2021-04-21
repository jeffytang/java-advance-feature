package com.twq.multithread.pc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *  厨师
 */
public class Chef implements Runnable {

    private BlockingQueue<Food> foodWindow;
    // 擅长的菜
    private Food handyFood;

    private String name;

    public Chef(BlockingQueue<Food> foodWindow, Food handyFood, String name) {
        this.foodWindow = foodWindow;
        this.handyFood = handyFood;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "开始做菜：" + handyFood);
        // 做菜
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "菜做完了：" + handyFood);
        // 将菜放到窗口
        foodWindow.add(handyFood);
    }
}
