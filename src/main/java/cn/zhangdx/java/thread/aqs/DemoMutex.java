package cn.zhangdx.java.thread.aqs;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义同步组件Mutex的使用示例
 * @author ZDX
 * @date 2025/10/27 12:32
 */
public class DemoMutex {

    public static void main(String[] args) {
        Mutex mutex = new Mutex();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Runnable runnable = () -> {
                mutex.lock();
                try {
                    Thread.sleep(2000);
                    System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now()) + " - 第" + finalI + "个线程执行");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    mutex.unlock();
                }
            };
            new Thread(runnable).start();
        }
    }
}
