package cn.zhangdx.improve.java11;

/**
 * String增强
 * @author zhangdx
 * @date 2026/8/11 15:50
 */
public class StringImproveDemo {

    public static void main(String[] args) {
        System.out.println(" ".isBlank());
        var s1 = "Hello World\nString Improve Demo";
        s1.lines().forEach(System.out::println);
        var s2 = "  你好，这是一个包含空格的中文字符串，使用 strip方法去除空白字符，支持Unicode ";
        System.out.println(s2.strip());
    }
}
