package cn.zhangdx.improve.patternmatching;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zhangdx
 * @date 2026/7/27 19:13
 */
@Slf4j
public class ClientArticleService implements ArticleService {

    @Override
    public void read() {
        log.info("invoke client article read");
    }
}
