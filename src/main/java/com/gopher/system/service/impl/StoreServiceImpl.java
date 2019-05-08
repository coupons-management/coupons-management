package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.StoreService;
import com.gopher.system.util.DateUtils;
@Service
public class StoreServiceImpl implements StoreService{

	@Override
	public Page<StoreResponse> getPage(StoreRequest storeRequest) {
		Page<StoreResponse> reuslt = new Page<StoreResponse>();
		List<StoreResponse> list = new ArrayList<>();
		reuslt.setTotalCount(10);
		for(int i=0;i<10;i++) {
			StoreResponse re = new StoreResponse();
			re.setCouponUpdateTime(DateUtils.getDateString(new Date()));
			re.setName("TEST"+i);
			re.setId(i);
			re.setCreateTime(DateUtils.getDateString(new Date()));
			re.setLogo("http://www.xx.com");
			re.setScrapySiteCount(100);
			re.setScrapyType("123");
			re.setSiteUsedCount(100);
			re.setValidCouponsCount("109/200");
			list.add(re);
		}
		reuslt.setList(list);
		return reuslt;
	}

}
