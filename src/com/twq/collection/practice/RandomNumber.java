package com.twq.collection.practice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumber {
    public static void main(String[] args) {
        // 生成 10 个 0 到 19 之间的不重复的随机数
        // 1. 生成的是随机数，需要 Random 类
        Random random = new Random();
        // 2. 生成的数字是不重复的，可以使用 HashSet
        Set<Integer> set = new HashSet<>();
        // 3. 10 个，判断，如果 set 的大小小于 10 个的话，就要一直往 set 中添加数字
        while (set.size() < 10) {
            // 4. 添加随机数(0 到 19)
            Integer num = random.nextInt(20);
            set.add(num);
        }
        // 5. 遍历 set
        for (Integer i : set) {
            System.out.print(i + ", ");
        }
    }
}
