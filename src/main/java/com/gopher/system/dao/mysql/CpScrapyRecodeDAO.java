package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpScrapyRecode;
import org.springframework.stereotype.Repository;

/**
 * CpScrapyRecodeDAO继承基类
 */
@Repository
public interface CpScrapyRecodeDAO extends MyBatisBaseDao<CpScrapyRecode, Integer> {
	CpScrapyRecode getBeanByScrapyName(String scrapyName);
}