package com.gopher.system.worker;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.SpiderStatisticDAO;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.SpiderStatistic;
import com.gopher.system.util.DateUtils;
import com.gopher.system.worker.vo.SpiderStatisticVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 定时统计每一天每一个爬虫的数据爬取情况
 * 
 * @author dongyangyang
 *
 */
public class SpiderStatisticJob {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpiderStatisticJob.class);
	@Autowired
	private CpCouponDAO cpCouponDAO;
	@Autowired
	private CpStoreDAO cpStoreDAO;
	@Autowired
	private CpScrapyDAO cpScrapyDAO;
	@Autowired
	private SpiderStatisticDAO spiderStatisticDAO;
	
	/**
	    * 根据爬虫统计 新增的优惠券 有效的优惠券 优惠券总数
	 */
	public void statisticBySpider() {
		// 这个定时任务 会在凌晨1点或2点启动 所以计算时间以前天END->昨天END
		// 1获取当天爬虫爬取的所有优惠券,所有的新增商家数量,更新的商家数量
		// 2获取当天爬虫爬取的所有商家 根据商家ID统计 对应的爬取优惠券数量 
		List<CpScrapy> list = cpScrapyDAO.getList();

		if(null != list) {
			for (CpScrapy cpScrapy : list) {
				final int spiderId  = cpScrapy.getId();
				final Date yesterday = DateUtils.getOneDayEndDate(-1);
				List<CpStore> storeList = cpStoreDAO.getListBySpider(spiderId);
				if(null != storeList){
                     for(CpStore store : storeList){
						 final int storeId        = store.getId();
                         final int incrementCount = this.getIncrementCount(storeId);
                         final int totalCount     = this.getTotalCount(storeId);
                         final int validCount     = this.getValidCount(storeId);
						 SpiderStatistic spiderStatistic = new SpiderStatistic();
						 spiderStatistic.setSpiderId(spiderId);
						 spiderStatistic.setStoreId(storeId);
						 spiderStatistic.setCreateTime( DateUtils.getOneDayEndDate(-1));
						 // 新增的优惠券数量
						 spiderStatistic.setIncrementCoupon(incrementCount);
						 // 未过期的优惠券
						 spiderStatistic.setValidCoupon(validCount);
						 // 总优惠券
						 spiderStatistic.setTotalCoupon(totalCount);
						 if(isTheSameDay(store.getCreateTime(),yesterday)){
						 	// 商家的创建时间是昨天, 那么这个商家在当天就是新增的商家
							 spiderStatistic.setIsNewStore(1);
						 }else{
							 spiderStatistic.setIsNewStore(0);
						 }
						 spiderStatisticDAO.insert(spiderStatistic);
					 }
				}


			}
		}
	}
	private boolean isTheSameDay(Date one,Date two){
           final long one_day_miles = 24*60*60*1000;
           return (two.getTime()-one.getTime()) < one_day_miles;
	}
	/**
	 * 当天这个商家新增得优惠券数量
	 * @param storeId
	 * @return
	 */
	private int getIncrementCount(int storeId){
		SpiderStatisticVO query = new SpiderStatisticVO();
		final Date yesterday = DateUtils.getOneDayEndDate(-1);
		final Date beforeYesterday = DateUtils.getOneDayEndDate(-2);
		LOGGER.info("时间范围:{}~{}",DateUtils.getDatetimeString(beforeYesterday),DateUtils.getDatetimeString(yesterday));
		query.setBeginTime(beforeYesterday);
		query.setEndTime(yesterday);
		query.setStoreId(storeId);
		// 当天新增得优惠券
		return cpCouponDAO.getTotalCounBySpiderAndTime(query);
	}

	/**
	 * 当天这个商家优惠券总数
	 * @param storeId
	 * @return
	 */
	private int getTotalCount(int storeId){
		SpiderStatisticVO query = new SpiderStatisticVO();
		query.setStoreId(storeId);
		// 当天新增得优惠券
		return cpCouponDAO.getTotalCounBySpiderAndTime(query);
	}

	/**
	 * 当天这个商家有效的优惠券
	 * @param storeId
	 * @return
	 */
	private int getValidCount(int storeId){
		final Date yesterday = DateUtils.getOneDayEndDate(-1);
		SpiderStatisticVO query = new SpiderStatisticVO();
		query.setStoreId(storeId);
		query.setExpiryTime(yesterday);
		// 当天新增得优惠券
		return cpCouponDAO.getTotalCounBySpiderAndTime(query);
	}
	

}
