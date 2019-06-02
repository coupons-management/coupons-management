package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.vo.request.CpTypePageRequest;

/**
 * CpTypeDAO继承基类
 */
@Repository
public interface CpTypeDAO extends MyBatisBaseDao<CpType, Integer> {
	CpType getBeanByName(String name);
	
	List<CpType> getList();
	List<CpType> getTopList();
	int getTotalCount(CpTypePageRequest quest);
	List<CpType> getCategoriesPageList(CpTypePageRequest quest);
}