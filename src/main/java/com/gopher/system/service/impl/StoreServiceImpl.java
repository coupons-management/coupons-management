package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.dao.mysql.CpOutSiteDAO;
import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpScrapyStoreDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpScrapyStore;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.request.StoreVerifyRequest;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.CouponService;
import com.gopher.system.service.StoreService;
import com.gopher.system.util.DateUtils;
/**
 * 
 * @author dongyangyang
 *
 */
@Service
public class StoreServiceImpl implements StoreService {
	@Resource
	private CpStoreDAO cpStoreDAO;
	@Resource
	private CpScrapyStoreDAO cpScrapyStoreDAO;
	@Resource
	private CouponService couponService;
	@Resource
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	@Resource
	private CpOutSiteDAO cpOutSiteDAO;
	@Resource
	private CpScrapyDAO cpScrapyDAO;

	/**
	 * 获取商家在展示站点名称
	 * 
	 * @param storeId
	 * @return
	 */
	private List<String> getInShowSiteNameList(int storeId) {
		List<String> result = new ArrayList<>();
		// 在展示站
		CpOutSiteStore query = new CpOutSiteStore();
		query.setStoreId(storeId);
		List<CpOutSiteStore> showSiteList = cpOutSiteStoreDAO.getList(query);
		if (showSiteList != null && !showSiteList.isEmpty()) {
			for (CpOutSiteStore cpOutSiteStore : showSiteList) {
				CpOutSite cpOutSite = cpOutSiteDAO.selectByPrimaryKey(cpOutSiteStore.getOutId());
				if (null != cpOutSite) {
					final String name = cpOutSite.getName();
					if (StringUtils.hasText(name)) {
						result.add(name);
					}
				}

			}

		}
		return result;
	}
	
    private List<Integer> getExcludeSiteIdList(Integer siteId){
    	List<Integer> result = null;
    	if(siteId == null) {
    		return result;
    	}
    	CpOutSiteStore query = new CpOutSiteStore();
    	query.setOutId(siteId);
    	List<CpOutSiteStore> list = cpOutSiteStoreDAO.getList(query);
    	if(null != list && !list.isEmpty()) {
    		result  = new ArrayList<>(list.size());
    		for (CpOutSiteStore cpOutSiteStore : list) {
    			result.add(cpOutSiteStore.getStoreId());
			}
    	}
    	return result;
    }
	/**
	 * 获取商家来源爬虫站点名称
	 * 
	 * @param storeId
	 * @return
	 */
	private List<String> getSpiderSiteNameList(int storeId) {
		List<String> result = new ArrayList<>();
		CpScrapyStore query = new CpScrapyStore();
		query.setStoreId(storeId);
		List<CpScrapyStore> list = cpScrapyStoreDAO.getList(query);
		if (null != list && !list.isEmpty()) {
			for (CpScrapyStore cpScrapyStore : list) {
				CpScrapy spider = cpScrapyDAO.selectByPrimaryKey(cpScrapyStore.getScrapyId());
				if (null != spider) {
					String name = spider.getName();
					if (StringUtils.hasText(name)) {
						result.add(name);
					}
				}
			}
		}
		return result;
	}

	@Override
	public Page<StoreResponse> getPage(StorePageRequst storePageRequest) {
		Page<StoreResponse> result = new Page<StoreResponse>();
		result.setPageNumber(storePageRequest.getPageNumber());
		result.setPageSize(storePageRequest.getPageSize());
		// 爬虫站
		final Integer spider_id = storePageRequest.getScrapyId();
		if (null != spider_id && spider_id > 0) {
			CpScrapyStore query = new CpScrapyStore();
			query.setScrapyId(spider_id);
			List<CpScrapyStore> list = cpScrapyStoreDAO.getList(query);
			if (null != list && !list.isEmpty()) {
				List<Integer> storeIdList = new ArrayList<>(list.size());
				for (CpScrapyStore cpScrapyStore : list) {
					storeIdList.add(cpScrapyStore.getStoreId());
				}
				storePageRequest.setStoreIdList(storeIdList);
			}else {
				return result;
			}
		}
		// 排除商家的列表
		storePageRequest.setExcludeStoreIdList(this.getExcludeSiteIdList(storePageRequest.getSiteId()));
		List<CpStore> list = cpStoreDAO.getPageList(storePageRequest);
		final int totalCount = cpStoreDAO.getCount(storePageRequest);
		result.setTotalCount(totalCount);
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
				//TODO 爬虫爬回来的不准 已实际入库的为准 有效优惠券数量
				rsp.setValidCouponsCount(couponService.getValidCountByStore(storeId) + "/"
						+couponService.getTotalCountByStore(storeId));
				rsp.setCreateTime(DateUtils.getDatetimeString(cpStore.getCreateTime()));
				rsp.setUpdateTime(DateUtils.getDatetimeString(cpStore.getUpdateTime()));
				rsp.setApproval(cpStore.getApproval());
				rsp.setCountry(cpStore.getCountry());
				rsp.setScrapyType(cpStore.getTypeName());
				rsp.setCouponUpdateTime(DateUtils.getDatetimeString(couponService.getNewOne(storeId).getCreateTime()));
				// 优惠券最后新增时间
				rspList.add(rsp);
			}
		}
		result.setList(rspList);
		return result;
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
		final String approval = cpStore.getApproval();
		if(StringUtils.hasText(approval) && Objects.equals("2", approval)) {
			//TODO 如果是审核 且当前商家未审核通过 同步当前商家下面的所有优惠券审核状态
			
		}
		cpStoreDAO.updateByPrimaryKeySelective(cpStore);
	}

	@Override
	public void verifyBatch(StoreVerifyRequest storeVerifyRequest) {
        if(null == storeVerifyRequest ) {
        	throw new BusinessRuntimeException("参数不能为空");
        }	
        final List<Integer> validList   = storeVerifyRequest.getValidList();
        final List<Integer> invalidList = storeVerifyRequest.getInvalidList();
        
        if(null != validList) {
        	for (Integer id : validList) {
        		CpStore cpStore = new CpStore();
        		cpStore.setId(id);
        		cpStore.setApproval("1");
        		cpStoreDAO.updateByPrimaryKeySelective(cpStore);
			}
        }
        
        if(null != invalidList) {
        	for (Integer id : invalidList) {
        		CpStore cpStore = new CpStore();
        		cpStore.setId(id);
        		cpStore.setApproval("2");
        		cpStoreDAO.updateByPrimaryKeySelective(cpStore);
			}
        }
	}

}
