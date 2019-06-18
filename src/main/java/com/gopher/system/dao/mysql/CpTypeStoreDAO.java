package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpTypeStore;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 展示站点内部 分类对应内部商家 关系表
 * CpTypeStoreDAO继承基类
 */
@Repository
public interface CpTypeStoreDAO extends MyBatisBaseDao<CpTypeStore, Integer> {
	/**
	 * 根据类型ID 获取当前类型所有的商家对应关系
	 * @param typeId
	 * @return
	 */
	List<CpTypeStore> getListByType(int typeId);

	/**
	 * 根据商家找到对应的分类(官网)
	 * @param storeId
	 * @return
	 */
	CpTypeStore getByStore(int storeId);
}