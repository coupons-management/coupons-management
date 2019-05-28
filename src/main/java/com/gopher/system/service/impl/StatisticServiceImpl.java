package com.gopher.system.service.impl;

import org.springframework.stereotype.Service;

import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.model.vo.response.StatisticResponse;
import com.gopher.system.service.StatisticService;
@Service
public class StatisticServiceImpl implements StatisticService{

	@Override
	public Page<StatisticResponse> getSpiderPage(StatisticRequest statisticRequest) {
		if(null == statisticRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final long beginTime = statisticRequest.getBeginTime();
		final long endTime   = statisticRequest.getEndTime();
		if(beginTime <=0 ) {
			throw new BusinessRuntimeException("开始时间不能为空");
		}
		if(endTime <=0 ) {
			throw new BusinessRuntimeException("结束时间不能为空");
		}
		
		return null;
	}

}
