package com.twq.io;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TestString22 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(Charset.defaultCharset().toString());
        char[] cs = new char[]{'A', '学', '严'};
        String str = new String(cs); // UTF-8 编码
        System.out.println(str.getBytes().length); // 1 + 3 + 3 = 7
        System.out.println(str);    // A学严

        byte[] bytes = str.getBytes("GBK"); // UTF-8 转成 GBK
        System.out.println(bytes.length);   // 1 + 2 + 2 = 5
        for (byte b : bytes) System.out.println(b);

        String string = new String(bytes); // GBK 转成 UTF-8
        System.out.println(string);
        System.out.println(string.getBytes().length);
    }
}
