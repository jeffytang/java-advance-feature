package com.twq.multithread.pc;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  放菜窗口
 */
public class FoodWindow {
    // 菜
    private Queue<Food> queue = new LinkedList<>(); // 公共资源

    /**
     *  放菜
     */
    public synchronized void pushFood(Food food) {
        // 最多只能放 5 个菜
        while (this.queue.size() == 5) {
            try { // 等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 放菜
        this.queue.add(food);

        // 通知等待的服务员线程
        this.notifyAll();
    }

    public synchronized Food popFood() {
        // 没有菜的时候，等待
        while (this.queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 需要返回的菜，会从队列中返回并删除
        Food f = this.queue.poll();
        // 通知在等待的厨师
        this.notifyAll();

        // 返回菜
        return f;
    }
}
