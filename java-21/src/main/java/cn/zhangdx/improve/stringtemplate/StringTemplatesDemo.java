package cn.zhangdx.improve.stringtemplate;

import static java.lang.StringTemplate.STR;

/**
 *
 * @author zhangdx
 * @date 2026/7/28 21:12
 */
public class StringTemplatesDemo {

    public static void main(String[] args) {
        testSimpleTemplate();
    }

    private static void testSimpleTemplate() {
        String name = "zhangdx";
        System.out.println(STR."hello, \{name}");

        int a = 10;
        int b = 20;
        String result = STR."""
                result=\{a*b}
                """;
        System.out.println(result);
    }
}
