package com.twq.collection;

import java.util.*;

/**
 *  学院类，初始化好了 12 门课程
 */
public class College {
    private String name;

    // 我们使用 HashMap 来存储学院的课程信息
    // key 是课程的名称，value 就是课程对象
    // 每一个学院的课程都是不一样的，
    private Map<String, Course> courseMap = new HashMap<>();

    // 学院可以有很多的学生
    private List<Student> students = new ArrayList<>();

    // 每一个学生分别选了哪些课
    private Map<Student, List<Course>> studentCourseMap = new HashMap<>();
    // 每门课分别被哪些学生选了
    private Map<Course, List<Student>> courseStudentMap = new HashMap<>();

    /*static {
        // 初始化课程
        courses[0] = new Course(1, "高数", 6);
        courses[1] = new Course(2, "Java程序开发", 10);
        courses[2] = new Course(3, "操作系统", 9);
        courses[3] = new Course(4, "思想政治", 5);
        courses[4] = new Course(5, "英语", 10);
        courses[5] = new Course(6, "C语言", 10);
        courses[6] = new Course(7, "体育", 2);
        courses[7] = new Course(8, "编译原理", 7);
        courses[8] = new Course(9, "概率统计", 5);
        courses[9] = new Course(10, "计算机网络", 6);
        courses[10] = new Course(11, "线性代数", 5);
        courses[11] = new Course(12, "电子电路原理", 2);
    }*/

    /**
     *  维护学生和课程之间的关系
     *  用于学生选课的时候进行调用的
     * @param student   学生
     * @param course    学生选的课程
     */
    public void addStudentCourse(Student student, Course course) {
        // 1. 维护学生和课程之间的关系
        // 先拿到这个学生选的所有的课程
        List<Course> courses = studentCourseMap.get(student);
        if (courses == null) { // 学生第一次选课
            List<Course> list = new ArrayList<>();
            list.add(course);
            studentCourseMap.put(student, list);
        } else {
            courses.add(course);
        }

        // 2. 维护课程和学生之间的关系
        // 先拿到这个课程被哪些学生选了
        List<Student> students = courseStudentMap.get(course);
        if (students == null) {
            List<Student> list = new ArrayList<>();
            list.add(student);
            courseStudentMap.put(course, list);
        } else {
            students.add(student);
        }
    }

    public void setCourseMap(Map<String, Course> courseMap) {
        this.courseMap = courseMap;
    }

    public Map<String, Course> getCourseMap() {
        return courseMap;
    }

    public College(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Course[] getCourses() {
        // 拿到所有的课程信息
        // 拿到 hashMap 中所有的 value
        Collection<Course> courses = courseMap.values();
        return courses.toArray(new Course[courses.size()]);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<Course, List<Student>> getCourseStudentMap() {
        return courseStudentMap;
    }

    public Map<Student, List<Course>> getStudentCourseMap() {
        return studentCourseMap;
    }
}
