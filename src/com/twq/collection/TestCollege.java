package com.twq.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class TestCollege {
    public static void main(String[] args) {
        College college = new College("xx计算机学院");

        Collection<Student> students = college.getStudents();

        // 1. 判断集合是否是空集合
        boolean isEmpty = students.isEmpty();
        System.out.println(isEmpty);
        if (isEmpty) {
            Student s1 = new Student("张三", 23, college, 0);
            // 招收第一个学员
            college.addStudent(s1);
        }
        System.out.println(students.isEmpty()); // false

        // 2. 查询集合中有多少个元素
        System.out.println("学生的个数：" + students.size());

        // 3. 判断是否有名字为 张三，学号为 0 的学员
        Student s = new Student("张三", 23, college, 0);
        // contains 依赖集合中元素的 equals 方法
        System.out.println(students.contains(s));

        // 招收第二个学生
        Student s2 = new Student("李四", 21, college, 1);
        college.addStudent(s2);

        // 招收第三个学生
        Student s3 = new Student("王五", 20, college, 2);
        college.addStudent(s3);

        System.out.println("学生的个数：" + students.size());

        // 4. 集合和数组之间的转换
        Object[] objects = students.toArray(); // 类型丢失了
        // 保留了类型
        Student[] studentArray = students.toArray(new Student[students.size()]);
        for (Student student : studentArray) {
            System.out.println(student);
        }
        // lambda 表达式
        studentArray = students.toArray(size -> new Student[size]);
        // 将数组转成集合
        Collection<Integer> integers = Arrays.asList(2, 3, 1, 11);

        // 5. 集合元素更改的 API
        students.add(new Student("汤六", 24, college, 3));
        System.out.println("学生的个数：" + students.size());

        Student st1 = new Student("aaa", 23, college, 4);
        Student st2 = new Student("bbb", 22, college, 5);
        Student st3 = new Student("ccc", 21, college, 6);
        Student st4 = new Student("ddd", 23, college, 7);
        // 批量添加
        students.addAll(Arrays.asList(st1, st2, st3, st4));
        System.out.println("学生的个数：" + students.size());

        // 从集合中删除指定的元素
        students.remove(st1);
        // 山粗学号大于等于 6 的学生
        students.removeIf(student -> student.getNumber().compareTo("6") > 0);
        System.out.println(students);

        // 6. 清除集合中的所有元素
        students.clear();
        System.out.println(students);
        System.out.println("学生的个数：" + students.size());
    }
}
