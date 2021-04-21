package com.twq.io;

import java.io.*;

public class TestOutput {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "学Java";
        // UTF-8 : 7 个字节
        // 11100101 10101101 10100110 01001010 01100001 01110110 01100001
        // E5ADA64A617661
        byte[] bytes = str.getBytes("UTF-8");

        // 将这个字符串写入到当前目录下的 .\data\word.txt

        // 构建一个磁盘文件字节输出流 (相当于打开了一个资源)
        // 默认的话，是覆盖文件中原有的内容
        try (OutputStream outputStream =
                     new FileOutputStream(".\\data\\word.txt", true)) {
            /*for (byte b: bytes) {
                // 将内存中的每个字节写入到磁盘文件字节输出流中
                outputStream.write(b);
            }*/
            // 将所有的字节一次性输出到文件中
             outputStream.write(bytes);
            // 写入字节数组中指定的元素
            // off ：表示开始的下标
            // len ： 表示需要写入的字节的长度
            // outputStream.write(bytes, 3, 2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
