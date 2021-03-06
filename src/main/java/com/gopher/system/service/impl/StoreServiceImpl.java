package com.gopher.system.service.impl;

import com.gopher.system.dao.mysql.*;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.*;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StoreAvailableRequet;
import com.gopher.system.model.vo.request.StoreDetailJspRequest;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.request.StoreVerifyRequest;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.CouponService;
import com.gopher.system.service.StoreService;
import com.gopher.system.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
	public List<String> getInShowSiteNameList(int storeId) {
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
	/**
	 * 获取商家来源爬虫站点名称
	 * 
	 * @param storeId
	 * @return
	 */
	public List<String> getSpiderSiteNameList(int storeId) {
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

    @Override
    public List<StoreResponse> getShowValue(List<CpStore> list, boolean isScrapy){
		List<StoreResponse> rspList = null;
		// 基础数据
		if (null != list) {
			rspList = new ArrayList<>(list.size());
			for (CpStore cpStore : list) {
				final int storeId =  cpStore.getStoreId()>0 ? cpStore.getStoreId():cpStore.getId();
				StoreResponse rsp = new StoreResponse();
				rsp.setId(cpStore.getId());
				rsp.setName(cpStore.getName());
				rsp.setWebsite(cpStore.getWebsite());
				rsp.setLogo(cpStore.getLogoUrl());
				// 在展示站
				rsp.setShowSiteNameList(this.getInShowSiteNameList(storeId));
				// 在爬虫站
				rsp.setSpiderSiteNameList(this.getSpiderSiteNameList(storeId));
				rsp.setValidCouponsCount(couponService.getValidCountByStore(storeId) + "/"
						+couponService.getTotalCountByStore(storeId));
				rsp.setCreateTime(DateUtils.getDatetimeString(cpStore.getCreateTime()));
				rsp.setUpdateTime(DateUtils.getDatetimeString(cpStore.getUpdateTime()));
				rsp.setApproval(cpStore.getApproval());
				rsp.setCountry(cpStore.getCountry());
				rsp.setScrapyType(cpStore.getTypeName());
				rsp.setStoreId(storeId);
				CpCoupon coupon = couponService.getNewOne(storeId, isScrapy);
				if(null != coupon) {
					rsp.setCouponUpdateTime(DateUtils.getDatetimeString(coupon.getCreateTime()));
				}
				// 优惠券最后新增时间
				rspList.add(rsp);
			}
		}
		return rspList;
	}

	@Override
	public Page<StoreResponse> getPage(StorePageRequst storePageRequest) {
		if(null == storePageRequest){
			throw new BusinessRuntimeException("参数不能为空");
		}
		Page<StoreResponse> result = new Page<>();
		result.setPageNumber(storePageRequest.getPageNumber());
		result.setPageSize(storePageRequest.getPageSize());
		// 排除商家的列表
		storePageRequest.setExcludeStoreIdList(this.getExcludeSiteIdList(storePageRequest.getSiteId()));
		List<CpStore> list = cpStoreDAO.getPageList(storePageRequest);
		final int totalCount = cpStoreDAO.getCount(storePageRequest);
		result.setTotalCount(totalCount);
		result.setList(this.getShowValue(list, true));
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


	@Override
	public Page<CpStore> availableAssignStore(StoreAvailableRequet storeAvailableRequet) {
		if (null == storeAvailableRequet) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		Page<CpStore> result = new Page<>();
		result.setPageNumber(storeAvailableRequet.getPageNumber());
		result.setPageSize(storeAvailableRequet.getPageSize());
		List<CpStore> list = cpStoreDAO.availableAssignStore(storeAvailableRequet);
		final int totalCount = cpStoreDAO.availableAssignStoreCount(storeAvailableRequet);
		result.setTotalCount(totalCount);
		result.setList(list);
		return result;
	}

	@Override
	public CpStore findByWebsite(StoreDetailJspRequest request) {
		return cpStoreDAO.findByWebsite(request);
	}
}
