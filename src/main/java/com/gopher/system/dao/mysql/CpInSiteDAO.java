package com.gopher.system.dao.mysql;

import com.gopher.system.model.CpInSite;
import org.springframework.stereotype.Repository;

/**
 * CpInSiteDAO继承基类
 */
@Repository
public interface CpInSiteDAO extends MyBatisBaseDao<CpInSite, Integer> {
	/**
	 * 根据站点名称来查询出站点信息
	 * @return
	 */
	public CpInSite getSiteByName(String name);
}