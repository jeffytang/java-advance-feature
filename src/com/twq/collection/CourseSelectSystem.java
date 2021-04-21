package com.twq.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class CourseSelectSystem {
    public static void main(String[] args) {
        // 1. 创建一个学院对象
        College college = new College("xx计算机学院");

        // 2. 创建一个学生对象
        Student student = new Student("张三", 23, college, 0);

        // 3. 选课
        // 当学生的学分不够 70 分的话，那么继续选课
        while (student.getTotalCredits() < 70) {
            student.selectCourse();
        }

        ArrayList courses = student.getSelectedCourses();
        System.out.println("选择的课程是：" + courses);
        System.out.println("选择的课程的数量：" + student.getCurrentSelectNum());
        System.out.println("总学分是：" + student.getTotalCredits());

        // 4. 学习
        student.studyCourse();
    }
}
