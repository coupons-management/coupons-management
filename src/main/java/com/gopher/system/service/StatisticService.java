package com.gopher.system.service;

import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.model.vo.response.StatisticResponse;

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
	List<StatisticResponse> getStatistic(StatisticRequest statisticRequest);

}
