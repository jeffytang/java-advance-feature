package com.twq.collection.function;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestRoster {
    public static void main(String[] args) {
        // 拿到花名册
        List<Person> roster = Person.createRoster();

        // 1. 找出年龄大于指定年龄的人，并且打印出来
        System.out.println("大于20岁的人：");
        printPersonWithPredicate(roster,
                person -> person.getAge() > 20,
                person -> person.getEmailAddress(),
                (String email) -> System.out.println(email));

        // 2. 找出年龄在一个指定范围的人，并且打印出来
        System.out.println("在 20 岁到 30 岁之间的人：");
        printPersonWithPredicate(roster,
                person -> person.getAge() >= 20 && person.getAge() <= 30,
                person -> person.getEmailAddress(),
                (String email) -> System.out.println(email));

        // 3. 找出年龄在一个指定范围并且是属于指定性别的人，并且打印出来
        // 符合义务兵条件的人
        System.out.println("符合义务兵的人：");
        printPersonWithPredicate(roster,
                person -> {
                    return person.getGender() == Person.Sex.MALE
                            && person.getAge() >= 18
                            && person.getAge() <= 25;
                },
                person -> person.getEmailAddress(), // 数据的转换
                email -> {
                    System.out.println("发送邮件给：" + email); // 措施
                });
        // 1. 函数(lambda表达式)作为方法的参数进行传递，函数式编程
        // 2. Java 中的函数(lambda表达式) 本质上就是 Java 的接口(只有一个抽象方法)，函数式接口


    }

    /**
     *  从花名册中找出年龄大于指定年龄的人，并且打印出来
     * @param roster    花名册
     * @param age   指定的年龄
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person person : roster) {
            if (person.getAge() > age) {
                person.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster,
                                                  int lowAge, int highAge) {
        for (Person person : roster) {
            if (person.getAge() >= lowAge && person.getAge() <= highAge) {
                person.printPerson();
            }
        }
    }

    /**
     *  根据指定的条件找出符合条件的人，并且打印出来
     * @param roster    花名册
     * @param checkPerson   指定的条件
     */
    public static void printPersonWithCheck(List<Person> roster,
                                            CheckPerson checkPerson) {
        for (Person person : roster) {
            if (checkPerson.test(person)) {
                person.printPerson();
            }
        }
    }

    /**
     *  根据指定的条件找出符合条件的人，并且打印出来
     * @param roster    花名册
     * @param checkPerson   指定的条件
     */
    public static void printPersonWithPredicate(List<Person> roster,
                                                Predicate<Person> checkPerson, // 条件测试
                                                Function<Person, String> mapper, // 数据类型的转换
                                                Consumer<String> consumer) { // 数据的消费
        for (Person person : roster) {
            if (checkPerson.test(person)) { // 条件测试
                String email = mapper.apply(person); // 数据的转换，Person -> String
                consumer.accept(email);   // 对符合条件的人采取一定的措施
            }
        }
    }
}
