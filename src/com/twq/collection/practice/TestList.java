package com.twq.collection.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    private String number;
    private String name;
    private int score;

    /**
     *  工具方法 (没有状态的方法)
     *  将字符串的学生信息转换成 Student 类型的信息
     * @param str   字符串的学生信息
     * @return  Student 类型对象
     */
    public static Student fromStr(String str) {
        Student student = new Student();
        String[] fields = str.split(",");
        student.setNumber(fields[0]);
        student.setName(fields[1]);
        student.setScore(Integer.parseInt(fields[2]));
        return student;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

public class TestList {
    public static void main(String[] args) {
        String str = "01,勇哥,100;02,老汤,98;03,明哥,90;04,菲力,89;05,杨哥,60";

        // 1. 把字符串中的学生信息分离出来
        String[] arr = str.split(";");
        for (String s : arr) {
            System.out.println(s);
        }

        System.out.println("-----------------------------------------------");

        // 2. 创建 List 集合，根据分离出来的学生信息创建学生对象，添加到 List 集合中
        List<Student> students = new ArrayList<>();
        for (String s : arr) {
            Student student = Student.fromStr(s);
            students.add(student);
        }
        System.out.println("-----------------------------------------------");
        // 3. 通过迭代分别打印集合中的学生信息
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }
        System.out.println("-----------------------------------------------");
        // 4. 判断集合中是否存在姓名为 明哥 的学生
        // 迭代器只能用一次
        iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals("明哥")) {
                System.out.println("存在明哥这个学生");
                break;
            }
        }
        System.out.println("-----------------------------------------------");
        // 5. 通过循环打印集合中的学生信息
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
        System.out.println("-----------------------------------------------");
        // 6. 删除姓名为 明哥 的学生
        /*for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getName().equals("明哥")) {
                // students.remove(i);
                students.remove(student);
            }
        }*/
        /*iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals("明哥")) {
                iterator.remove();
            }
        }
        System.out.println(students);*/

        System.out.println("-----------------------------------------------");
        // 7. 通过 foreach 循环打印集合中的学生的信息
        // 在 foreach 中不能删除元素，否则抛异常：java.util.ConcurrentModificationException
        for (Student student : students) {
            if (student.getName().equals("明哥")) {
                students.remove(student);
            }
        }

    }
}
