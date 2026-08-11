package cn.zhangdx.improve.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Files类增强
 * @author zhangdx
 * @date 2026/8/11 16:17
 */
public class FilesImproveDemo {

    public static void main(String[] args) {
        try {
            String fileText = Files.readString(Path.of("java9-20/src/main/java/cn/zhangdx/improve/java11/StringImproveDemo.java"));
            System.out.println(fileText);
//            Files.writeString(Path.of(""), "写入文件的内容");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
