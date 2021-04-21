package com.twq.io;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TestString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // BOM
        String str = "A学严";
        // 拿到字符串对应的所有的字节
        byte[] bytes = str.getBytes("GBK");
        System.out.println("所占字节数量：" + bytes.length);
        System.out.println("当前默认的编码：" + Charset.defaultCharset().toString());
        str = new String(bytes, "GBK");
        System.out.println(str);
        // 产生乱码的根本原因：编码和解码使用的是不同的方式
        //
        for (byte b : bytes) {
            System.out.println(b);
        }
    }
}
