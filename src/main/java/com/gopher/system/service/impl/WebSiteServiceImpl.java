package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import com.gopher.system.dao.mysql.*;
import com.gopher.system.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.exception.BusinessRuntimeException;
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
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
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
			if (null != couponList) {
				couponList.forEach((e) -> {
					e.setSale(getSale(e.getTitle(), e.getCouponType()));
				});
			}
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
		if (null == storeRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int siteId = storeRequest.getSiteId();
		final int storeId = storeRequest.getStoreId();
		if (siteId <= 0) {
			throw new BusinessRuntimeException("官网ID不能为空");
		}
		if (storeId <= 0) {
			throw new BusinessRuntimeException("商家ID不能为空");
		}
		StoreDetailResponse result = new StoreDetailResponse();
		List<Integer> storeIdList = new ArrayList<>();
		storeIdList.add(storeId);
		ShowSiteCouponPageRequest showSiteCouponPageRequest = new ShowSiteCouponPageRequest();
		showSiteCouponPageRequest.setSiteId(siteId);
		showSiteCouponPageRequest.setStoreIdList(storeIdList);
		showSiteCouponPageRequest.setPageNumber(storeRequest.getPageNumber());
		showSiteCouponPageRequest.setPageSize(storeRequest.getPageSize());
		showSiteCouponPageRequest.setCouponType(storeRequest.getCouponType());
		List<CpCouponVo> list = cpOutSiteCouponDAO.getListByCategory(showSiteCouponPageRequest);
		final int totalCount = cpOutSiteCouponDAO.getCountByCategory(showSiteCouponPageRequest);
		if (null != list) {
			list.forEach((e) -> {
				e.setSale(getSale(e.getTitle(), e.getCouponType()));
			});
		}
		CpStore cpStore = cpStoreDAO.selectByPrimaryKey(storeId);
		if (null == cpStore) {
			throw new BusinessRuntimeException("根据商家ID找不到商家信息");
		}
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setOutId(siteId);
		cpOutSiteStore.setStoreId(storeId);
		cpOutSiteStore = cpOutSiteStoreDAO.getOne(cpOutSiteStore);
		if(null == cpOutSiteStore){
           throw new BusinessRuntimeException("当前站点:"+siteId+"找不到该商家:"+storeId);
		}
		result.setId(cpOutSiteStore.getId());
		result.setDescription(cpStore.getDes());
		result.setLogo(cpStore.getLogoUrl());
		result.setName(cpOutSiteStore.getShowName().replace("{{store_name}}",cpStore.getName()));
		result.setWebsite(cpStore.getWebsite());
		Page<CpCouponVo> page = new Page<>();
		page.setPageNumber(storeRequest.getPageNumber());
		page.setPageSize(storeRequest.getPageSize());
		page.setList(list);
		page.setTotalCount(totalCount);
		result.setCouponList(page);
		return result;
	}

	@Override
	public void updateCouponClickCount(CpCouponVo cpCouponVo) {
       if(null ==  cpCouponVo){
       	throw new BusinessRuntimeException("参数不能为空");
	   }
       final Integer id = cpCouponVo.getId();
       if(null == id || id <=0){
		   throw new BusinessRuntimeException("无效的ID");
	   }
       CpOutSiteCoupon coupon = cpOutSiteCouponDAO.selectByPrimaryKey(id);
       if(null == coupon){
		   throw new BusinessRuntimeException("根据ID找不到记录");
	   }
		coupon.setClickCount(coupon.getClickCount() +1);
		cpOutSiteCouponDAO.updateByPrimaryKeySelective(coupon);
	}

	@Override
	public void updateStoreVisitCount(StoreRequest storeRequest) {
		if(null ==  storeRequest){
			throw new BusinessRuntimeException("参数不能为空");
		}
		CpOutSiteStore store = cpOutSiteStoreDAO.selectByPrimaryKey(storeRequest.getId());
		if(null == store){
			throw new BusinessRuntimeException("根据ID找不到记录");
		}
		store.setVisitCount(store.getVisitCount() + 1);
		cpOutSiteStoreDAO.updateByPrimaryKeySelective(store);

	}

	/**
	 * 是否是整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		boolean flag = false;
		if (StringUtils.hasText(str)) {
			Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
			flag = pattern.matcher(str).matches();
		}
		return flag;
	}

	private static String getSale(String title, String couponType) {
		String sale = "";
		String[] temp;
		if (title.contains("%")) {
			int mark_index = title.indexOf("%");
			temp = title.substring(mark_index).split(" ");
			String temp2 = null;
			if (mark_index - 1 > 0) {
				temp2 = title.substring(mark_index - 1, mark_index);
			}
			String temp3 = null;
			if (mark_index - 2 >= 0) {
				temp3 = title.substring(mark_index - 2, mark_index - 1);
			}
			if (!isInteger(temp3) && !isInteger(temp2)) {
				if (Objects.equals(couponType, "CODE")) {
					sale = "PROMO";
				} else if (Objects.equals(couponType, "DEAL")) {
					sale = "SALE";
				}
			} else {
				sale = temp[0] + " " + temp[1];
				if (isInteger(temp2)) {
					sale = temp2 + sale;
				}
				if (isInteger(temp3)) {
					sale = temp3 + sale;
				}
			}
		} else {
			if (Objects.equals(couponType, "CODE")) {
				sale = "PROMO";
			} else if (Objects.equals(couponType, "DEAL")) {
				sale = "SALE";
			}
		}

		return sale;
	}

	public static void main(String[] args) {
		System.out.println(getSale("% Subscription Plans", "CODE"));

	}
}
