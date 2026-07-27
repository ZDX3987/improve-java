package cn.zhangdx.improve.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author zhangdx
 * @date 2025/11/18 11:21
 */
@Slf4j
public class TheadPoolDebugDemo {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        int count = 100;
        do {
            int no = 100 - count;
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("no: {}, ThreadPoolState: shutdown-{}, terminating-{}, terminated-{}", no,
                        threadPoolExecutor.isShutdown(), threadPoolExecutor.isTerminating(), threadPoolExecutor.isTerminated());
            });
            count--;
        } while (count > 0);
        System.out.println("执行完成");
        threadPoolExecutor.shutdown();
        System.out.println("线程池已关闭: "+threadPoolExecutor.isTerminated());
    }
}
