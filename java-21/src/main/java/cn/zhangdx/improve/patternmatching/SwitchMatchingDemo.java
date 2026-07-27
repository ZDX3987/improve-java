package cn.zhangdx.improve.patternmatching;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zhangdx
 * @date 2026/7/27 19:12
 */
@Slf4j
public class SwitchMatchingDemo {

    public static void main(String[] args) {
        ArticleService articleService = new ClientArticleService();

        switch (articleService) {
            case ClientArticleService clientArticleService -> {
                clientArticleService.read();
                log.info("incr article read count");
            }
            case AdminArticleService adminArticleService -> {
                log.info("check admin permission");
                adminArticleService.read();
            }
            default -> throw new IllegalStateException("Unexpected value: " + articleService);
        }
    }
}
