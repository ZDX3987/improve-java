package cn.zhangdx.improve.thread.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author zhangdx
 * @date 2025/12/2 18:01
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    Thread.sleep((long) (Math.random() * 3000));
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "执行结束");
                } catch (BrokenBarrierException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
