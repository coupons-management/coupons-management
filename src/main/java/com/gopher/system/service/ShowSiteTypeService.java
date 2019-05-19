package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.response.SitestoreTypeTree;

/**
 * 展示站点分类业务
 * 
 * @author dongyangyang
 *
 */
public interface ShowSiteTypeService {
	/**
	 * 
	 * @param siteId
	 * @param level
	 * @return
	 */
	List<CpSitestoreType> getList(final int siteId, final int level);

	void create(CpSitestoreType cpSitestoreType);

	void edit(CpSitestoreType cpSitestoreType);

	/**
	 * 获得分类的树形结构
	 * 
	 * @return
	 */
	SitestoreTypeTree getTree(final int siteId);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void delete(int id);

}
