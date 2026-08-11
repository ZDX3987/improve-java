package cn.zhangdx.improve;

/**
 * Switch表达式增强
 * java12-preview，java14-正式
 * @author zhangdx
 * @date 2026/8/11 16:49
 */
public class SwitchDemo {

    public static void main(String[] args) {
        var day = 1;
        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> "Unknown";
        };
        System.out.println(result);
    }
}
