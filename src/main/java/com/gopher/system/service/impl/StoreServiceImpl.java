package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpScrapyStoreDAO;
import com.gopher.system.dao.mysql.CpSiteStoreDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {
	@Resource
	private CpStoreDAO cpStoreDAO;
	@Resource
	private CpSiteStoreDAO cpSiteStoreDAO;
	@Resource
	private CpScrapyStoreDAO cpScrapyStoreDAO;
	@Resource
	private CpCouponDAO cpCouponDAO;

	@Override
	public Page<StoreResponse> getPage(StorePageRequst storePageRequest) {
		List<CpStore> list = cpStoreDAO.getPage(storePageRequest);
		final int totalCount = cpStoreDAO.getCount(storePageRequest);
		Page<StoreResponse> reuslt = new Page<StoreResponse>();
		reuslt.setPageNumber(storePageRequest.getPageNumber());
		reuslt.setPageSize(storePageRequest.getPageSize());
		reuslt.setTotalCount(totalCount);
		List<StoreResponse> rspList = null;
		// 基础数据
		if (null != list) {
			rspList = new ArrayList<>(list.size());
			for (CpStore cpStore : list) {
				StoreResponse rsp = new StoreResponse();
				BeanUtils.copyProperties(cpStore, rsp);
				rspList.add(rsp);
			}
		}
		reuslt.setList(rspList);
		return reuslt;
	}

	@Override
	public void edit(CpStore cpStore) {
		if (null == cpStore) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final Integer id = cpStore.getId();
		if (null == id || id <= 0) {
			throw new BusinessRuntimeException("ID不能为空");
		}
		final String name = cpStore.getName();
		final String country = cpStore.getCountry();
		final String logoUrl = cpStore.getLogoUrl();
		cpStoreDAO.updateByPrimaryKeySelective(cpStore);
	}

}
