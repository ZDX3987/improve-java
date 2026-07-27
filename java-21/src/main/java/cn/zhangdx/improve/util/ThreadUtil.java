package cn.zhangdx.improve.util;

/**
 *
 * @author zhangdx
 * @date 2026/7/27 22:44
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
