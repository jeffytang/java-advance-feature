package com.twq.collection.hashtable;

import com.twq.collection.College;
import com.twq.collection.Course;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        College college = new College("xx计算机学院");

        // 初始化课程
        Map<String, Course> courseMap = new HashMap<>();
        courseMap.put("高数", new Course(1, "高数", 6));
        courseMap.put("Java程序开发", new Course(2, "Java程序开发", 10));
        courseMap.put("操作系统", new Course(3, "操作系统", 9));
        courseMap.put("思想政治", new Course(4, "思想政治", 5));
        courseMap.put("英语", new Course(5, "英语", 10));
        courseMap.put("C语言", new Course(6, "C语言", 10));
        courseMap.put("体育", new Course(7, "体育", 2));
        courseMap.put("编译原理", new Course(8, "编译原理", 7));
        courseMap.put("概率统计", new Course(9, "概率统计", 5));
        courseMap.put("计算机网络", new Course(10, "计算机网络", 6));
        courseMap.put("线性代数", new Course(11, "线性代数", 5));
        courseMap.put("电子电路原理", new Course(12, "电子电路原理", 2));

        // 给学院设置课程
        college.setCourseMap(courseMap);

        // 拿到学院所有的课程
        Map<String, Course> map = college.getCourseMap();

        // 1. 查询 API
        // 判断一个 HashMap 是否为空
        boolean isEmpty = map.isEmpty();
        System.out.println(isEmpty); // false

        // 拿到这个 map 的大小
        System.out.println("课程的数量是：" + map.size());

        // 根据 key 拿到对应的 value
        Course course = map.getOrDefault("C语言",
                new Course(9999, "无名课", -100));
        System.out.println(course);

        // 不管你使用 containsKey 还是使用 containsValue，key 和 value 对应的类必须重写 equals 方法
        // 判断 map 中是否包含指定的 key --> containsKey
        boolean isExist = map.containsKey("足球课");
        System.out.println(isExist);

        // 判断 map 中是否包含指定的 value --> containsValue
        // containsValue 依赖 equals 来比较的
        Course c = new Course(6, "C语言", 10);
        isExist = map.containsValue(c);
        System.out.println(isExist);

        // 2. 修改 API
        // 往 Map 中添加一个键值对
        Course newCourse = new Course(13, "大数据入门", 23);
        newCourse = map.put("大数据入门", newCourse);
        System.out.println(map.get("大数据入门"));

        newCourse = new Course(6, "C语言", 90);
        // 如果 map 中已经存在了 key，就不进行 put
        // 否则进行 put
        map.putIfAbsent("C语言-2", newCourse);
        // 充当修改的 API，当 key 已经存在于 map 中，就是修改这个 key 对应的 value的值
        map.put("C语言", newCourse);

        // 指定 key 从 map 中删除键值对
        map.remove("C语言");

        // 指定 key 以及 value 从 map 中删除键值对
        map.remove("高数", new Course(1, "高数", 6));
        System.out.println(map.get("高数"));

        // 清空整个 map
        map.clear();
        System.out.println(map.isEmpty());

    }
}
