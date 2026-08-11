package cn.zhangdx.improve;

/**
 * 文本块
 * java13-preview，java15-正式
 * @author zhangdx
 * @date 2026/8/11 18:08
 */
public class TextBlockDemo {

    public static void main(String[] args) {
        String textBlock = """
                {
                    "code": 200,
                    "msg": "success";
                    "data": null
                }
                """;

        System.out.println(textBlock);
    }
}
