package com.twq.io;

import java.io.*;
import java.util.Arrays;

public class TestReader {
    public static void main(String[] args) {
        // 字符输入流
        // 字节输入流包装成字符输入流
        try (Reader reader = new FileReader(".\\data\\charWriter.txt")) {
            // 读入一组字符
            char[] chars = new char[10];
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            // 当 read 方法返回 -1 的时候，表明已经读到文件的结尾
            int charNum = -1;
            while ((charNum = reader.read(chars)) != -1) {
                for (char c : chars) {
                    if (c != '\n') {
                        stringBuilder.append(c);
                    } else {
                        line = stringBuilder.toString();
                        System.out.println(line);
                        stringBuilder = new StringBuilder();
                    }
                }
                chars = new char[100];
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
