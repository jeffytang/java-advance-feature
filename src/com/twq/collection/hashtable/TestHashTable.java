package com.twq.collection.hashtable;

import com.twq.collection.Student;

public class TestHashTable {
    public static void main(String[] args) {
        // Alt + Enter --> 自动导包
        Student s1 = new Student("张三", 20, "051100");
        Student s2 = new Student("李四", 21, "051101");
        Student s3 = new Student("王五", 22, "051102");
        Student s4 = new Student("钱六", 23, "051103");
        Student s5 = new Student("赵七", 19, "051104");

        // 051102 ： 05 表示年级，11 表示班级，02 表示编号
        // value
        // 通过散列函数将 key 转成数组的下标
        // 通过下标将 key 对应的 value 存储在相应的数组元素中
        Student[] students = new Student[5];
        students[hash(s1.getNumber())] = s1;
        students[hash(s2.getNumber())] = s2;
        students[hash(s3.getNumber())] = s3;
        students[hash(s4.getNumber())] = s4;
        students[hash(s5.getNumber())] = s5;

        // 目标：通过某个 key 访问对应的 value。通过 学号 访问对应的学生
        // 将 key 转换成数组对应的下标，然后通过下标来访问数组。将学号转成下标
        String key1 = "051103";
        String key2 = "061003";
        System.out.println(hash(key1));
        System.out.println(hash(key2));
        // 散列冲突，导致数据丢失
        Student s6 = new Student("唐八", 23, "061003");
        students[hash(s6.getNumber())] = s6;

        // 通过学号快速找到对应的学生
        String number = "051103";
        // 将学号转成下标
        int index = hash(number); // 3
        // 通过下标访问数组
        System.out.println(students[index]);
    }

    /**
     *  散列函数
     *  将学号转成数组的下标
     * @param key 学号
     * @return  对应的数组下标
     */
    public static int hash(String key) { // key（键）
        // 拿到学号的最后两位字符
        String lastTwoChars = key.substring(key.length() - 2);
        // 转成 int 类型
        return Integer.valueOf(lastTwoChars);
    }

    /**
     *  将学号转成数组的下标
     *
     * @param number    学号
     * @return 对应的数组下标
     */
    public static int hash(int number) {
        // 学号就是数组的下标
        return number;
    }
}
