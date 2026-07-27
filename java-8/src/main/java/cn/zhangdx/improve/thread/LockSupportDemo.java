package cn.zhangdx.improve.thread;

import java.util.concurrent.locks.LockSupport;

/**
 *
 * @author ZDX
 * @date 2025/12/1 16:12
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
            LockSupport.park("Blocker");
            System.out.println("Thread is parked");
        });
        System.out.println("Main Thread is running");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Blocker info: " + LockSupport.getBlocker(thread));
        LockSupport.unpark(thread);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Blocker info: " + LockSupport.getBlocker(thread));
        System.out.println("Main Thread is end");
    }
}
