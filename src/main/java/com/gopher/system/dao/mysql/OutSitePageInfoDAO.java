package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.OutSitePageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OutSitePageInfoDAO继承基类
 */
@Repository
public interface OutSitePageInfoDAO extends MyBatisBaseDao<OutSitePageInfo, Integer> {

    List<OutSitePageInfo> findBySite(int outSiteId);

}