package cn.zhangdx.java.proxy;

import cn.zhangdx.java.service.ArticleService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhangdx
 * @date 2025/7/2 15:03
 */
public class ArticleServiceProxy implements InvocationHandler {

    private ArticleService target;

    public void setTarget(ArticleService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ArticleServiceProxy 代理前通知");
        Object result = method.invoke(target, args);
        System.out.println("ArticleServiceProxy 代理后通知");
        return result;
    }
}
