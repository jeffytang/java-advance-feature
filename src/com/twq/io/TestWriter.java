package com.twq.io;

import java.io.*;

public class TestWriter {
    public static void main(String[] args) {
        String str1 = "java.lang.Object (Java 中的始祖类)";
        String str2 = "java.lang.Exception (Java 中的异常类)";
        String str3 = "包装类 (比如 java.lang.Integer、java.lang.Double 等)";

        // 字符输出流
        // 将字节输出流包装成字符输出流
        try (Writer writer = new FileWriter(".\\data\\charWriter.txt")) {
            // 将一个字符串写入到输出流
            // 真正写字符之前，先将字符放入到 JVM 内存(缓存)中
            writer.write(str1);
            writer.write("\n"); // 输出换行符
            writer.write(str2);
            writer.write("\n"); // 输出换行符
            writer.write(str3);
            writer.write("\n"); // 输出换行符
            // 当调用 flush 的时候，才真正的将字符数据写到磁盘文件中(落盘)
            // 调用 close 的时候，数据也会落盘
            // writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
