package cn.zhangdx.java.service;

/**
 * @author zhangdx
 * @date 2025/7/2 15:02
 */
public class ArticleServiceImpl implements ArticleService {
    /**
     * 发布文章
     *
     * @param articleId 文章ID
     */
    @Override
    public void publish(Integer articleId) {
        System.out.println("ArticleServiceImpl 发布了文章："  + articleId);
    }
}
