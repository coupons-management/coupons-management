package com.gopher.system.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.service.CpOutSiteCouponService;
@Service
public class CpOutSiteCouponServiceImpl implements CpOutSiteCouponService {
	@Autowired
    private CpOutSiteCouponDAO cpOutSiteCouponDAO;
	@Override
	public void updateHotSort(CpOutSiteCoupon cpOutSiteCoupon) {
		cpOutSiteCoupon.setUpdateTime(new Date());
		cpOutSiteCouponDAO.updateHotSort(cpOutSiteCoupon);
		
	}

	@Override
	public void updateAdviseSort(CpOutSiteCoupon cpOutSiteCoupon) {
		cpOutSiteCoupon.setUpdateTime(new Date());
		cpOutSiteCouponDAO.updateAdviseSort(cpOutSiteCoupon);		
	}

	@Override
	public void deleteHotSort(CpOutSiteCoupon cpOutSiteCoupon) {
		cpOutSiteCoupon.setUpdateTime(new Date());
		cpOutSiteCoupon.setHotSort(0);
		cpOutSiteCouponDAO.updateHotSort(cpOutSiteCoupon);
		
	}

	@Override
	public void deleteAdviseSort(CpOutSiteCoupon cpOutSiteCoupon) {
		cpOutSiteCoupon.setUpdateTime(new Date());
		cpOutSiteCoupon.setAdviseSort(0);
		cpOutSiteCouponDAO.updateAdviseSort(cpOutSiteCoupon);
		
	}
	

}
