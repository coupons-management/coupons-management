package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.model.vo.response.StatisticResponse;

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
	Page<StatisticResponse> getSpiderPage(StatisticRequest statisticRequest);

}
