package cn.zhangdx.java;

/**
 * @author zhangdx
 * @date 2025/6/16 12:56
 */
public class SimpleRefObject {

    private static final String DEF_NAME = "ZHANGDX";

    private String refName;

    private byte[] data;

    public SimpleRefObject() {
        this.refName = DEF_NAME;
    }

    public SimpleRefObject(String refName, boolean hasData) {
        this.refName = refName;
        if (hasData) {
            data = new byte[1024 * 1024 * 10];
        }
    }
}
