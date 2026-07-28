package cn.zhangdx.improve.collection;

import java.util.PriorityQueue;

/**
 *
 * @author ZDX
 * @date 2026/7/14 19:36
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(12);
        queue.add(8);
        queue.add(78);
        queue.add(34);
        queue.add(90);
        queue.add(4);
        queue.add(54);
        queue.add(22);
        System.out.println(queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.poll());
        }
    }
}
