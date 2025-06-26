package cn.zhangdx;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author zhangdx
 * @date 2025/6/17 13:00
 */
public class GcSimpleObjectDemo {

    public static void main(String[] args) {
//        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
//        garbageCollectorMXBeans.forEach(gc -> System.out.println("GC Name: " + gc.getName()));

        byte[] b1 = new byte[1024 * 1024 * 2];
        byte[] b2 = new byte[1024 * 1024 * 2];
        byte[] b3 = new byte[1024 * 1024 * 2];
        byte[] b4 = new byte[1024 * 1024 * 4];
    }
}
