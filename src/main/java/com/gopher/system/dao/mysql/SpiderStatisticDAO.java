package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.SpiderStatistic;
import com.gopher.system.model.vo.request.StatisticRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SpiderStatisticDAO继承基类
 */
@Repository
public interface SpiderStatisticDAO extends MyBatisBaseDao<SpiderStatistic, Integer> {
    /**
     *
     * @return
     */
    List<SpiderStatistic> findList(StatisticRequest statisticRequest);


}