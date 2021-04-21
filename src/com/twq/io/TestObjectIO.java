package com.twq.io;

import java.io.*;
import java.util.List;

public class TestObjectIO {
    public static void main(String[] args) {
        // 如果一个类需要序列化的话，那么它需要实现 java.io.Serializable 这个标识接口
        // 如果这个类中有些属性不需要进行序列化的话，我们使用关键词 transient 来修饰属性
        // 我们还可以自定义方法 writeObject 和 readObject

        List<Person> roster = Person.createRoster();

        // 数据在磁盘文件中是以二进制的方式存储
        // 对象 转换成 二进制 的过程，这个过程我们称之为对象的序列化
        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(
                             new FileOutputStream(".\\data\\person.txt"))) {
            for (Person person : roster) {
                objectOutputStream.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从磁盘文件中读取对象数据
        // 二进制 转换成 对象，这个过程我们称为对象的反序列
        try (ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(".\\data\\person.txt"))) {
            Object o = null;
            // 读取一个对象的数据，转成 Object 对象
            while (true) {
                try {
                    o = objectInputStream.readObject();
                } catch (EOFException e) { // 使用异常来判断是否读到了文件的最后一个对象
                    break;
                }
                // 将 Object 对象转成 Person
                Person person = (Person) o;
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
