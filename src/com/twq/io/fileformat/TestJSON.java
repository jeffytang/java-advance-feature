package com.twq.io.fileformat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.twq.io.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.List;

public class TestJSON {
    public static void main(String[] args) {
        // Json -> Java 对象
        // readJSON();

        // readPersonJSON();

        // Java 对象 -> Json
        toJsonString();
    }

    private static void toJsonString() {
        Group group = new Group();
        group.setId(0);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        // group -> json
        String jsonStr = JSON.toJSONString(group);

        System.out.println(jsonStr);
    }

    private static void readPersonJSON() {
        String personJSON = getJSONString(".\\data\\person.json");
        // json -> List<Person>

        JSONArray jsonArray = JSON.parseArray(personJSON);
        jsonArray.stream().map(obj -> {
            // Object -> Person
            JSONObject jsonObject = (JSONObject)obj;
            String name = jsonObject.getString("name");
            int year = jsonObject.getIntValue("year");
            int month = jsonObject.getIntValue("month");
            int day = jsonObject.getIntValue("day");
            LocalDate birthday = IsoChronology.INSTANCE.date(year, month, day);
            Person.Sex gender = Person.Sex.valueOf(jsonObject.getString("gender"));
            String emailAddress = jsonObject.getString("email");
            Person person = new Person(name, birthday, gender, emailAddress);
            return person;
        }).forEach(System.out::println);
    }

    private static void readJSON() {
        // 拿到 JSON 字符串
        String userJson = getJSONString(".\\data\\group_user.json");

        // json -> User 对象
        // 通过反射设置对象的属性值
        // 解析一个对象的话，使用 parseObject
        // User user = JSON.parseObject(userJson, User.class);

        // 解析一个列表(数组)
        List<Group> groups = JSON.parseArray(userJson, Group.class);

        System.out.println(groups);
    }

    private static String getJSONString(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
