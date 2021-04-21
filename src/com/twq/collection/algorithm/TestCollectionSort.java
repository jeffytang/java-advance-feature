package com.twq.collection.algorithm;

import java.util.*;

public class TestCollectionSort {
    public static void main(String[] args) {
        // 1. List
        List<Integer> list = Arrays.asList(12, 3, 4, 22, 14, 16);

        // 使用 Java 内置的排序方法对集合进行排序
        Collections.sort(list);

        // 集合的排序最终是通过数组来排序实现的

        System.out.println(list);

        // 2. Set
        // HashSet：不允许元素重复，没有顺序
        // java.util.TreeSet：不允许元素重复，排好序（默认的话是升序排序）
        Set<Integer> set = new TreeSet<>((o1, o2) -> -o1.compareTo(o2));
        set.add(22);
        set.add(2);
        set.add(23);
        set.add(2);
        set.add(12);
        set.add(22);
        System.out.println(set);

        // 3. Map
        // java.util.TreeMap 对 key 进行排序 （默认是升序排列）
        Map<Integer, String> map = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
        map.put(1, "Hello");
        map.put(3, "Ketty");
        map.put(2, "World");
        map.put(3, "China");
        map.put(1, "Cat");
        map.put(5, "Dog");

        System.out.println(map);
    }
}
