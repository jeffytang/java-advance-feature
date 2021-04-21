package com.twq.collection.function;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestStream {
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        // 函数式编程
        // data process pipeline
        // 链式开发
        // 符合义务兵的人，然后给他发邮件
        // 数据源
        roster.stream()
                .filter(person -> {     // 数据的过滤
                    return person.getGender() == Person.Sex.MALE
                            && person.getAge() >= 18
                            && person.getAge() <= 25;
                })
                .map(person -> person.getEmailAddress())    // 数据转换
                .forEach(email -> System.out.println("发送邮件给：" + email)); // 数据消费

        // 使用 Stream 重写具体的例子：
        List<String> personLines = new ArrayList<>();
        personLines.add("Fred\t1980\t6\t20\tMALE\tfred@example.com");
        personLines.add("Jane\t1990\t7\t15\tFEMALE\tjane@example.com");
        personLines.add("Jeffy\t7\t15\tFEMALE\tJeffy@example.com"); // 脏数据，缺少字段的数据
        personLines.add("George\t1991\t8\t13\tMALE\tgeorge@example.com");
        personLines.add("Kathy\t7\t15\tKathy@example.com"); // 脏数据
        personLines.add("Bob\t2000\t9\t12\tMALE\tbob@example.com");

        Function<String, Person> mapper = line -> {
            String[] fields = line.split("\t");
            int year = Integer.parseInt(fields[1]);
            int month = Integer.parseInt(fields[2]);
            int day = Integer.parseInt(fields[3]);
            LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);
            Person person = new Person(fields[0], birthday, Person.Sex.valueOf(fields[4]), fields[5]);
            return person;
        };

        personLines.stream()
                .filter(line -> line.split("\t").length == 6)
                .map(mapper)
                .forEach(person -> person.printPerson());
    }
}
