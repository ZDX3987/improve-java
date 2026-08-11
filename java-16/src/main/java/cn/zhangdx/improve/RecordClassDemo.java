package cn.zhangdx.improve;

/**
 * Record类示例，强调不可变数据类
 * @author zhangdx
 * @date 2026/8/11 18:22
 */
public class RecordClassDemo {

    public static void main(String[] args) {
        RecordDemo recordDemo = new RecordDemo("nihao", 12);
        System.out.println(recordDemo);
    }
}

record RecordDemo(String name, int age) {
}
