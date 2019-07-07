package com.gopher.system.service;

import com.gopher.system.model.entity.CpScrapyRecode;

public interface SpiderService {
    /**
     * 开启爬虫
     * @param cpScrapyRecode
     * @return
     */
    void start(CpScrapyRecode cpScrapyRecode);

    /**
     * 关闭爬虫
     * @param cpScrapyRecode
     */
    void stop(CpScrapyRecode cpScrapyRecode);
}
