package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.request.ShowSiteCouponRequest;
import com.gopher.system.model.vo.response.ShowSiteCouponResponse;
import com.gopher.system.service.ShowSiteCouponService;
@Service
public class ShowSiteCouponServiceImpl implements ShowSiteCouponService{
	@Autowired
    private CpOutSiteCouponDAO cpOutSiteCouponDAO;
	@Autowired
	private CpCouponDAO cpCouponDAO;
	@Override
	public Page<ShowSiteCouponResponse> getCouponPage(ShowSiteCouponPageRequest showSiteCouponPageRequest) {
		if(null == showSiteCouponPageRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final  int siteId  = showSiteCouponPageRequest.getSiteId();
		if(siteId <=0 ) {
			throw new BusinessRuntimeException("非法的站点ID");
		}
		Page<ShowSiteCouponResponse> result = new Page<>();
		result.setPageNumber(showSiteCouponPageRequest.getPageNumber());
		result.setPageSize(showSiteCouponPageRequest.getPageSize());
		List<ShowSiteCouponResponse> list = cpOutSiteCouponDAO.getPageList(showSiteCouponPageRequest);
		final int count = cpOutSiteCouponDAO.getTotalCount(showSiteCouponPageRequest);
		result.setList(list);
		result.setTotalCount(count);
		return result;
	}
	@Override
	public void edit(ShowSiteCouponRequest showSiteCouponRequest) {
		if(null == showSiteCouponRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int id    = showSiteCouponRequest.getId();
		final int mapId = showSiteCouponRequest.getMapId();
		
		if(id <=0 || mapId <=0) {
			throw new BusinessRuntimeException("非法的ID");
		}
		
		final String title = showSiteCouponRequest.getCurrentTile();
		if(StringUtils.hasText(title)) {
			CpOutSiteCoupon record = new CpOutSiteCoupon();
			record.setUpdateTime(new Date());
			record.setTitle(title);
			record.setId(mapId);
			cpOutSiteCouponDAO.updateByPrimaryKeySelective(record);
		}
		final String code = showSiteCouponRequest.getCode();
		final String isPass = showSiteCouponRequest.getIsPass();
		final Date   expriyTime = showSiteCouponRequest.getExpriyTime();
		final String desc   = showSiteCouponRequest.getDescription();
		if(StringUtils.hasText(code)) { 
			CpCoupon cpCoupon = new CpCoupon();
			cpCoupon.setCode(code);
			cpCoupon.setIsPass(isPass);
			cpCoupon.setExpireAt(expriyTime);
			cpCoupon.setDes(desc);
			cpCouponDAO.updateByPrimaryKeySelective(cpCoupon);
		}
		
	}
	@Override
	public void delete(ShowSiteCouponRequest showSiteCouponRequest) {
		if(null == showSiteCouponRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int id    = showSiteCouponRequest.getId();
		final int mapId = showSiteCouponRequest.getMapId();
		
		if(id <=0 || mapId <=0) {
			throw new BusinessRuntimeException("非法的ID");
		}
		cpOutSiteCouponDAO.deleteByPrimaryKey(id);
		
	}
	
	

}
