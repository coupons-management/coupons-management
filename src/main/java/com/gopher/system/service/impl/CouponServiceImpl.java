package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.vo.KV;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.response.CouponResponse;
import com.gopher.system.service.CouponService;
@Service
public class CouponServiceImpl implements CouponService{
	@Autowired
    private CpCouponDAO cpCouponDAO;
	@Override
	public Page<CouponResponse> getPage(CouponPageRequest couponPageRequest) {
		Page<CouponResponse> result = new Page<CouponResponse>();
		List<CpCoupon> couponList   = cpCouponDAO.getPageList(couponPageRequest);
		final int totalCount        = cpCouponDAO.getCount(couponPageRequest);
		List<CouponResponse> list   = null;
		if(null != couponList) {
			list = new ArrayList<>(couponList.size());
			for (CpCoupon cpCoupon : couponList) {
				CouponResponse rsp = new CouponResponse();
				BeanUtils.copyProperties(cpCoupon, rsp);
				list.add(rsp);
			}
		}
		result.setTotalCount(totalCount);
		result.setList(list);
		return result;
	}


}
