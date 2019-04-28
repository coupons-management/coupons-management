package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpOutSite;
import org.springframework.stereotype.Repository;

/**
 * CpOutSiteDAO继承基类
 */
@Repository
public interface CpOutSiteDAO extends MyBatisBaseDao<CpOutSite, Integer> {
}