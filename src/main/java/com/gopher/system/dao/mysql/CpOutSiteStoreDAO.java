package com.gopher.system.dao.mysql;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;

/**
 * CpOutSiteStoreDAO继承基类
 */
@Repository
public interface CpOutSiteStoreDAO extends MyBatisBaseDao<CpOutSiteStore, Integer> {
	
	List<CpOutSiteStore> getList(CpOutSiteStore  cpOutSiteStore);
	
	void deleteByBean(CpOutSiteStore cpOutSiteStore);
	/**
	 * 修改热门排序
	 * @param cpSiteStore
	 */
	void updateHotSort(CpOutSiteStore cpOutSiteStore);
	/**
	 * 修改热门推荐
	 * @param cpSiteStore
	 */
	void updateAdviseSort(CpOutSiteStore cpOutSiteStore);
	/**
	 * 查询热门商家列表
	 * @return
	 */
	List<CpOutSiteStore> getHotStoreList(ShowSiteStoreRequest cpOutSiteStore);
	int getHotStoreCount(ShowSiteStoreRequest cpOutSiteStore);

	/**
	 * 查询推荐商家列表
	 * @return
	 */
	List<CpOutSiteStore> getAdviseStroreList(ShowSiteStoreRequest cpOutSiteStore);
	int getAdviseStroreCount(ShowSiteStoreRequest cpOutSiteStore);
	
	/**
	 * 查站点2中商家与站点关系
	 * @param siteStore
	 * @return
	 */
	List<CpOutSiteStoreVo> getTwoList(ShowSiteStoreRequest siteStore);
	int getTwoCount(ShowSiteStoreRequest siteStore);
	
	
	/**
	 * 查看优惠卷
	 * @return
	 */
    List<CpCoupon> getCouponList(ShowSiteStoreRequest request);
    int  getCouponCount(ShowSiteStoreRequest request);
    /**
	 * 查看新增的优惠卷
	 * @return
	 */
    List<CpCoupon> getNewCouponList(ShowSiteStoreRequest request);
    /**
   	 * 查看新增的优惠卷
   	 * @return
   	 */
       int getNewCouponCount(ShowSiteStoreRequest request);
    /**
     * 查询热门商家列表前10
     * @return
     */
    List<CpOutSiteStore> getTopHotStoreList(CpOutSiteStore request);

    /**
     * 查询推荐商家列表前10
     * @return
     */
    List<CpOutSiteStore> getTopAdviseStroreList(CpOutSiteStore request);
    /**
     * 查询家前爬虫
     * @param id
     * @return
     */
   List<String> getInScrapy(int id);
   
   /**
    * 取得有效优惠卷
    * @param id
    * @return
    */
   int getValidCoupon(ShowSiteStoreRequest  Request);
   
   /**
    * 取得总优惠卷
    * @param id
    * @return
    */
   int getToalCoupon(ShowSiteStoreRequest  Request);


}