package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpSitestoreTypeDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpTypeDAO;
import com.gopher.system.dao.mysql.CpTypeStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.entity.CpTypeStore;
import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.CpStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CategoryRequest;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
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
	@Autowired
	private CpSitestoreTypeDAO cpSiteStoreTypeDAO;
	@Autowired
	private CpTypeStoreDAO cpTypeStoreDAO;

	@Override
	public List<CpType> getCategoriesList() {
		return cpTypeDAO.getList();
	}

	@Override
	public Page<CpCouponVo> getCouponPageList(CouponPageRequest quest) {

		Page<CpCouponVo> result = new Page<>();
		result.setPageNumber(quest.getPageNumber());
		result.setPageSize(quest.getPageSize());
		List<CpCouponVo> list = cpCouponDAO.getOffWebCouponPageList(quest);
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
	public Page<CpStoreVo> getStorePageList(StorePageRequst quest) {
		Page<CpStoreVo> result = new Page<>();
		result.setPageNumber(quest.getPageNumber());
		result.setPageSize(quest.getPageSize());
		List<CpStoreVo> list = cpStoreDAO.getOffWebStorePageList(quest);
		final int count = cpStoreDAO.getOffWebTotalCount(quest);
		result.setList(list);
		result.setTotalCount(count);
		return result;
	}

	@Override
	public List<CpType> getAllCategoriesList() {
		return cpTypeDAO.getList();
	}

	@Override
	public List<CpStoreVo> getTopStoreList(CpSitestoreRequest quest) {
		return cpStoreDAO.getTopStoreList(quest);
	}

	@Override
	public List<CpCouponVo> getTopCouponList(CouponPageRequest quest) {
		return cpCouponDAO.getTopCouponList(quest);
	}

	@Override
	public List<CpCouponVo> getStoreExpCouponList(CouponPageRequest quest) {
		return cpCouponDAO.getStoreExpCouponList(quest);
	}

	@Override
	public List<CpCouponVo> getStoreCouponList(CouponPageRequest quest) {
		return cpCouponDAO.getStoreCouponList(quest);
	}

	public List<CpCouponVo> getAllStoreByCategory(CategoryRequest categoryRequest) {
		List<CpCouponVo> result = new ArrayList<>();
		if (null == categoryRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int id = categoryRequest.getId();
		if (id <= 0) {
			throw new BusinessRuntimeException("分类ID不能为空");
		}
		List<CpSitestoreType> sonList = cpSiteStoreTypeDAO.getSonList(id);
		List<Integer> storeIdList = new ArrayList<>();
		if (null != sonList && !sonList.isEmpty()) {
			// 如果当前分类下有绑定子级
			// 拿到这个之级下面所有对应的商家
			for (CpSitestoreType cpSitestoreType : sonList) {
				List<CpTypeStore> list = cpTypeStoreDAO.getListByType(cpSitestoreType.getId());
				for (CpTypeStore cpTypeStore : list) {
					storeIdList.add(cpTypeStore.getStoreId());
				}
			}
		}
		// 1级直接关联商家
		CpSitestoreType type = cpSiteStoreTypeDAO.selectByPrimaryKey(id);
		if (null != type) {
			List<CpTypeStore> list = cpTypeStoreDAO.getListByType(type.getId());
			if (null != list) {
				for (CpTypeStore cpTypeStore : list) {
					storeIdList.add(cpTypeStore.getStoreId());
				}
			}
		}
		if (!storeIdList.isEmpty()) {
			// TODO 根据商家ID的集合 找到 当前站点下所有的优惠券
		}
		return result;
	}

	@Override
	public List<CpCouponVo> getStoreCategoryCouponList(CouponPageRequest quest) {
		return cpCouponDAO.getStoreCategoryCouponList(quest);

	}

}
