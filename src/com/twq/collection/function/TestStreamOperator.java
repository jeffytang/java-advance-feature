package com.twq.collection.function;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStreamOperator {
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        // 打印所有男性的人的姓名
        for (Person person : roster) {
            if (person.getGender() == Person.Sex.MALE) {
                System.out.println(person.getName());
            }
        }
        System.out.println("-------------------------------------");
        // 每一次使用 stream 编程的时候，我们都是构建了一个数据处理的 pipeline：
        // 1. 一个数据源，可以是集合，也可以是数组
        // 2. 零个或者多个中间的操作，将一个 Stream 转成另一个 Stream，比如 filter、map 等
        // 3. 一个终端操作(最后的一个 action 操作)，输出结果，或者得到结果
        roster.stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .forEach(person -> System.out.println(person.getName()));

        // 数组作为数据源
        int[] arr = new int[]{1, 4, 2, 5, 6, 3, 1};
        // 输出大于 3 的元素
        Arrays.stream(arr)
                .filter(i -> i > 3)
                .forEach(i -> System.out.println(i));

        System.out.println("=====================================");

        // flatMap 中间的操作
        // map 一个类型转成另一个类型，一对一的关系
        // flatMap 一个类型转成另一个类型，一对多的关系
        String[] strings = new String[] {
                "this is my first example",
                "The following example calculates",
                "Aggregate operations do not"
        };
        Set<String> words = Arrays.stream(strings)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.toSet());
        System.out.println(words);

        System.out.println("-------------------------------------");

        // 需求：求花名册中所有的人的平均年龄
        double minAge = roster.stream()
                .mapToInt(person -> person.getAge()) // 将 Person -> int
                .min()
                .getAsInt();
        System.out.println(minAge);
    }
}
