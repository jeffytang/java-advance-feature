package com.twq.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable { // 标识接口，说明这个类就可以序列化了

    public enum Sex {
        MALE, FEMALE
    }

    // 名字
    private String name;
    // 生日(出生的日期)
    private LocalDate birthday;
    // 性别
    private Sex gender;
    // 邮箱地址
    private String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    /**
     *  获取这个人的年龄
     * @return
     */
    public int getAge() {
        return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void printPerson() {
        System.out.println("姓名是：" + name + ", 年龄是：" + getAge());
    }

    /**
     *  比较两个人的年龄
     * @param p1
     * @param p2
     * @return
     */
    public static int compareByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }


    // 自定义序列化的属性
    private void writeObject(ObjectOutputStream s) throws IOException {
        //System.out.println("序列化");
        s.writeUTF(name); // 输出一个字符串
        s.writeObject(birthday); // 输出一个对象
        // s.writeObject(gender);
        s.writeUTF(emailAddress);
    }
    // 自定义反序列的属性
    // 顺序一定要和序列化的顺序一样
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        //System.out.println("反序列化");
        this.name = s.readUTF();
        this.birthday = (LocalDate)s.readObject();
        // this.gender = (Sex)s.readObject();
        this.emailAddress = s.readUTF();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    // 创建花名册
    public static List<Person> createRoster() {
        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com"));
        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Person.Sex.MALE, "bob@example.com"));

        return roster;
    }

}
