package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpTitleMessage;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * CpTitleMessageDAO继承基类
 */
@Repository
public interface CpTitleMessageDAO extends MyBatisBaseDao<CpTitleMessage, Integer> {
	List<CpTitleMessage> getAllList();
}