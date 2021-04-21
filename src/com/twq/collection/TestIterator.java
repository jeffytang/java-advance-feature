package com.twq.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "this", "is", "women");

        // 1. 普通 for 循环
        for (int index = 0; index < list.size(); index++) {
            String element = list.get(index);
            System.out.print(element + ",");
        }
        System.out.println();
        System.out.println("------------------------------");

        // 2. 使用 Iterator 迭代器
        // 拿到迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + ",");
        }
        System.out.println();
        System.out.println("------------------------------");
        // 双向迭代器
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) { // 正向迭代
            String element = it.next();
            System.out.print(element + ",");
        }

        System.out.println();
        System.out.println("------------------------------");

        while (it.hasPrevious()) { // 反向迭代
            String element = it.previous();
            System.out.print(element + ",");
        }

        System.out.println();
        System.out.println("------------------------------");

        // 3. 使用 foreach 循环
        for (String element : list) {
            System.out.print(element + ",");
        }

        System.out.println();
        System.out.println("------------------------------");

        // 4. 是用方法 forEach 进行迭代
        list.forEach(element -> System.out.print(element + ","));
    }
}
