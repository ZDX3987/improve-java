package cn.zhangdx.java.proxy;

import cn.zhangdx.java.service.ArticleService;
import cn.zhangdx.java.service.ArticleServiceImpl;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author zhangdx
 * @date 2025/7/2 15:06
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        ArticleService articleService = new ArticleServiceImpl();
        // JDK动态代理
        ArticleServiceInvocationHandler articleServiceInvocationHandler = new ArticleServiceInvocationHandler();
        articleServiceInvocationHandler.setTarget(articleService);
        ArticleService articleServiceJDKProxy = (ArticleService) Proxy.newProxyInstance(ArticleServiceImpl.class.getClassLoader(), new Class[]{ArticleService.class},
                articleServiceInvocationHandler);
        articleServiceJDKProxy.publish(1456);
        // CGLIB动态代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ArticleServiceImpl.class);
        enhancer.setCallback(new ArticleServiceMethodInterceptor());
        ArticleService articleServiceCGLIBProxy = (ArticleService) enhancer.create();
        articleServiceCGLIBProxy.publish(668899);
    }
}
