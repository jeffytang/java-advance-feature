package com.twq.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        College college = new College("xx计算机学院");

        List<Student> students = college.getStudents();

        // 1. 继承 Collection 中所有的方法
        students.add(new Student("张三", 23, college, 0));

        Student st1 = new Student("aaa", 23, college, 4);
        Student st2 = new Student("bbb", 22, college, 5);
        Student st3 = new Student("ccc", 21, college, 6);
        Student st4 = new Student("ddd", 23, college, 7);
        students.addAll(Arrays.asList(st1, st2, st3, st4));
        System.out.println(students);

        // 2. 和下标相关的方法
        // 增：指定下标增加元素
        students.add(2, new Student("李四", 21, college, 1));
        System.out.println(students);
        // 删：指定下标删除元素
        students.remove(3);
        System.out.println(students);
        // 改：指定下标修改元素的值
        students.set(2, new Student("汤六", 24, college, 3));
        System.out.println(students);
        // 查：指定下标查询元素
        Student student = students.get(4);
        System.out.println(student);

        // 3. subList 截取子列表
        // fromIndex 开始的下标(包括)
        // toIndex 结束的下标(不包括)
        List<String> list = Arrays.asList("hello", "world", "this", "is", "women");
        List<String> subList = list.subList(1, 4);
        System.out.println(subList);
    }
}
