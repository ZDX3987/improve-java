package cn.zhangdx.java.thread.aqs;

import cn.zhangdx.java.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author zhangdx
 * @date 2026/6/26 14:49
 */
@Slf4j
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                lock.lock();
                log.info("第{}个线程执行", (finalI + 1));
                ThreadUtil.sleep(1000);
                lock.unlock();
            }, "demo-thread-" + (i+1)).start();
        }
    }
}
