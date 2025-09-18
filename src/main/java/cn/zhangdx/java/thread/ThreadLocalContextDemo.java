package cn.zhangdx.java.thread;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZDX
 * @date 2025/7/14 16:27
 */
public class ThreadLocalContextDemo {

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60,
            TimeUnit.SECONDS, new java.util.concurrent.ArrayBlockingQueue<>(100));

    public static void main(String[] args) {
        ThreadLocalContext.set("123");
        ThreadLocalContext.setInheritable("456");
        System.out.println("主线程打印ThreadLocal值：" + ThreadLocalContext.get());
        System.out.println("主线程打印InheritableThreadLocal值：" + ThreadLocalContext.getInheritable());
        new Thread(() -> {
            System.out.println("子线程打印ThreadLocal值：" + ThreadLocalContext.get());
            System.out.println("子线程打印InheritableThreadLocal值：" + ThreadLocalContext.getInheritable());
        }).start();

        // 可在线程池复用的TransmittableThreadLocal
        Executor ttlExecutor = TtlExecutors.getTtlExecutor(threadPoolExecutor);
        for (int i = 0; i < 10; i++) {
            ThreadLocalContext.setTransmittable("TransmittableThreadLocalValue--" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ttlExecutor.execute(() -> {
                String name = Thread.currentThread().getName();
                System.out.println("子线程 " + name + "打印TransmittableThreadLocal值：" + ThreadLocalContext.getTransmittable());
            });
        }
    }
}
