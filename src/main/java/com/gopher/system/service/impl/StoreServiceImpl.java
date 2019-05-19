package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.dao.mysql.CpInSiteDAO;
import com.gopher.system.dao.mysql.CpOutSiteDAO;
import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.dao.mysql.CpScrapyStoreDAO;
import com.gopher.system.dao.mysql.CpSiteStoreDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpInSite;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpScrapyStore;
import com.gopher.system.model.entity.CpSiteStore;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.CouponService;
import com.gopher.system.service.StoreService;
import com.gopher.system.util.DateUtils;

@Service
public class StoreServiceImpl implements StoreService {
	@Resource
	private CpStoreDAO cpStoreDAO;
	@Resource
	private CpSiteStoreDAO cpSiteStoreDAO;
	@Resource
	private CpScrapyStoreDAO cpScrapyStoreDAO;
	@Resource
	private CouponService couponService;
	@Resource
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	@Resource
	private CpOutSiteDAO cpOutSiteDAO;
	@Resource
	private CpInSiteDAO cpInSiteDAO;
    
	private List<String> getInShowSiteNameList(int storeId){
		List<String> result = new ArrayList<>();
        // 在展示站
        CpOutSiteStore query = new CpOutSiteStore();
        query.setStoreId(storeId);
        List<CpOutSiteStore> showSiteList = cpOutSiteStoreDAO.getList(query);
        if(showSiteList != null && !showSiteList.isEmpty()) {
        	for (CpOutSiteStore cpOutSiteStore : showSiteList) {
        		CpOutSite cpOutSite   = cpOutSiteDAO.selectByPrimaryKey(cpOutSiteStore.getOutId());
        		if(null != cpOutSite) {
        			final String name = cpOutSite.getName();
        			if(StringUtils.hasText(name)) {
        				result.add(name);
        			}
        		}
        		
			}
    
        }
        return result;
	}
	
	private List<String> getSpiderSiteNameList(int storeId){
		List<String> result = new ArrayList<>();
		CpSiteStore query = new CpSiteStore();
		query.setStoreId(storeId);
		List<CpSiteStore> list = cpSiteStoreDAO.getList(query);
		if(null != list && !list.isEmpty()) {
			for (CpSiteStore cpSiteStore : list) {
				CpInSite insite = cpInSiteDAO.selectByPrimaryKey(cpSiteStore.getInSiteId());
				if(null != insite) {
					String name = insite.getName();
					if(StringUtils.hasText(name)) {
						result.add(name);
					}
				}
			}
		}
		return result;
	}
	@Override
	public Page<StoreResponse> getPage(StorePageRequst storePageRequest) {
		Page<StoreResponse> reuslt = new Page<StoreResponse>();
		//爬虫站
		final Integer spider_id = storePageRequest.getScrapyId();
		if(null != spider_id && spider_id > 0) {
			List<CpScrapyStore> list = cpScrapyStoreDAO.getListByScrapy(spider_id);
			if(null!=list && !list.isEmpty()) {
				List<Integer> storeIdList = new ArrayList<>(list.size());
				for (CpScrapyStore cpScrapyStore : list) {
					storeIdList.add(cpScrapyStore.getStoreId());
				}
				storePageRequest.setStoreIdList(storeIdList);
			}
		}
		//TODO 1.优惠券数量筛选 
		//     2.爬虫分类筛选
		List<CpStore> list   = cpStoreDAO.getPageList(storePageRequest);
		final int totalCount = cpStoreDAO.getCount(storePageRequest);
		reuslt.setPageNumber(storePageRequest.getPageNumber());
		reuslt.setPageSize(storePageRequest.getPageSize());
		reuslt.setTotalCount(totalCount);
		List<StoreResponse> rspList = null;
		// 基础数据
		if (null != list) {
			rspList = new ArrayList<>(list.size());
			for (CpStore cpStore : list) {
				final int storeId = cpStore.getId();
				StoreResponse rsp = new StoreResponse();
				rsp.setId(cpStore.getId());
				rsp.setName(cpStore.getName());
				rsp.setWebsite(cpStore.getWebsite());
                rsp.setLogo(cpStore.getLogoUrl());
                // 在展示站
                rsp.setShowSiteNameList(this.getInShowSiteNameList(storeId));
                // 在爬虫站
                rsp.setSpiderSiteNameList(this.getSpiderSiteNameList(storeId));
                // 有效优惠券数量
                rsp.setValidCouponsCount(couponService.getValidCountByStore(storeId)+"/"+couponService.getTotalCountByStore(storeId));
				rsp.setCreateTime(DateUtils.getDatetimeString(cpStore.getCreateTime()));
				rsp.setUpdateTime(DateUtils.getDatetimeString(cpStore.getUpdateTime()));
				rsp.setApproval(cpStore.getApproval());
				rsp.setCountry(cpStore.getCountry());
				// 优惠券最后新增时间
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
		cpStoreDAO.updateByPrimaryKeySelective(cpStore);
	}


	

}
