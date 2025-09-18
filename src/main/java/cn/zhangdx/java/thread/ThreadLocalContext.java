package cn.zhangdx.java.thread;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author ZDX
 * @date 2025/7/14 16:21
 */
public class ThreadLocalContext {

    private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();
    private static final ThreadLocal<String> INHERITABLE_CONTEXT = new InheritableThreadLocal<>();
    private static final ThreadLocal<String> TRANSMITTABLE_CONTEXT = new TransmittableThreadLocal<>();

    public static String get() {
        return CONTEXT.get();
    }

    public static void set(String value) {
        CONTEXT.set(value);
    }

    public static String getInheritable() {
        return INHERITABLE_CONTEXT.get();
    }

    public static void setInheritable(String value) {
        INHERITABLE_CONTEXT.set(value);
    }
    public static String getTransmittable() {
        return TRANSMITTABLE_CONTEXT.get();
    }

    public static void setTransmittable(String value) {
        TRANSMITTABLE_CONTEXT.set(value);
    }

}
