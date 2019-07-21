package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.*;
import com.gopher.system.model.vo.response.CpTypeResponse;
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
	/**
	 * 获取一级分类
	 * @param siteId
	 * @return
	 */
	List<CpSitestoreType> getLevelOneList(final int siteId);
	/**
	 * 根据父ID获取子列表
	 * @param pid
	 * @return
	 */
	List<CpSitestoreType> getSonList(final int pid);

	CpSitestoreType getById(Integer id);

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

	/**
	 * 添加 原始类型和站点分类映射关系
	 * 
	 * @param typeMapRequest
	 */
	void addTypeMap(TypeMapRequest typeMapRequest);

	/**
	 * 找到当前站点的所有映射列表
	 * 
	 * @param siteTypeId
	 * @return
	 */
	List<CpTypeResponse> getSourceTypeList(SourceTypeRequest sourceTypeRequest);

	/**
	 * 分页
	 * @param request
	 * @return
	 */
	Page<CpSitestoreType> getPage(CpSitestorePageRequest request);

	CpSitestoreType selectByName(CategoryDetailJspRequest categoryRequest);
}
