package com.twq.collection.hashset;

import com.twq.collection.Person;

import java.util.*;

public class TestHashSet {
    public static void main(String[] args) {
        // 不管是 ArrayList 还是 LinkedList
        // 1. 允许重复的元素存在
        // 2. 元素是有顺序的，它的顺序是按照 add 的顺序
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);

        System.out.println(list);

        // HashMap 的 key 是不能重复的
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(1, "world");
        map.put(2, "nihao");
        map.put(3, "word");
        map.put(2, "hi");
        System.out.println(map);

        //  我们自己利用 HashMap 的 key 不能重复的特性实现了一个不允许有重复元素的集合
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(2);
        set.add(2);
        System.out.println(set);
        // 1. HashSet 是一个不允许有重复元素的集合
        set.add(9);
        set.add(20);
        System.out.println(set);
        // 2. HashSet 中元素是没有顺序的，顺序不确定的

        // HashSet 在判断重复元素的时候的逻辑：
        // 先比较 hashCode，如果 hashCode 相等的话，再比较 equals，
        // 如果 equals 返回 true 的话，那么就是重复元素
        // 使用 HashSet 的时候，一般会重写 equals 方法和 hashCode 方法
        Set<Person> people = new HashSet<>();
        Person p1 = new Person("张三", 20);
        Person p2 = new Person("张三", 20);
        Person p3 = new Person("张三", 20);

        people.add(p1);
        people.add(p2);
        people.add(p3);

        System.out.println(people);

        // HashMap 的 key 在判断重复元素的时候的逻辑：
        // 先比较 hashCode，如果 hashCode 相等的话，再比较 equals，
        // 如果 equals 返回 true 的话，那么就是重复元素
        // 使用 HashMap key 的时候，一般会重写 equals 方法和 hashCode 方法
        HashMap<Person, String> map1 = new HashMap<>();
        Person p11 = new Person("张三", 20);
        Person p21 = new Person("张三", 20);
        Person p31 = new Person("张三", 20);
        Person p41 = new Person("张三", 20);
        map1.put(p11, "潇洒的人");
        map1.put(p21, "固执的人");
        map1.put(p31, "漂亮的人");
        map1.put(p41, "帅气的人");
        System.out.println(map1);
    }
}
