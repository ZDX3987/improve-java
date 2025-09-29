package cn.zhangdx.java.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ZDX
 * @date 2025/9/29 23:23
 */
public class ArticleServiceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("ArticleService CGLIB 代理前置通知");
        methodProxy.invokeSuper(o, objects);
//        method.invoke(o, objects);
        System.out.println("ArticleService CGLIB 代理后置通知");
        return null;
    }
}
