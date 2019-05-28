package com.gopher.system.worker;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpInSiteDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.SpiderStatisticDAO;
import com.gopher.system.model.entity.CpInSite;
import com.gopher.system.model.entity.SpiderStatistic;
import com.gopher.system.util.DateUtils;
import com.gopher.system.worker.vo.SpiderStatisticVO;

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
	@Autowired
	private CpInSiteDAO cpInSiteDAO;
	@Autowired
	private SpiderStatisticDAO spiderStatisticDAO;
	
	/**
	    * 根据爬虫统计 新增的优惠券 有效的优惠券 优惠券总数
	 */
	public void statisticBySpider() {
		// 这个定时任务 会在凌晨1点或2点启动 所以计算时间以前天END->昨天END
		// 1获取当天爬虫爬取的所有优惠券,所有的新增商家数量,更新的商家数量
		// 2获取当天爬虫爬取的所有商家 根据商家ID统计 对应的爬取优惠券数量 
		List<CpInSite> list = cpInSiteDAO.getAll();
		if(null != list) {
			for (CpInSite cpInSite : list) {
				final int spiderId  = cpInSite.getId();
				SpiderStatisticVO query = new SpiderStatisticVO();
				final Date yesterday = DateUtils.getOneDayEndDate(-1);
				final Date beforeYesterday = DateUtils.getOneDayEndDate(-2);
				query.setBeginTime(beforeYesterday);
				query.setEndTime(yesterday);
				query.setSpiderId(spiderId);
				// 这一天这个爬虫站 获取的所有优惠券
				final int count = cpCouponDAO.getCountBySpiderAndTime(query);
				SpiderStatistic spiderStatistic = new SpiderStatistic();
				spiderStatistic.setCreateTime(yesterday);
				spiderStatistic.setUpdateTime(yesterday);
				spiderStatistic.setSpiderId(spiderId);
				// 新增的优惠券数量
				spiderStatistic.setIncrementCoupon(count);
				// TODO 筛选那些优惠券是有效的 再查一次(使用COUNT 不要查询整个数据 太多有OOM风险)
				spiderStatistic.setValidCoupon(0);
				//TODO 优惠券总量 叠加上一条统计数据
				spiderStatistic.setTotalCoupon(0);
				//TODO 查询昨天一天的时间段内 新增的商家 或者被修改的商家 createTime updateTime
				spiderStatistic.setIncrementStore(0);
				// TODO 查询商家
				spiderStatistic.setTotalStore(0);
				//这一天的统计条目 一个爬虫 一天 一条记录 
				spiderStatisticDAO.insert(spiderStatistic);
			}
		}
	}

	
	
	/**
	 * 根据站点统计 优惠券 商家
	 */
	public void statisticBySite() {
        // TODO 
	}

}
