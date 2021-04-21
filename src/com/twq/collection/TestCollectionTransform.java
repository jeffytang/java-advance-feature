package com.twq.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class TestCollectionTransform {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        System.out.println(list);

        // ArrayList -> LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        System.out.println(linkedList);

        // LinkedList -> ArrayList
        list = new ArrayList<>(linkedList);
        System.out.println(list);

        // ArrayList -> HashSet
        // 去重
        HashSet<Integer> set = new HashSet<>(list);
        System.out.println(set);

        // LinkedList -> HashSet
        set = new HashSet<>(linkedList);
        System.out.println(set);

        // HashSet -> ArrayList
        list = new ArrayList<>(set);
        System.out.println(list);

        // HashSet -> LinkedList
        linkedList = new LinkedList<>(set);
        System.out.println(linkedList);
    }
}
