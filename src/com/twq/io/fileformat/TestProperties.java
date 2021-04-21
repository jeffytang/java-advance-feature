package com.twq.io.fileformat;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        // 解析属性文件
        Properties properties = new Properties();

        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(".\\data\\test.properties"), "GBK"))) {
            properties.load(reader);
            String value = properties.getProperty("name");
            System.out.println(value);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
