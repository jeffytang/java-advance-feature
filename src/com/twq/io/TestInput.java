package com.twq.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestInput {
    public static void main(String[] args) {
        // Input
        // 从文件 .\data\word.txt 中读取内容，放到内存中

        // try-with-resources 代码块
        // 构造一个文件输入字节流，打开了一个文件资源
        try(InputStream inputStream = new FileInputStream(".\\data\\word.txt")) {
            // 从文件输入字节流中读入一个字节
            // 当我们读到 -1 的时候，表示已经读到文件的末尾了
            // 拿到输入流中有多少字节
            int byteNum = inputStream.available();
            byte[] bytes = new byte[byteNum];
            // 将读入的字节放入到指定的字节数组中
            inputStream.read(bytes);
            // 转成 String
            String str = new String(bytes, "UTF-8");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
