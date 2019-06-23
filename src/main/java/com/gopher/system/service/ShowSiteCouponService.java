package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.request.ShowSiteCouponRequest;
import com.gopher.system.model.vo.response.ShowSiteCouponResponse;

import java.util.List;

public interface ShowSiteCouponService {
	
	Page<ShowSiteCouponResponse> getCouponPage(ShowSiteCouponPageRequest showSiteCouponPageRequest);
	
	void edit(ShowSiteCouponRequest showSiteCouponRequest);
	
	void delete(ShowSiteCouponRequest showSiteCouponRequest);

	List<ShowSiteCouponResponse> getCouponListWithSort(ShowSiteCouponPageRequest showSiteCouponPageRequest);

}
