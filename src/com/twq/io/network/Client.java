package com.twq.io.network;

import java.io.*;
import java.net.Socket;

/**
 *  客户端代码
 */
public class Client {
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
            // 向服务端发送消息
            printStream.println("HelloWorld!");

            // 接收服务端发送过来的消息
            String line = reader.readLine();
            System.out.println("服务端发送过来的消息是：" + line);
        }

        // 关闭客户端
        System.out.println("客户端关闭了");
        socket.close();

    }
}
