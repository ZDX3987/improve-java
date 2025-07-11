package cn.zhangdx.java.reference;

import java.lang.ref.WeakReference;

/**
 * 模拟弱引用对象
 * VM Options: -XX:+PrintGCDetails
 * @author zhangdx
 * @date 2025/6/16 20:50
 */
public class WeakRefObjectDemo {

    @Override
    protected void finalize() {
        System.out.println("WeakRefObjectDemo 对象被回收了，执行finalize方法");
    }

    public static void main(String[] args) {
        WeakReference<WeakRefObjectDemo> demoWeakReference = new WeakReference<>(new WeakRefObjectDemo());
        System.out.println("Before GC: " + demoWeakReference.get());
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After GC: " + demoWeakReference.get());
    }
}
