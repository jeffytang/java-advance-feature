package com.twq.collection.hashtable;

import com.twq.collection.Student;

import java.util.HashMap;

public class TestHashTable2 {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 20, "051100");
        Student s2 = new Student("李四", 21, "051101");
        Student s3 = new Student("王五", 22, "051102");
        Student s4 = new Student("钱六", 23, "051103");
        Student s5 = new Student("赵七", 19, "051104");
        Student s6 = new Student("唐八", 23, "061003");

        // loadFactor 装载因子
        // loadFactor * 数组的长度(5)
        // java.util.HashMap 替换掉我们之前实现的 KeyValueMap
        // 1. 数组 + 链表 ，对应的数组是：Node<K,V>[] table
        // 2. 数组默认长度是 16
        // 3. 也有散列函数，也是使用 key 的 hashCode 来实现的
        // 4. loadFactor(装载因子)，默认值是 0.75。0.75 * 16 = 12
        // 5. 当元素的个数大于 12， 数组自动扩容两倍
        HashMap<String, Student> map = new HashMap<>();

        // 存储数据
        map.put("051100", s1);
        map.put("051101", s2);
        map.put("051102", s3);
        map.put("051103", s4);
        map.put("051104", s5);
        map.put("061003", s6);

        // 获取数据，通过 key 拿到对应的 value
        System.out.println(map.get("051103"));
        System.out.println(map.get("061003"));

        Student s7 = new Student("钱八", 20, "061027");
        map.put("061027", s7);

        KeyValueMap<Integer, String> map1 = new KeyValueMap<>(100);
        map1.put(2, "hello");
        map1.put(3, "world");
    }


}
