package com.gopher.system.service;

import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.model.vo.response.SiteStatisticRsp;
import com.gopher.system.model.vo.response.StatisticResponse;
import com.gopher.system.model.vo.response.StoreStatisticRsp;

import java.util.List;

/**
 * 统计接口
 * 
 * @author dongyangyang
 *
 */
public interface StatisticService {
	/**
	 * 获取爬虫统计
	 * 
	 * @param statisticRequest
	 * @return
	 */
	@Deprecated
	List<StatisticResponse> getStatistic(StatisticRequest statisticRequest);

	/**
	 * 爬虫统计
	 * @param statisticRequest
	 * @return
	 */
	List<StatisticResponse>  getStatisticBySpider(StatisticRequest statisticRequest);

	/**
	 * 官网站点统计
	 * @param statisticRequest
	 * @return
	 */
	List<StatisticResponse>  getStatisticBySite(StatisticRequest statisticRequest);

	/**
	 *  商家统计
	 * @param statisticRequest
	 * @return
	 */
	List<StoreStatisticRsp> getStoreStatistic(StatisticRequest statisticRequest);

	/**
	 * 站点统计
	 * @param statisticRequest
	 * @return
	 */
	SiteStatisticRsp getSiteStatistic(StatisticRequest statisticRequest);


}
