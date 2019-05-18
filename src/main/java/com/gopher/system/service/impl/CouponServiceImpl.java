package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.constant.SystemConstants;
import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpScrapy;
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
	@Autowired
	private CpScrapyDAO cpScrapyDAO;
	@Override
	public Page<CouponResponse> getPage(CouponPageRequest couponPageRequest) {
		Page<CouponResponse> result = new Page<CouponResponse>();
		// 爬虫站ID
		final Integer sipder_id = couponPageRequest.getScrapy();
		if(null != sipder_id) {
			CpScrapy cpScrap = cpScrapyDAO.selectByPrimaryKey(sipder_id);
			if(null != cpScrap) {
				couponPageRequest.setScrapyStr(cpScrap.getName());
			}
		}
		couponPageRequest.setNowDate(new Date());
		List<CpCoupon> couponList   = cpCouponDAO.getPageList(couponPageRequest);
		final int totalCount        = cpCouponDAO.getCount(couponPageRequest);
		List<CouponResponse> list   = null;
		final long current_time_milllis = System.currentTimeMillis();
		if(null != couponList) {
			list = new ArrayList<>(couponList.size());
			for (CpCoupon cpCoupon : couponList) {
				CouponResponse rsp = new CouponResponse();
				rsp.setId(cpCoupon.getId());
				CpStore storeDB = cpStoreDAO.selectByPrimaryKey(cpCoupon.getStoreId());
				if(null != storeDB) {
					rsp.setStoreName(storeDB.getName());
				}
				rsp.setTitle(cpCoupon.getTitle());
				rsp.setType(cpCoupon.getCouponType());
				rsp.setDescription(cpCoupon.getDes());
				final Date experityAt = cpCoupon.getExpireAt();
				if(null != experityAt) {
					rsp.setExpired(experityAt.getTime() > current_time_milllis);
				}else {
					rsp.setExpired(true);
				}
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
	
	@Override
	public List<CouponResponse> getListByStore(final int storeId){
		CpCoupon query = new CpCoupon();
		query.setStoreId(storeId);
		List<CpCoupon> list = cpCouponDAO.getList(query);
		List<CouponResponse> result = null;
		final long current_time_milllis = System.currentTimeMillis();
		if(null != list) {
			result = new ArrayList<>(list.size());
			for (CpCoupon cpCoupon : list) {
				CouponResponse rsp = new CouponResponse();
				rsp.setId(cpCoupon.getId());
				rsp.setTitle(cpCoupon.getTitle());
				rsp.setType(cpCoupon.getCouponType());
				rsp.setDescription(cpCoupon.getDes());
				final Date experityAt = cpCoupon.getExpireAt();
				if(null != experityAt) {
					rsp.setExpired(experityAt.getTime()>current_time_milllis);
				}else {
					rsp.setExpired(true);
				}
				rsp.setExpiryTime(DateUtils.getDateString(cpCoupon.getExpireAt()));
				rsp.setCreateTime(DateUtils.getDateString(cpCoupon.getCreateTime()));
				result.add(rsp);
			}
		}
		return result;
	}


	@Override
	public CpCoupon getCoupon(int couponId) {
		if(couponId <=0 ) {
			throw new BusinessRuntimeException("无效的优惠券ID");
		}
		CpCoupon cpCoupon = cpCouponDAO.selectByPrimaryKey(couponId);
		if(null == cpCoupon) {
			throw new BusinessRuntimeException("根据优惠券ID找不到记录:"+couponId);
		}
		return cpCoupon;
	}


	@Override
	public void createCoupon(CpCoupon cpCoupon) {
		if(null == cpCoupon) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final String name = cpCoupon.getName();
		if(!StringUtils.hasText(name)) {
			throw new BusinessRuntimeException("优惠券名称不能为空");
		}
		Date now = new Date();
		cpCoupon.setCreateTime(now);
		cpCoupon.setUpdateTime(now);
		cpCoupon.setInType(SystemConstants.IN_TEYE_MANUAL.getValue().toString());
		cpCouponDAO.insert(cpCoupon);
	}


	@Override
	public void editCoupon(CpCoupon cpCoupon) {
		if(null == cpCoupon) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final String name = cpCoupon.getName();
		final Integer id  = cpCoupon.getId();
		if(null == id || id<=0) {
			throw new BusinessRuntimeException("优惠券ID不能为空");
		}
		if(!StringUtils.hasText(name)) {
			throw new BusinessRuntimeException("优惠券名称不能为空");
		}
		cpCoupon.setUpdateTime(new Date());
		// TODO 获取当前登录用户
		cpCoupon.setUpdateUser(0);
		cpCouponDAO.updateByPrimaryKeySelective(cpCoupon);
	}


	@Override
	public void deleteCoupon(int couponId) {
		if(couponId <= 0) {
			throw new BusinessRuntimeException("优惠券ID不能为空");
		}
		cpCouponDAO.deleteByPrimaryKey(couponId);
	}


}
