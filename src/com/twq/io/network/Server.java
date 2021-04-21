package com.twq.io.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  服务端代码
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 初始化一个 ServerSocket，并且绑定监听端口为 9001
        ServerSocket serverSocket = new ServerSocket(9001);

        System.out.println("服务端起来了");

        // 监听客户端是否链接
        Socket socket = serverSocket.accept();

        // 拿到 socket 的输入流（从客户端发送过来的字节数据）
        InputStream inputStream = socket.getInputStream();
        // 拿到 socket 的输出流
        OutputStream outputStream = socket.getOutputStream();

        System.out.println("客户端连过来了。。。。");

        // 转成字符输入流
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintStream printStream = new PrintStream(outputStream)) {
            // 将客户端的数据读入内存
            String line = reader.readLine();
            System.out.println("接收到的数据：" + line);
            // 进行的消息处理，将消息进行反转
            StringBuilder sb = new StringBuilder(line);
            String reverseStr = sb.reverse().toString();
            System.out.println("处理之后的数据是：" + reverseStr);
            // 将反转之后的数据写回客户端
            printStream.println(reverseStr);
        }

        // 关闭服务端
        System.out.println("关闭服务端");
        serverSocket.close();
    }
}
