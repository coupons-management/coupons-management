package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpScrapy;

/**
 * CpScrapyDAO继承基类
 */
@Repository
public interface CpScrapyDAO extends MyBatisBaseDao<CpScrapy, Integer> {
	
	CpScrapy getBeanByName(String name);
	
	List<CpScrapy> getList();
}