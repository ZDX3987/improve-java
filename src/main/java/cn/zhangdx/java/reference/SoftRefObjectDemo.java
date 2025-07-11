package cn.zhangdx.java.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟软引用对象
 * VM Options: -Xmx64m -Xms64m -XX:+PrintGCDetails
 * @author zhangdx
 * @date 2025/6/16 21:01
 */
public class SoftRefObjectDemo {

    @Override
    protected void finalize() {
        System.out.println("SoftRefObjectDemo 对象被回收了，执行finalize方法");
    }

    public static void main(String[] args) {
        SoftReference<SoftRefObjectDemo> softRef = new SoftReference<>(new SoftRefObjectDemo());
        System.out.println("Before GC: " + softRef.get());
        List<byte[]> byteList = new ArrayList<>();
        try {
            for (int i = 0; i < 64; i++) {
                byteList.add(new byte[1024 * 1024]);
            }
            Thread.sleep(5000);
        } catch (Throwable e) {
            // 会抛出OOM异常
            System.out.println(e.getMessage());
        }
        System.out.println("After GC: " + softRef.get());
    }
}
