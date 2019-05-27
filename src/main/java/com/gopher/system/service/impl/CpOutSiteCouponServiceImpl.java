package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.CpOutSiteCouponVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
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

	@Override
	public Page<CpOutSiteCouponVo> getHotList(CouponPageRequest obj) {

		Page<CpOutSiteCouponVo> result=new Page<CpOutSiteCouponVo>();
		List<CpOutSiteCouponVo> list=cpOutSiteCouponDAO.getHotList(obj);
		int  total=cpOutSiteCouponDAO.getHotCount(obj);
		result.setList(list);
		result.setTotalCount(total);
		return result;
	
	}
	
	@Override
	public Page<CpOutSiteCouponVo> getAdviseList(CouponPageRequest obj) {
		Page<CpOutSiteCouponVo> result=new Page<CpOutSiteCouponVo>();
		List<CpOutSiteCouponVo> list=cpOutSiteCouponDAO.getAdviseList(obj);
		int  total=cpOutSiteCouponDAO.getAdviseCount(obj);
		result.setList(list);
		result.setTotalCount(total);
		return result;
	}

	@Override
	public List<CpOutSiteCouponVo> getTopHotList(CpOutSiteCoupon obj) {
		// TODO Auto-generated method stub
		return cpOutSiteCouponDAO.getTopHotList(obj);
	}

	@Override
	public List<CpOutSiteCouponVo> getTopAdviseList(CpOutSiteCoupon obj) {
		// TODO Auto-generated method stub
		return cpOutSiteCouponDAO.getTopAdviseList(obj);
	}
	

}
