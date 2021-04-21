package com.twq.collection.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;

class ComparisonProvider {
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    public int compareByAge(Person a, Person b) {
        return a.getAge() - b.getAge();
    }
}

public class TestMethodReference {
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        // 对花名册按照年龄排序
        // 为了使得 lambda 表达式更加的简洁，我们可以使用方法引用来代替 lambda 表达式
        // 引用一个静态的方法，ClassName::MethodName
        // Collections.sort(roster, Person::compareByAge);

        // 引用一个对象实例方法，对象::方法
        ComparisonProvider comparisonProvider = new ComparisonProvider();
        Collections.sort(roster, comparisonProvider::compareByName);
        System.out.println(roster);

        roster.stream().forEach(System.out::println);

        // 引用一个类实例方法，ClassName::MethodName
        // 需求：求花名册中所有的人的平均年龄
        double minAge = roster.stream()
                .mapToInt(Person::getAge) // 将 Person -> int
                .min()
                .getAsInt();
        System.out.println(minAge);


        // 引用构造方法
        Person[] people = roster.toArray(Person[]::new);
        System.out.println(Arrays.toString(people));

        // 方法的引用：使得 lambda 表达式更加的简洁
    }
}
