package com.gopher.system.dao.mysql;

import java.util.List;

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
	CpInSite getSiteName(String name);
	
	/**
	 * 根据站URL称来查询出站点信息
	 * @return
	 */
	CpInSite getSiteUrl(String name);
	
	List<CpInSite> getAll();
}