package com.twq.multithread.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        // 线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        BlockingQueue<Food> foodWindow = new ArrayBlockingQueue<>(5);

        // 服务员
        Waitress waitress1 = new Waitress(foodWindow, "小芳");
        executorService.submit(waitress1);
        Waitress waitress2 = new Waitress(foodWindow, "小玲");
        executorService.submit(waitress2);

        // 厨师
        Chef chef1 = new Chef(foodWindow, new Food("小鸡炖蘑菇"), "小明厨师");
        executorService.submit(chef1);
        executorService.submit(chef1);
        executorService.submit(chef1);

        Chef chef2 = new Chef(foodWindow, new Food("煎蛋"), "小张厨师");
        executorService.submit(chef2);
        executorService.submit(chef2);
        executorService.submit(chef2);

        Chef chef3 = new Chef(foodWindow, new Food("土豆丝"), "小李厨师");
        executorService.submit(chef3);
        executorService.submit(chef3);


        executorService.shutdown();

    }
}
