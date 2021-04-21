package com.twq.collection;

import java.util.Objects;

/**
 * 课程类
 */
public class Course {
    // 课程 id，唯一标识一门课程
    private int id;
    // 课程名称
    private String name;
    // 课程学分
    private int credits;

    public Course(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Course)) {
            return false;
        }

        Course other = (Course)obj;
        if (this.name.equals(other.name)) { // 课程名相同的话，那么课程对象就相等
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
