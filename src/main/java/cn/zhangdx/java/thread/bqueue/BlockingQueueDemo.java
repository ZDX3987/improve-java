package cn.zhangdx.java.thread.bqueue;

import cn.zhangdx.java.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author zhangdx
 * @date 2026/6/26 11:32
 */
@Slf4j
public class BlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
    }
}

@Slf4j
class Producer implements Runnable {
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log.info("Producer set element start!");
        try {
            queue.put("你好");
            ThreadUtil.sleep(2000);
            queue.put("，这是一个");
            ThreadUtil.sleep(2000);
            queue.put("消息！");

            for (int i = 0; i < 20; i++) {
                ThreadUtil.sleep(1000);
                queue.put("el: " + (i + 1));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Producer set element complete!");
    }
}

@Slf4j
class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log.info("Consumer get element start!");
        try {
            String element = queue.take();
            log.info("Consumer get element value: {}!", element);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Consumer get element complete!");
    }
}
