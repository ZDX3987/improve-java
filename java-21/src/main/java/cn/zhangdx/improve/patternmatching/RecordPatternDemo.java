package cn.zhangdx.improve.patternmatching;

/**
 *
 * @author zhangdx
 * @date 2026/7/27 22:02
 */
public class RecordPatternDemo {

    public static void main(String[] args) {
        User user = new User("张三", new UserRole("admin"));
        if (user instanceof User(String username, UserRole role)) {
            System.out.println("username: " + username + ", roleName: " + role.roleName());
        }
    }
}

record User(String username, UserRole role) {}

record UserRole(String roleName) {}