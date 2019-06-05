package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.dao.mysql.CpSitestoreTypeDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpTypeStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.CpTypeStore;
import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CategoryRequest;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.model.vo.response.StoreDetailResponse;
import com.gopher.system.service.WebSiteService;
@Service
public class WebSiteServiceImpl implements WebSiteService {
	@Autowired
	private CpSitestoreTypeDAO cpSiteStoreTypeDAO;
	@Autowired
	private CpTypeStoreDAO cpTypeStoreDAO;
	@Autowired
	private CpOutSiteCouponDAO cpOutSiteCouponDAO;
	@Autowired
	private CpStoreDAO cpStoreDAO;
	@Override
	public Page<CpCouponVo> getCouponListByCategory(CategoryRequest categoryRequest) {
		 Page<CpCouponVo> result = new Page<>();
		List<CpCouponVo> couponList = new ArrayList<>();
		
		if (null == categoryRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int pageSize = categoryRequest.getPageSize();
		final int pageNumber = categoryRequest.getPageNumber();
		final int id = categoryRequest.getId();
		final int siteId = categoryRequest.getSiteId();
		if (id <= 0) {
			throw new BusinessRuntimeException("分类ID不能为空");
		}
		if (siteId <= 0) {
			throw new BusinessRuntimeException("官网站点ID不能为空");
		}
		List<CpSitestoreType> sonList = cpSiteStoreTypeDAO.getSonList(id);
		List<Integer> storeIdList = new ArrayList<>();
		if (null != sonList && !sonList.isEmpty()) {
			// 如果当前分类下有绑定子级
			// 拿到这个之级下面所有对应的商家
			for (CpSitestoreType cpSitestoreType : sonList) {
				List<CpTypeStore> list = cpTypeStoreDAO.getListByType(cpSitestoreType.getId());
				for (CpTypeStore cpTypeStore : list) {
					storeIdList.add(cpTypeStore.getStoreId());
				}
			}
		}
		// 1级直接关联商家
		CpSitestoreType type = cpSiteStoreTypeDAO.selectByPrimaryKey(id);
		if (null != type) {
			List<CpTypeStore> list = cpTypeStoreDAO.getListByType(type.getId());
			if (null != list) {
				for (CpTypeStore cpTypeStore : list) {
					storeIdList.add(cpTypeStore.getStoreId());
				}
			}
		}
		int totalCount = 0;
		if (!storeIdList.isEmpty()) {
			ShowSiteCouponPageRequest showSiteCouponPageRequest = new ShowSiteCouponPageRequest();
			showSiteCouponPageRequest.setSiteId(siteId);
			showSiteCouponPageRequest.setStoreIdList(storeIdList);
			showSiteCouponPageRequest.setPageNumber(pageNumber);
			showSiteCouponPageRequest.setPageSize(pageSize);
			showSiteCouponPageRequest.setCouponType(categoryRequest.getCouponType());
			couponList = cpOutSiteCouponDAO.getListByCategory(showSiteCouponPageRequest);
			totalCount = cpOutSiteCouponDAO.getCountByCategory(showSiteCouponPageRequest);
		}
		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		result.setTotalCount(totalCount);
		result.setList(couponList);
		return result;
	}
	@Override
	public StoreDetailResponse getStoreDetail(StoreRequest storeRequest) {
		if(null == storeRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int siteId  = storeRequest.getSiteId();
		final int storeId = storeRequest.getStoreId();
		if( siteId <=0 ) {
			throw new BusinessRuntimeException("官网ID不能为空");
		}
		if( storeId <=0 ) {
			throw new BusinessRuntimeException("商家ID不能为空");
		}
		StoreDetailResponse result = new StoreDetailResponse();
		List<Integer> storeIdList = new ArrayList<Integer>();
		storeIdList.add(storeId);
		ShowSiteCouponPageRequest showSiteCouponPageRequest = new ShowSiteCouponPageRequest();
		showSiteCouponPageRequest.setSiteId(siteId);
		showSiteCouponPageRequest.setStoreIdList(storeIdList);
		showSiteCouponPageRequest.setPageNumber(storeRequest.getPageNumber());
		showSiteCouponPageRequest.setPageSize(storeRequest.getPageSize());
		showSiteCouponPageRequest.setCouponType(storeRequest.getCouponType());
		List<CpCouponVo> list = cpOutSiteCouponDAO.getListByCategory(showSiteCouponPageRequest);
		final int totalCount = cpOutSiteCouponDAO.getCountByCategory(showSiteCouponPageRequest);
		CpStore cpStore = cpStoreDAO.selectByPrimaryKey(storeId);
		if(null == cpStore) {
			throw new BusinessRuntimeException("根据商家ID找不到商家信息");
		}
		result.setDescription(cpStore.getDes());
		result.setLogo(cpStore.getLogoUrl());
		result.setName(cpStore.getName());
		result.setWebsite(cpStore.getWebsite());
		Page<CpCouponVo> page = new Page<>();
		page.setPageNumber(storeRequest.getPageNumber());
		page.setPageSize(storeRequest.getPageSize());
		page.setList(list);
		page.setTotalCount(totalCount);
		result.setCouponList(page);
		return result;
	}
}
