package cn.zhangdx.java.thread.aqs;

import cn.zhangdx.java.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义同步组件Mutex的使用示例
 * @author ZDX
 * @date 2025/10/27 12:32
 */
@Slf4j
public class DemoMutex {

    public static void main(String[] args) {
        boolean isShared = true;
        Mutex mutex = isShared ? new Mutex(isShared, 3) : new Mutex();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                mutex.lock();
                ThreadUtil.sleep(1000);
                log.info("第{}个线程执行中", (finalI + 1));
                mutex.unlock();
            }, "demo-thread-" + (i + 1)).start();
        }
    }
}
