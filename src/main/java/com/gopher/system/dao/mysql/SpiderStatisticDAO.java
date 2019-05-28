package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.SpiderStatistic;
import org.springframework.stereotype.Repository;

/**
 * SpiderStatisticDAO继承基类
 */
@Repository
public interface SpiderStatisticDAO extends MyBatisBaseDao<SpiderStatistic, Integer> {
}