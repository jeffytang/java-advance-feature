package com.twq.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSelectSystemV2 {
    public static void main(String[] args) {
        College college = new College("xx计算机学院");

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

        // 设置课程
        college.setCourseMap(coursesMap);

        // 学生选课
        Student s1 = new Student("张三", 23, "051101");
        s1.setCollege(college);
        s1.selectCourse();
        s1.selectCourse();
        s1.selectCourse();
        s1.selectCourse();
        s1.selectCourse();


        Student s2 = new Student("李四", 23, "051102");
        s2.setCollege(college);
        s2.selectCourse();
        s2.selectCourse();

        // 1. 每一个学生选了哪些课？
        Map<Student, List<Course>> studentCourseMap = college.getStudentCourseMap();
        studentCourseMap.forEach((student, courses) -> {
            System.out.println("学生：" + student.getName() + "，选的课程：");
            System.out.println(courses);
        });
        System.out.println("====================================================");
        // 2. 每门课程被哪些学生选了？
        Map<Course, List<Student>> courseStudentMap = college.getCourseStudentMap();
        courseStudentMap.forEach((course, students) -> {
            System.out.println("课程：" + course.getName() + "，选了这门课的学生");
            System.out.println(students);
        });

    }
}
