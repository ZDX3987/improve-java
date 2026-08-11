package cn.zhangdx.improve;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 * instanceof模式匹配
 * 类型的判断和转换自动处理。原理是编译期自动生成类型强转。且变量作用域受到控制
 * @author zhangdx
 * @date 2026/8/11 18:27
 */
public class InstanceofPatternMatchingDemo {

    public static void main(String[] args) {
        try {
            Files.readString(Path.of("a.txt"));
        } catch (IOException e) {
            if (e instanceof NoSuchFileException ne) {
                String file = ne.getFile();
                System.out.println("file not found: " + file);
            }
            throw new RuntimeException(e);
        }
    }
}
