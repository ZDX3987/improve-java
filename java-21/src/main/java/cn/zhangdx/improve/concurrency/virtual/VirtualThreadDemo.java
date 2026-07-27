package cn.zhangdx.improve.concurrency.virtual;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 虚拟线程简单使用案例
 * @author zhangdx
 * @date 2026/7/27 17:31
 */
public class VirtualThreadDemo {

    public static void main(String[] args) {
        System.out.println("创建虚拟线程");
        startFactoryThread(() -> {
            System.out.println(Thread.currentThread());
        });
    }

    public static void startSingleVirtualThread(Runnable runnable) {
        Thread.startVirtualThread(runnable);
    }

    public static void startFactoryThread(Runnable runnable) {
        ThreadFactory threadFactory = Thread.ofVirtual().factory();
        threadFactory.newThread(runnable).start();
    }

    public static void startExecutorVirtualThread(Runnable runnable) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.execute(runnable);
        }
    }
}
