package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.response.CouponResponse;

public interface CouponService {
	
	Page<CouponResponse> getPage(CouponPageRequest couponPageRequest);
	

}
