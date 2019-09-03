package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.OutSitePageInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OutSitePageInfoDAO继承基类
 */
@Repository
public interface OutSitePageInfoDAO extends MyBatisBaseDao<OutSitePageInfo, Integer> {

    List<OutSitePageInfo> findBySite(int outSiteId);
    
    /**
     * 根据站点和页面获取配置的关键词等信息
     * @param outSiteId
     * @param type
     * @return
     */
    OutSitePageInfo findOneByType(@Param("outSiteId") int outSiteId, @Param("type") int type); 

}