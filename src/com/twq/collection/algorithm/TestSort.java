package com.twq.collection.algorithm;

import com.twq.collection.Person;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Person("张一", 12);
        people[1] = new Person("张二", 23);
        people[2] = new Person("张三", 9);
        people[3] = new Person("张四", 15);
        people[4] = new Person("张五", 10);

        String[] strings = new String[]{"g", "c", "d", "b", "t"};

        // 要求给 people 按照年龄升序排
        // 1. 使用比较器来比较人
        // ComparatorSortUtil.quickSort(strings, (s1, s2) -> s1.compareTo(s2));
        // 直接使用 Java 提供的排序的方法就可以了
        Arrays.sort(people, (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) return -1;
            if (o1.getAge() < o2.getAge()) return 1;
            return 0;
        });


        // 2. 使用 java.lang.Comparable 来比较
        // ComparableSortUtil.quickSort(strings);
        // 使用 Java 提供的数组排序的方法
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        // 基本类型的排序
        Integer[] arr = new Integer[]{21, 1, 2, 22, 12};
        Arrays.sort(arr, (Integer o1, Integer o2) -> -o1.compareTo(o2));
        System.out.println(Arrays.toString(arr));

        // 结论：Arrays 中的 sort 大部分使用快速排序
    }




}
