package com.gopher.system.dao.mysql;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpOutSite;

/**
 * CpOutSiteDAO继承基类
 */
@Repository
public interface CpOutSiteDAO extends MyBatisBaseDao<CpOutSite, Integer> {
}