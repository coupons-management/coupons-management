package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpOutSite;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CpOutSiteDAO继承基类
 */
@Repository
public interface CpOutSiteDAO extends MyBatisBaseDao<CpOutSite, Integer> {
    /**
     *
     * @return
     */
    List<CpOutSite> getList();
}