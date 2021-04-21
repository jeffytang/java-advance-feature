package com.twq.collection.function;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class DataProcessTest {
    public static void main(String[] args) {
        // 拿到花名册
        List<Person> roster = Person.createRoster();

        // 3. 找出年龄在一个指定范围并且是属于指定性别的人，并且打印出来
        // 符合义务兵条件的人
        System.out.println("符合义务兵的人：");
        processData(roster,
                person -> {
                    return person.getGender() == Person.Sex.MALE
                            && person.getAge() >= 18
                            && person.getAge() <= 25;
                },
                person -> person.getEmailAddress(), // Person -> String
                email -> {
                    System.out.println("发送邮件给：" + email); // 措施
                });

        System.out.println("=============================================");

        // 具体的例子：
        List<String> personLines = new ArrayList<>();
        personLines.add("Fred\t1980\t6\t20\tMALE\tfred@example.com");
        personLines.add("Jane\t1990\t7\t15\tFEMALE\tjane@example.com");
        personLines.add("Jeffy\t7\t15\tFEMALE\tJeffy@example.com"); // 脏数据，缺少字段的数据
        personLines.add("George\t1991\t8\t13\tMALE\tgeorge@example.com");
        personLines.add("Kathy\t7\t15\tKathy@example.com"); // 脏数据
        personLines.add("Bob\t2000\t9\t12\tMALE\tbob@example.com");

        // 需求是：将上面的数据的每一行转成 Person 对象，并且打印每一个 Person 对象
        // 1. 过滤掉脏数据
        // 2. String -> Person 类型
        // 对 Person 类型的数据进行打印
        Function<String, Person> mapper = line -> {
            String[] fields = line.split("\t");
            int year = Integer.parseInt(fields[1]);
            int month = Integer.parseInt(fields[2]);
            int day = Integer.parseInt(fields[3]);
            LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);
            Person person = new Person(fields[0], birthday, Person.Sex.valueOf(fields[4]), fields[5]);
            return person;
        };
        processData(personLines,
                line -> line.split("\t").length == 6,
                mapper,
                person -> person.printPerson());
    }

    /**
     *  处理任意类型的数据
     * @param dataSource    数据源
     * @param filter    过滤器
     * @param mapper    转换器
     * @param consumer  数据的消费者
     * @param <X>   源数据类型
     * @param <Y>   转换之后的数据类型
     */
    public static <X, Y> void processData(Iterable<X> dataSource, // 数据源
                                                Predicate<X> filter, // 数据过滤
                                                Function<X, Y> mapper, // 数据转换
                                                Consumer<Y> consumer) { // 数据消费
        for (X element : dataSource) {
            if (filter.test(element)) { // 条件测试 --> 数据的过滤
                Y mappedElement = mapper.apply(element); // 数据的转换，X -> Y
                consumer.accept(mappedElement);   // 消费对 Y 类型的数据
            }
        }
    }
}
