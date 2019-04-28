package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpScrapy;
import org.springframework.stereotype.Repository;

/**
 * CpScrapyDAO继承基类
 */
@Repository
public interface CpScrapyDAO extends MyBatisBaseDao<CpScrapy, String> {
}