package com.twq.io.network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class QQClient {
    public static void main(String[] args) throws IOException {
        // 构建客户端的 Socket
        Socket socket = new Socket("127.0.0.1", 9001);

        System.out.println("客户端起来了。。。");
        // 拿到字节输出流
        OutputStream outputStream = socket.getOutputStream();
        // 拿到字节输入流
        InputStream inputStream = socket.getInputStream();

        System.out.println("客户端开始发消息");

        // 字节输出流 -》 可以写基本类型数据的输出流
        try (PrintStream printStream = new PrintStream(outputStream);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            Scanner scanner = new Scanner(System.in);
            while (true) {
                // 向服务端发送消息
                System.out.println("我说：");
                String message = scanner.nextLine();

                printStream.println("小明说：" + message);

                // 接收服务端发送过来的消息

                String line = reader.readLine();
                System.out.println(line);

                // 结束会话
                if (message.equals("bye") || line.equals("bye")) {
                    // 关闭 socket
                    socket.close();
                    break;
                }
            }

        }
    }
}
