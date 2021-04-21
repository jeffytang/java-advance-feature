package com.twq.collection.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CharCount {
    public static void main(String[] args) {
        String str = "afdaadaassssdfdsaweessssf";
        // 1. 拿到这个字符串中的每一个字符
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));
        // 2. 结果的格式：<字符，次数>，<a，6>，<s，9>....
        // 需要定义一个 Map 对象来存储结果
        Map<Character, Integer> charCountMap = new HashMap<>();
        // 3. 循环遍历 chars 中的每一个字符
        for (char c : chars) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            // 3.1 如果这个字符是第一次出现，那么我们将 <字符, 1> 放到 map 中
            // 从 charCountMap 判断有没有这个字符
            /*if (!charCountMap.containsKey(c)) {
                charCountMap.put(c, 1);
            } else {
                // 3.2 如果这个字符不是第一次出现
                // 拿到这个字符已经出现的次数
                Integer count = charCountMap.get(c);
                // 对次数进行累加 1
                count += 1;
                // 将次数替换之前的次数
                charCountMap.put(c, count);
            }*/
        }
        // 迭代打印结果
        // 需要迭代 key 和 value
        Set<Map.Entry<Character, Integer>> entries = charCountMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println("字符 " + entry.getKey() + " 出现的次数是：" + entry.getValue());
        }
    }
}
