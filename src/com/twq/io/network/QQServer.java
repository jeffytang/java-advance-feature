package com.twq.io.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class QQServer {
    public static void main(String[] args) throws IOException {
        // 初始化一个 ServerSocket，并且绑定监听端口为 9001
        ServerSocket serverSocket = new ServerSocket(9001);

        System.out.println("服务端起来了");

        while (true) {
            // 监听客户端是否链接
            Socket socket = serverSocket.accept();
            // 拿到 socket 的输入流（从客户端发送过来的字节数据）
            InputStream inputStream = socket.getInputStream();
            // 拿到 socket 的输出流
            OutputStream outputStream = socket.getOutputStream();

            // 转成字符输入流
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                 PrintStream printStream = new PrintStream(outputStream)) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    // 将客户端的数据读入内存
                    String line = reader.readLine();
                    System.out.println(line);
                    // 将消息写会客户端
                    System.out.println("我说：");
                    String response = scanner.nextLine();
                    printStream.println("小芳说：" + response);

                    // 结束会话
                    if (response.equals("bye") || line.equals("bye")) {
                        serverSocket.close();
                        break;
                    }
                }

            }
        }
    }
}
