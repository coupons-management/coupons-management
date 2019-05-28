package com.gopher.system.worker;

import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;

/**
 * 定时统计每一天每一个爬虫的数据爬取情况
 * 
 * @author dongyangyang
 *
 */
public class SpiderStatisticJob {
	@Autowired
	private CpCouponDAO cpCouponDAO;
	@Autowired
	private CpStoreDAO cpStoreDAO;
	
	
	/**
	    * 根据爬虫统计 新增的优惠券 有效的优惠券 优惠券总数
	 */
	public void statisticBySpider() {
		// 1获取当天爬虫爬取的所有优惠券,所有的新增商家数量,更新的商家数量
		// 2获取当天爬虫爬取的所有商家 根据商家ID统计 对应的爬取优惠券数量 
       // TODO 
	}

	/**
	 * 根据站点统计 优惠券 商家
	 */
	public void statisticBySite() {
        // TODO 
	}

}
