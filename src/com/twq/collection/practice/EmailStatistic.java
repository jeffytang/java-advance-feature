package com.twq.collection.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmailStatistic {
    public static void main(String[] args) {
        String str = "yang@163.com,ming@163.com,du@sohu.com,yong@sohu.com,zhang@qq.com,feifei@sohu.com";

        // 1. 把字符串的邮箱分离出来(用户名和邮箱地址也需要分开)
        String[] elements = str.split("[@|,]");
        System.out.println(Arrays.toString(elements));

        // 2. 分别把用户名和邮箱地址保存到一个 Map 中，比如 <yang, 163.com> <ming, 163.com>
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < elements.length; i += 2) {
            // 一次性是访问了 2 个元素
            map.put(elements[i], elements[i + 1]);
        }
        System.out.println(map);

        // 3. 统计每个邮箱地址的数量
        Collection<String> emailAddresses = map.values();
        Map<String, Integer> emailAddressCountMap = new HashMap<>();
        for (String emailAddress : emailAddresses) {
            emailAddressCountMap.put(emailAddress,
                    emailAddressCountMap.getOrDefault(emailAddress, 0) + 1);
        }
        System.out.println(emailAddressCountMap);

        // 4.1 基于 elements 来统计邮箱地址出现的次数
        emailAddressCountMap.clear();
        for (int i = 0; i < elements.length; i++) {
            // 1，3，5，7，9.....
            if (i % 2 == 1) {
                String emailAddress = elements[i];
                emailAddressCountMap.put(emailAddress,
                        emailAddressCountMap.getOrDefault(emailAddress, 0) + 1);
            }
        }
        System.out.println(emailAddressCountMap);

        // 4.2 基于 elements 来统计邮箱地址出现的次数
        emailAddressCountMap.clear();
        for (int i = 1; i < elements.length; i += 2) {
            String emailAddress = elements[i];
            emailAddressCountMap.put(emailAddress,
                    emailAddressCountMap.getOrDefault(emailAddress, 0) + 1);

        }
        System.out.println(emailAddressCountMap);
    }
}
