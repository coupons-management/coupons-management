package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpScrapyStoreDAO;
import com.gopher.system.dao.mysql.CpSiteStoreDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.StoreService;
import com.gopher.system.util.DateUtils;
@Service
public class StoreServiceImpl implements StoreService{
	@Resource
	private CpStoreDAO cpStoreDAO;
	@Resource
	private CpSiteStoreDAO cpSiteStoreDAO;
	@Resource
    private CpScrapyStoreDAO cpScrapyStoreDAO;
	@Resource
	private CpCouponDAO cpCouponDAO;
	

	@Override
	public Page<StoreResponse> getPage(StorePageRequst storeRequest) {
		Page<CpStore> page= cpStoreDAO.getPage(storeRequest);
		if(null != page) {
			// 基础数据
		}
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
