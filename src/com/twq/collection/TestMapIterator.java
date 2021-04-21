package com.twq.collection;

import java.util.*;
import java.util.function.BiConsumer;

public class TestMapIterator {
    public static void main(String[] args) {
        Map<String, Course> coursesMap = new HashMap<>();
        // 初始化课程
        coursesMap.put("高数", new Course(1, "高数", 6));
        coursesMap.put("Java程序开发", new Course(2, "Java程序开发", 10));
        coursesMap.put("操作系统", new Course(3, "操作系统", 9));
        coursesMap.put("思想政治", new Course(4, "思想政治", 5));
        coursesMap.put("英语", new Course(5, "英语", 10));
        coursesMap.put("C语言", new Course(6, "C语言", 10));
        coursesMap.put("体育", new Course(7, "体育", 2));
        coursesMap.put("编译原理", new Course(8, "编译原理", 7));
        coursesMap.put("概率统计", new Course(9, "概率统计", 5));
        coursesMap.put("计算机网络", new Course(10, "计算机网络", 6));
        coursesMap.put("线性代数", new Course(11, "线性代数", 5));
        coursesMap.put("电子电路原理", new Course(12, "电子电路原理", 2));

        // 1. 将这个 Map 的所有的 key 转成 Set 集合
        // Map 的第一种遍历方式：遍历一个 Map 的所有的 key
        Set<String> keys = coursesMap.keySet();
        for (String key: keys) {
            System.out.print(key + ", ");
        }

        System.out.println();

        // 2. 将这个 Map 的所有的 value 转成集合
        // Map 的第二种遍历方式：遍历一个 Map 的所有的 value
        Collection<Course> values = coursesMap.values();
        for (Course course : values) {
            System.out.print(course + ", ");
        }

        System.out.println();

        // 3. Map 的第三种遍历方式：遍历一个 Map 的所有的键值对
        Set<Map.Entry<String, Course>> entries = coursesMap.entrySet();
        for (Map.Entry<String, Course> entry : entries) {
            // 每次一起访问 key-value 对
            String key = entry.getKey();
            Course value = entry.getValue();
            System.out.println("key = " + key + "；value = " + value);
        }

        System.out.println("=============================================");

        // 遍历一个 Map 的所有的键值对
        coursesMap.forEach((key, value) ->
                System.out.println("key = " + key + "；value = " + value));
    }
}
