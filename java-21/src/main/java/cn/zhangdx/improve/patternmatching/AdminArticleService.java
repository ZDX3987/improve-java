package cn.zhangdx.improve.patternmatching;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author zhangdx
 * @date 2026/7/27 19:17
 */
@Slf4j
public class AdminArticleService implements ArticleService {
    @Override
    public void read() {
        log.info("invoke admin article read");
    }
}
