package cn.zhangdx.improve.virtual;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 虚拟线程和实体线程对比
 * @author zhangdx
 * @date 2026/7/27 18:26
 */
@Slf4j
public class VirtualThreadMockDemo {

    public static void main(String[] args) {
        var isVirtual = true;
        if (isVirtual) {
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                for (int i = 0; i < 10000; i++) {
                    executor.execute(VirtualThreadMockDemo::mockRequest);
                }
            }
        } else {
            try (ExecutorService executorService = Executors.newFixedThreadPool(200)) {
                for (int i = 0; i < 10000; i++) {
                    executorService.execute(VirtualThreadMockDemo::mockRequest);
                }
            }
        }
    }

    public static void mockRequest() {
        log.info("mockRequest start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("mockRequest end");
    }
}
