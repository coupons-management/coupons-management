package com.gopher.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpTypeDAO;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.CpTypePageRequest;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.service.OfficialWebsiteService;
@Service
public class OfficialWebsiteServiceImpl implements OfficialWebsiteService {
	@Autowired
    private CpTypeDAO cpTypeDAO;
	@Autowired
    private CpStoreDAO cpStoreDAO;
	@Autowired
    private CpCouponDAO cpCouponDAO;
	@Override
	public List<CpType> getCategoriesList() {
		// TODO Auto-generated method stub
		return cpTypeDAO.getList();
	}
	

	@Override
	public Page<CpCoupon> getCouponPageList(CouponPageRequest quest) {

		Page<CpCoupon> result = new Page<>();
		result.setPageNumber(quest.getPageNumber());
		result.setPageSize(quest.getPageSize());
		List<CpCoupon> list = cpCouponDAO.getOffWebCouponPageList(quest);
		final int count = cpCouponDAO.getOffWebTotalCount(quest);
	
		result.setList(list);
		result.setTotalCount(count);
		return result;
	}
	@Override
	public Page<CpType> getCategoriesPageList(CpTypePageRequest quest) {
		
		
		
		Page<CpType> result = new Page<>();
		result.setPageNumber(quest.getPageNumber());
		result.setPageSize(quest.getPageSize());
		List<CpType> list = cpTypeDAO.getCategoriesPageList(quest);
		final int count = cpTypeDAO.getTotalCount(quest);
	
		result.setList(list);
		result.setTotalCount(count);
		
		
		return result;
	}
	@Override
	public Page<CpStore> getStorePageList(StorePageRequst quest) {

		Page<CpStore> result = new Page<>();
		result.setPageNumber(quest.getPageNumber());
		result.setPageSize(quest.getPageSize());
		List<CpStore> list = cpStoreDAO.getOffWebStorePageList(quest);
		final int count = cpStoreDAO.getOffWebTotalCount(quest);
	
		result.setList(list);
		result.setTotalCount(count);
		return result;
	}
	@Override
	public List<CpType> getAllCategoriesList() {
		return cpTypeDAO.getList();
	}

}
