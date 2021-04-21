package com.twq.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedReader {
    public static void main(String[] args) {
        // 重点记住
        // BufferedReader : 读取的时候，会先将读到的数据放到缓存(内存)中
        // 提高性能
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(".\\data\\charWriter.txt"))) {
            // 当返回的字符串是 null 的时候，说明已经读到文件的末尾
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
