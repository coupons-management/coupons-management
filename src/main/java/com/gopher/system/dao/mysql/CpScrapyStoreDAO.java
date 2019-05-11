package com.gopher.system.dao.mysql;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpScrapyStore;

/**
 * CpScrapyStoreDAO继承基类
 */
@Repository
public interface CpScrapyStoreDAO extends MyBatisBaseDao<CpScrapyStore, Integer> {
}