package cn.zhangdx.proxy;

import cn.zhangdx.service.ArticleService;
import cn.zhangdx.service.ArticleServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author zhangdx
 * @date 2025/7/2 15:06
 */
public class ProxyDemo {

    public static void main(String[] args) {
        ArticleService articleService = new ArticleServiceImpl();
        ArticleServiceProxy articleServiceProxy = new ArticleServiceProxy();
        articleServiceProxy.setTarget(articleService);

        ArticleService articleService1 = (ArticleService) Proxy.newProxyInstance(ArticleServiceImpl.class.getClassLoader(), new Class[]{ArticleService.class}, articleServiceProxy);
        articleService1.publish(1456);
    }
}
