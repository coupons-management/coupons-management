package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.request.CategoryDetailJspRequest;
import com.gopher.system.model.vo.request.CpSitestorePageRequest;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CpSitestoreTypeDAO继承基类
 */
@Repository
public interface CpSitestoreTypeDAO extends MyBatisBaseDao<CpSitestoreType, Integer> {
	/**
	 * 
	 * @return
	 */
	List<CpSitestoreType> getList(CpSitestoreType cpSitestoreType);
	
	List<CpSitestoreType> getSonList(int pid);

	/**
	 * 根据父ID删除分类
	 * 
	 * @param pid
	 * @return
	 */
	Integer deleteByPid(int pid);
	/**
	 * 通过名称查询
	 * @return
	 */
	CpSitestoreType getByName(CpSitestoreType cpSitestoreType);

	CpSitestoreType getById(Integer id);

	List<CpSitestoreType> getStoreSort(CpSitestoreRequest request) ;

	CpSitestoreType get(@Param("storeId") int storeId,@Param("siteId") int siteId);

	List<CpSitestoreType> getPage(CpSitestorePageRequest request);

	int getCount(CpSitestorePageRequest request);

	CpSitestoreType selectByName(CategoryDetailJspRequest categoryRequest);

}