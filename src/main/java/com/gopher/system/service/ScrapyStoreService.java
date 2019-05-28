package com.gopher.system.service;

import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.StoreAllPageRequst;

public interface ScrapyStoreService {
	Page<StoreAllPageRequst> getScrapyPageList(StoreAllPageRequst storeAllPageRequst);
	Page<StoreAllPageRequst> getErrScrapyPageList(StoreAllPageRequst storeAllPageRequst);
	Page<CpCoupon> getScrapyCouponPageList(CouponPageRequest couponPageRequest);
	Page<CpCoupon> getErrScrapyCouponPageList(CouponPageRequest couponPageRequest);
	

}
