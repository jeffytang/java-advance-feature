package com.twq.io;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        // 创建一个文件对象
        // 需要参数：文件的路径以及文件名
        // 路径的分隔符：
        // 在 Windows 系统上使用 \ 来表示，比如：C:\TEMP\word.txt
        // 但是在 Linux 系统上使用 / 来表示，比如：/home/hadoop-twq/word.txt
        System.out.println(File.separator);
        // 绝对路径：windows从盘符开始的路径；linux 是指从根目录开始的路径
        // 相对路径：相对一个文件目录开始
        // 相对于当前的项目(project)的目录，
        // . 就是当前的项目(project)的目录
        File file = new File("." + File.separator + "data" + File.separator + "word.txt");
        // 判断文件是否存在
        boolean isFileExist = file.exists();
        System.out.println(isFileExist ? "文件存在" : "文件不存在");

        // 创建一个文件
        if (!isFileExist) {
            try {
                // 拿到文件的父亲目录
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    // 创建一个父亲目录
                    parentFile.mkdir(); // 创建文件目录
                }
                boolean isCreatedSucc = file.createNewFile();
                System.out.println(isCreatedSucc ? "文件创建成功" : "文件创建不成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 删除一个文件
            boolean isDeleteSucc = file.delete();
            System.out.println(isDeleteSucc ? "文件删除成功" : "文件删除不成功");
            // 拿到文件的父亲目录
            File parentFile = file.getParentFile();
            // 删除父亲目录
            parentFile.delete();
        }

    }
}
