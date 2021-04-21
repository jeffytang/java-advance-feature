package com.twq.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFileMetaData {
    public static void main(String[] args) throws IOException {
        // 文件包含两部分数据：
        // 1. 元数据(MetaData)：文件的名称、文件的最后修改时间、文件的大小等
        // 2. 真实数据(data)

        // Java 中怎么操作文件的元数据
        Path path = Path.of("C:\\TEMP\\大数据技术10年发展史.zip");
        if (Files.exists(path)) {
            System.out.println("文件的名称：" + path.getFileName());
            System.out.println("文件的绝对路径：" + path.toAbsolutePath());
            // 判断文件对象是否是文件目录
            System.out.println(Files.isDirectory(path) ? "是一个文件目录" : "是一个文件");
            // 判断文件对象是否是文件
            System.out.println(!Files.isDirectory(path) ? "是一个文件" : "是一个文件目录");
            // 拿到文件最后的修改时间
            Date date = new Date(Files.getLastModifiedTime(path).toMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            System.out.println("文件的最后修改时间：" + dateFormat.format(date));
            // 拿到文件的大小
            System.out.println("文件的大小：" + Files.size(path) / 1024.0 / 1024 + "MB");
            // 判断一个文件是否是隐藏文件
            System.out.println(Files.isHidden(path) ? "是一个隐藏文件" : "不是一个隐藏文件");
        }
    }
}
