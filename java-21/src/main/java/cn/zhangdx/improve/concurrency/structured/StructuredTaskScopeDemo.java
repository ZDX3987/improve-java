package cn.zhangdx.improve.concurrency.structured;

import cn.zhangdx.improve.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.StructuredTaskScope;

/**
 *
 * @author zhangdx
 * @date 2026/7/27 22:23
 */
@Slf4j
public class StructuredTaskScopeDemo {

    public static void main(String[] args) throws InterruptedException {
        try (StructuredTaskScope.ShutdownOnFailure structuredTaskScope = new StructuredTaskScope.ShutdownOnFailure()) {
            structuredTaskScope.fork(() -> StructuredTaskScopeDemo.task1());
            structuredTaskScope.fork(() -> StructuredTaskScopeDemo.task2());
            structuredTaskScope.fork(() -> StructuredTaskScopeDemo.task3());
            structuredTaskScope.join();
            log.info("task invoke complete");
        }

    }

    private static String task1() {
        log.info("invoke task1 start");
        ThreadUtil.sleep(5000);
        log.info("invoke task1 end");
        return "";
    }

    private static String task2() {
        log.info("invoke task2 start");
        ThreadUtil.sleep(1000);
        log.info("invoke task2 end");
        return "";
    }

    private static String task3() {
        log.info("invoke task3 start");
        ThreadUtil.sleep(6000);
        log.info("invoke task3 end");
        return "";
    }
}
