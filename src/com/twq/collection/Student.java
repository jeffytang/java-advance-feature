package com.twq.collection;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Student extends Person {
    // 所属学院
    private College college;
    // 学号
    private String number;
    // 初始化的时候，一个学生可以选择 5 门课程
    private ArrayList<Course> selectedCourses = new ArrayList<>();
    // 记录这个学生当前选择的课程数
    private int currentSelectNum = 0;
    // 记录总学分
    private int totalCredits = 0;

    public Student(String name, int age, String number) {
        super(name, age);
        this.number = number;
    }

    public Student(String name, int age, College college, int number) {
        super(name, age);
        this.college = college;
        this.number = String.valueOf(number);
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getNumber() {
        return number;
    }

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    /**
     *  计算这个学生选择的课程的总学分
     * @return 总学分
     */
    public int getTotalCredits() {
        return totalCredits;
    }

    /**
     *  选择课程
     */
    public void selectCourse() {
        // 拿到学院所有的课程
        Course[] courses = college.getCourses();

        // 随机生成一个下标值
        Random random = new Random();
        int index = random.nextInt(courses.length);

        Course course = courses[index];
        selectedCourses.add(course);

        // 维护学生和课程之间的关系
        college.addStudentCourse(this, course);

        // 选择课程数累加 1
        currentSelectNum++;
        // 学分进行累加
        totalCredits += course.getCredits();
    }

    /**
     *  学习选择的课程
     */
    public void studyCourse() {
        if (currentSelectNum == 0) {
            throw new RuntimeException("你还没有选择课程");
        }
        Random random = new Random();
        int index = random.nextInt(currentSelectNum);
        System.out.println("正在学习：" + selectedCourses.get(index));
    }

    public int getCurrentSelectNum() {
        return currentSelectNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student)obj;
        if (this.number == other.number) { // 学号相等就表明是同一个学生
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                '}';
    }
}
