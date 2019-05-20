package com.gopher.system.dao.mysql;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpInSite;

/**
 * CpInSiteDAO继承基类
 */
@Repository
public interface CpInSiteDAO extends MyBatisBaseDao<CpInSite, Integer> {
	/**
	 * 根据站点名称来查询出站点信息
	 * @return
	 */
	public CpInSite getSiteName(String name);
}