package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpSitestoreType;

/**
 * CpSitestoreTypeDAO继承基类
 */
@Repository
public interface CpSitestoreTypeDAO extends MyBatisBaseDao<CpSitestoreType, Integer> {
	/**
	 * 
	 * @param siteId
	 * @param level
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
}