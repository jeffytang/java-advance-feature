package com.twq.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TestListFile {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\TEMP");
        // 拿到这个文件目录下的所有的路径对象
        Stream<Path> pathStream = Files.list(path);
        // pathStream.forEach(System.out::println);
        // 打印子文件的名字
        /*for (File f : subFiles) {
            System.out.println(f.getName());
        }*/

        // 拿到指定文件目录下所有的子文件
        printSubFiles(path);
    }

    /**
     *  递归打印一个文件目录中所有的子文件
     * @param path  文件目录的路径
     */
    public static void printSubFiles(Path path) throws IOException {
        if (Files.isDirectory(path)) {
            Stream<Path> pathStream = Files.list(path);
            pathStream.forEach(p -> {
                System.out.println(p.getFileName());
                try {
                    printSubFiles(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
