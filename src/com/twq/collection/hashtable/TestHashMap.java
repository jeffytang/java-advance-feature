package com.twq.collection.hashtable;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        // 创建一个散列表实例对象
        // key 是 String 类型，value 也是 String 类型
        // 散列表对应的数组的初始长度是 10
        // 触发自动扩容的元素的个数：0.75 * 10 = 7
        HashMap<String, String> map = new HashMap<>(10);

        System.out.println(hash("baidu") % 10);

        // 将数据 put 到 HashMap 中
        // 往 HashMap 中放数据 -》 put
        map.put("CTO", "tech"); // hash("CTO") % 20 = 11
        map.put("baidu", "search"); // hash("baidu") % 20 = 9
        map.put("qq", "social"); // hash("qq") % 20 = 16
        map.put("jd", "bus"); // hash("jd") % 20 = 6
        map.put("ali", "b2b"); // hash("ali") % 20 = 11
        map.put("yd", "note"); // hash("yd") % 20 = 11
        map.put("zx", "network"); // hash("zx") % 20 = 2

        // 当 map 中的键值对的个数达到了 7 个，就会自动扩容
        // 扩容后的数组的长度是 10 * 2 = 20
        map.put("gs", "bigdata"); // hash("gs") % 20 = 8
        map.put("qiyi", "video"); // hash("qiyi") % 20 = 12
        map.put("wx", "wechat");  // hash("wx") % 20 = 9
        map.put("hw", "huawei");  // hash("hw") % 20 = 3
        map.put("wy", "wangyi");  // hash("wy") % 20 = 10

        // 自动扩容，做了两件事情：
        // 1：将数组的长度扩容到 2 倍
        // 2：重新计算每一个元素存储的位置，重新计算 hash 值 % 新的数组的长度

        System.out.println(map);

        // 通过 key 从 HashMap 中拿到对应的 value
        String value = map.get("kkkk");
        System.out.println(value);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
