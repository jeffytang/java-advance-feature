package com.twq.collection;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        // 构建一个队列
        Queue<Integer> queue = new LinkedList<>();

        // 队列包含 队首 和 队尾
        // 入队
        queue.add(10);
        queue.add(20);

        System.out.println(queue);

        // 出队
        Integer element = queue.remove();
        System.out.println("出队的元素是：" + element);
        System.out.println("队列中的元素：" + queue);

        // 入队
        queue.add(30);
        queue.add(13);
        System.out.println(queue);

        // 出队
        element = queue.remove();
        System.out.println("出队的元素是：" + element);
        System.out.println("队列中的元素：" + queue);

        // 出队
        element = queue.remove();
        System.out.println("出队的元素是：" + element);
        System.out.println("队列中的元素：" + queue);

        // 队列非常大的特点就是：先进先出

        // 出队
        element = queue.remove();
        System.out.println("出队的元素是：" + element);
        System.out.println("队列中的元素：" + queue);

        // 对空的队列进行 remove 的话，会抛异常
        element = queue.remove();
    }
}
