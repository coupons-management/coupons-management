package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.response.CouponResponse;
import com.gopher.system.service.CouponService;
import com.gopher.system.util.DateUtils;
@Service
public class CouponServiceImpl implements CouponService{
	@Autowired
    private CpCouponDAO cpCouponDAO;
	@Autowired
	private CpStoreDAO cpStoreDAO;
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
				rsp.setId(cpCoupon.getId());
				CpStore storeDB = cpStoreDAO.selectByPrimaryKey(cpCoupon.getStoreId());
				if(null != storeDB) {
					rsp.setStoreName(storeDB.getName());
				}
				rsp.setTitle("TODO");
				rsp.setType(cpCoupon.getCouponType());
				rsp.setDescription("TODO");
				rsp.setExpired(true);
				rsp.setExpiryTime(DateUtils.getDateString(cpCoupon.getExpireAt()));
				rsp.setCreateTime(DateUtils.getDateString(cpCoupon.getCreateTime()));
				list.add(rsp);
			}
		}
		result.setTotalCount(totalCount);
		result.setList(list);
		return result;
	}
	
	
	public int getTotalCountByStore(final int storeId) {
		CouponPageRequest couponPageRequest = new CouponPageRequest();
		couponPageRequest.setStoreId(storeId);
		return cpCouponDAO.getCount(couponPageRequest);
	}
	
	public int getValidCountByStore(final int storeId) {
		CouponPageRequest couponPageRequest = new CouponPageRequest();
		couponPageRequest.setStoreId(storeId);
		couponPageRequest.setExpiryTime(new Date());
		return cpCouponDAO.getCount(couponPageRequest);
	}


}
