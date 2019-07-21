package com.gopher.system.service.impl;

import java.nio.file.WatchEvent;
import java.util.*;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.*;
import com.gopher.system.model.entity.*;
import com.gopher.system.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
		CpStore cpStore = cpStoreDAO.selectByPrimaryKey(storeId);
		if (null == cpStore) {
			throw new BusinessRuntimeException("根据商家ID找不到商家信息");
		}
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setOutId(siteId);
		cpOutSiteStore.setStoreId(storeId);
		cpOutSiteStore = cpOutSiteStoreDAO.getOne(cpOutSiteStore);
		System.out.println(JSON.toJSONString(cpOutSiteStore));
		if(null == cpOutSiteStore){
           throw new BusinessRuntimeException("当前站点:"+siteId+"找不到该商家:"+storeId);
		}
		result.setId(cpOutSiteStore.getId());
		result.setStoreId(cpOutSiteStore.getStoreId());
		result.setLogo(cpStore.getLogoUrl());
        final String ad_address = cpOutSiteStore.getAdAddress();
		final String name = cpStore.getName();
		final String webSite = cpStore.getWebsite();
		String store_site = "";
		if(StringUtils.hasText(webSite)){
			store_site = webSite.replace("https://","")
					            .replace("http://","");
		}
        final String month = DateUtils.getDateString(new Date(),"MMM yyyy");
		final String showName = cpOutSiteStore.getShowName();

		String first_name = "";
		String last_update_time = "";
		int coupon_count  = 0;
		if(!CollectionUtils.isEmpty(list)){
			first_name   = list.get(0).getName()!=null?list.get(0).getName():list.get(0).getTitle();
			last_update_time = DateUtils.getDateString(list.get(0).getUpdateTime());
			coupon_count = list.size();
			list.forEach(e->{
				e.setSale(getSale(e.getTitle(), e.getCouponType()));
				if(StringUtils.hasText(ad_address)){
					e.setLink(ad_address);
				}else{
					e.setLink(webSite);
				}
			});
		}

		if(StringUtils.hasText(showName)){
			result.setName(showName.replace("{{store_name}}",name));
		}
			/**
		 * {{store_name}} Coupons {{month}} : {{best_off}}OFF Promo Code, Discounts
		 */
		final String title = cpOutSiteStore.getTitle();
		if(StringUtils.hasText(title)){
			result.setTitle(title.replace("{{store_name}}", name)
					.replace("{{month}}", month)
			        .replace("{{best_off}}", first_name));
		}
		/**    {{store_name}}
		 * GET {{store_name}} {{coupon_count}} active Coupons, deals & free shipping W/ {{month}}.
		 * Hot Promo codes?{{best_coupon_name}}
		 */
		final String description = cpOutSiteStore.getDes();
		if(StringUtils.hasText(description)){
			result.setDescription(description.replace( "{{store_name}}",name)
					                          .replace("{{coupon_count}}",coupon_count+"")
			                                  .replace("{{month}}",month)
			                                  .replace("{{best_coupon_name}}",first_name));
		}
		/**
		 * {{store_name}}, {{store_site}}, {{store_name}} promos, promo code, coupons, deals
		 */
		final String keyWords =cpOutSiteStore.getKeywords();
		if(StringUtils.hasText(keyWords)){
			result.setKeyWords(keyWords.replace("{{store_name}}",name)
			                           .replace("{{store_site}}",store_site));
		}
		/**
		 * The last update time of {{store_name}} promos is {{last_update_date}},
		 * and there are {{coupon_count}}
		 * discounts in all. The best offers are {{best_coupon_name}}.
		 * All the discount codes of {{store_name}} are verified officially.
		 * COUPONPA.com is one of the important partners of {{store_name}}.
		 * Find the promo code of the best discount at COUPONPA.com and use it,
		 * so you can save more money, and let your wallet grow thicker.
		 */
		final String storeDes = cpOutSiteStore.getStoreDes();
		if(StringUtils.hasText(storeDes)){
			result.setStoreDescription(storeDes.replace("{{store_name}}",name)
			                                    .replace("{{last_update_date}}",last_update_time)
			                                     .replace("{{coupon_count}}",coupon_count+"")
			                                     .replace("{{best_coupon_name}}",first_name));
		}
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

	/**
	 * 获取官网展示折扣关键字
	 * @param title
	 * @param couponType
	 * @return
	 */
	private static String getSale(String title, String couponType) {
		String sale = "";
		String[] temp;
		if (title.contains("%")) {
			int mark_index = title.indexOf("%");
			temp = title.substring(mark_index).split(" ");
			String temp2 = null;
			if (mark_index - 1 >= 0) {
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
				sale = temp[0] + "  OFF";
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
		System.out.println(getSale("2% Subscription Plans", "CODE"));

	}
}
