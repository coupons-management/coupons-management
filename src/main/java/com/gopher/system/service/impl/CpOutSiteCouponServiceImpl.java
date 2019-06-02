package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.vo.CpOutSiteCouponVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.CouponSortRequest;
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
		return cpOutSiteCouponDAO.getTopHotList(obj);
	}

	@Override
	public List<CpOutSiteCouponVo> getTopAdviseList(CpOutSiteCoupon obj) {
		return cpOutSiteCouponDAO.getTopAdviseList(obj);
	}
    
	@Override
	public void updateHotSort(CouponSortRequest couponSortRequest) {
		// 1 清除当前内战 优惠券历史排序
		// 2 更新最新排序
		if(null == couponSortRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int outId = couponSortRequest.getOutId();
		if(outId <= 0) {
			throw new BusinessRuntimeException("展示站点ID不能为空");
		}
		cpOutSiteCouponDAO.clearHotSort(outId);
		List<CpOutSiteCoupon> sortList = couponSortRequest.getCpOutSiteCouponList();
		if(null != sortList) {
			for (CpOutSiteCoupon cpOutSiteCoupon: sortList) {
				this.updateHotSort(cpOutSiteCoupon);
			}
		}

		
	}

	@Override
	public void updateAdviseSort(CouponSortRequest couponSortRequest) {
		// 1 清除当前内战 优惠券历史排序
		// 2 更新最新排序
		if(null == couponSortRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int outId = couponSortRequest.getOutId();
		if(outId <= 0) {
			throw new BusinessRuntimeException("展示站点ID不能为空");
		}
		cpOutSiteCouponDAO.clearAdviseSort(outId);
		List<CpOutSiteCoupon> sortList = couponSortRequest.getCpOutSiteCouponList();
		if(null != sortList) {
			for (CpOutSiteCoupon cpOutSiteCoupon: sortList) {
				this.updateAdviseSort(cpOutSiteCoupon);
			}
		}
		
	}
	

}
