package com.gopher.system.service;

public interface SpiderService {
    /**
     * 开启爬虫
     * @param cpScrapyRecode
     * @return
     */
    void start(Integer id, String spiderName);

    /**
     * 关闭爬虫
     * @param cpScrapyRecode
     */
    void stop(Integer id, String job);
}
