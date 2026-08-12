package cn.zhangdx.improve;

import java.util.HashSet;
import java.util.Set;

/**
 * Record类示例，强调不可变数据类
 * @author zhangdx
 * @date 2026/8/11 18:22
 */
public class RecordClassDemo {

    public static void main(String[] args) {
        RecordDemo recordDemo = new RecordDemo("nihao", 12, new HashSet<>(Set.of("USER")));
        System.out.println(recordDemo);
        // 浅不可变，深可变
        recordDemo.roles().add("ADMIN");
        System.out.println(recordDemo);
    }
}

/**
 * 不可变数据类（浅不可变，深可变）
 * @param name
 * @param age
 */
record RecordDemo(String name, int age, Set<String> roles) {
}
