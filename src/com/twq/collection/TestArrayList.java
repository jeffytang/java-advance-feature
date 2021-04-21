package com.twq.collection;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        // 数组列表，通过给数组扩容来解决数组长度固定的问题
        // 初始化一个数组列表
        ArrayList<Integer> list = new ArrayList<>(5);

        // 往 list 中增加 5 个元素
        list.add(1);
        list.add(10);
        list.add(3);
        list.add(2);
        list.add(5);

        // 这个时候，数组列表的长度已经达到了 5
        // 对数组列表进行扩容
        // 这个时候的数组列表的长度是 5 + 5/2 = 7
        list.add(30);
        list.add(20);

        // 这个时候，数组列表的长度已经达到了 7
        // 对数组列表进行扩容
        // 这个时候的数组列表的长度是 7 + 7/2 = 7 + 3 = 10
        list.add(4);

        System.out.println(list);

        // ArrayList 是可以自动扩容的数组
        // ArrayList 也可以通过下标访问元素
        System.out.println(list.get(7));
    }
}
