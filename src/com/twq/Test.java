package com.twq;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(6);
        set.add(2);

        System.out.println(set.ceiling(4));
    }
}
