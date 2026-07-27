package cn.zhangdx.improve.util;

/**
 *
 * @author zhangdx
 * @date 2026/6/26 11:34
 */
public class ThreadUtil {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
