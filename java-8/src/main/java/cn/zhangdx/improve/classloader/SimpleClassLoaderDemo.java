package cn.zhangdx.improve.classloader;

/**
 * @author zhangdx
 * @date 2025/6/26 13:10
 */
public class SimpleClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader currentClassLoader = SimpleClassLoaderDemo.class.getClassLoader();
        StringBuilder split = new StringBuilder("|--");
        while (true) {
            System.out.println(split.toString() + currentClassLoader);
            if (currentClassLoader == null) {
                break;
            } else {
                currentClassLoader = currentClassLoader.getParent();
                split.insert(0, "\t");
            }
        }
    }
}
