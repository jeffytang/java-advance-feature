package com.twq.collection;

import java.util.LinkedList;

public class TestJavaLinkedList {
    public static void main(String[] args) {
        // Java 内置的链表，双向链表
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 增：向链表中增加元素
        linkedList.add(5); // 链表的尾部插入一个节点
        linkedList.add(12);
        linkedList.add(9);
        linkedList.add(3);

        linkedList.addFirst(4);

        System.out.println(linkedList);

        // 删：删除指定的元素
        linkedList.remove(Integer.valueOf(12));
        System.out.println(linkedList);

        // 改：设置某个值
        // 将第 4 个元素的值设置成 1000
        linkedList.set(3, 1000);
        System.out.println(linkedList);

        // 查：根据下标查询某个元素
        // 性能比较差
        System.out.println(linkedList.get(1));
    }
}
