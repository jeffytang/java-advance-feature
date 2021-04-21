package com.twq.io;

import java.io.*;

public class TestPrimitiveTypeWriter {
    public static void main(String[] args) {
        // 使用 PrintStream 输出基本类型
        try (PrintStream printStream =
                     new PrintStream(new FileOutputStream(".\\data\\primitive.txt"))) {
            long temp = 10L;
            printStream.println(temp);

            printStream.println(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用 PrintWriter 输出基本类型
        try (PrintWriter printWriter =
                     new PrintWriter(new FileOutputStream(".\\data\\primitive.txt"))) {
            long temp = 100000000L;
            printWriter.println(temp);

            printWriter.println(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
