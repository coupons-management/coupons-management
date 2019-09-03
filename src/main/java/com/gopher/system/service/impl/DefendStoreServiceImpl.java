package com.gopher.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.DefendStoreDAO;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.DefendStorePageRequest;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.CouponService;
import com.gopher.system.service.DefendStoreService;
import com.gopher.system.service.StoreService;
import com.gopher.system.util.DateUtils;
@Service
public class DefendStoreServiceImpl implements DefendStoreService{
	@Autowired
    private DefendStoreDAO defendStoreDAO;
	@Autowired
	private StoreService storeService;
	@Autowired
	private CouponService couponService;
	@Override
	public Page<StoreResponse> getStorePage(DefendStorePageRequest defendStorePageRequst) {
		Page<StoreResponse> result = new Page<StoreResponse>();
		result.setPageSize(defendStorePageRequst.getPageSize());
		result.setPageNumber(defendStorePageRequst.getPageNumber());
		List<StoreResponse> list = defendStoreDAO.getStorePageList(defendStorePageRequst);
		final int totalCount = defendStoreDAO.getStoreCount(defendStorePageRequst);
		if(null != list) {
			for (StoreResponse storeResponse : list) {
				final int storeId = storeResponse.getId();
				storeResponse.setShowSiteNameList(storeService.getInShowSiteNameList(storeId));
				storeResponse.setSpiderSiteNameList(storeService.getSpiderSiteNameList(storeId));
				//TODO 爬虫爬回来的不准 已实际入库的为准 有效优惠券数量
				storeResponse.setValidCouponsCount(couponService.getValidCountByStore(storeId) + "/"
						+couponService.getTotalCountByStore(storeId));
				CpCoupon coupon = couponService.getNewOne(storeId, false);
				if(null != coupon) {
					storeResponse.setCouponUpdateTime(DateUtils.getDatetimeString(coupon.getCreateTime()));
				}
			}
		}
		result.setList(list);
		result.setTotalCount(totalCount);
		return result;
	}
}
