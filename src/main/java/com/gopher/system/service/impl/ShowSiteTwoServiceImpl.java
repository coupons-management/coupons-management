package com.gopher.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.*;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.*;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.response.OutSiteStoreRsp;
import com.gopher.system.service.ShowSiteTwoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShowSiteTwoServiceImpl implements ShowSiteTwoService {
	@Autowired
	private CpOutSiteDAO cpOutSiteDAO;
	@Autowired
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	@Autowired
	private CpSitestoreTypeDAO cpSitestoreTypeDAO;
	@Autowired
	private CpOutSiteCouponDAO cpOutSiteCouponDAO;
	@Autowired
	private CpCouponDAO cpCouponDAO;
    @Autowired
	private CpStoreDAO cpStoreDAO;
    @Autowired
    private CpTypeStoreDAO cpTypeStoreDAO;


	@Override
	public List<CpOutSite> getSiteList() {
		return cpOutSiteDAO.getList();
	}


	@Override
	public Page<CpOutSiteStoreVo> getTwoList(ShowSiteStoreRequest request) {
		Page<CpOutSiteStoreVo> result = new Page<>();
		final int siteId = request.getOutId();
		List<CpOutSiteStoreVo> list = cpOutSiteStoreDAO.getTwoList(request);
		if (list != null && list.size() > 0) {
			for (CpOutSiteStoreVo vo : list) {
				if (vo == null) {
					list = null;
					break;
				}
				List<String> map = cpOutSiteStoreDAO.getInScrapy(vo.getStoreId());
				if (map != null) {
					vo.setScrapyList(map);
					vo.setScrapyCount(map == null ? 0 : map.size());
				}
				request.setStoreId(vo.getStoreId());
				vo.setShowCount(vo.getValidCount() + "/" + vo.getToalCount());
				CpTypeStore type = cpTypeStoreDAO.getByStore(vo.getStoreId(),siteId);
				if(null != type){
					CpSitestoreType cpSitestoreType = cpSitestoreTypeDAO.selectByPrimaryKey(type.getTypeId());
					if(null != cpSitestoreType){
						vo.setTypeName(cpSitestoreType.getName());
					}
				}

			}
		}
		int total = cpOutSiteStoreDAO.getTwoCount(request);
		result.setList(list);
		result.setTotalCount(total);
		result.setPageSize(request.getPageSize());
		result.setPageNumber(request.getPageNumber());
		return result;

	}

	@Override
	public void updateOutSiteStore(OutSiteStoreRsp cpOutSiteStore) {
		if(cpOutSiteStore == null){
          throw new BusinessRuntimeException("参数不能为空");
		}
		final Integer id = cpOutSiteStore.getId();
		final Integer storeId = cpOutSiteStore.getStoreId();
		if(null == id && id <= 0){
			throw new BusinessRuntimeException("非法的ID");
		}
		if(null == storeId && storeId <=0){
			throw new BusinessRuntimeException("无效的商家ID");
		}
		cpOutSiteStoreDAO.updateByPrimaryKey(cpOutSiteStore);
		CpStore cpStore = new CpStore();
		cpStore.setId(storeId);
		// 同步主表logo
		cpStore.setLogoUrl(cpOutSiteStore.getLogo());
		cpStoreDAO.updateByPrimaryKeySelective(cpStore);
		final int typeId = cpOutSiteStore.getTypeId();
		// 同步分类
		if(typeId > 0){
			CpTypeStore cpTypeStore = cpTypeStoreDAO.selectByPrimaryKey(typeId);
			if(null == cpTypeStore){
				cpTypeStore = new CpTypeStore();
				cpTypeStore.setTypeId(typeId);
				cpTypeStore.setOutSiteId(cpOutSiteStore.getOutId());
				cpTypeStore.setStoreId(storeId);
				cpTypeStore.setCreateTime(new Date());
				cpTypeStoreDAO.insert(cpTypeStore);
			}else{
				cpTypeStore.setTypeId(typeId);
				cpTypeStore.setUpdateTime(new Date());
				cpTypeStoreDAO.updateByPrimaryKeySelective(cpTypeStore);
			}
		}

	}

	@Override
	public void deleteOutSiteStore(CpOutSiteStore cpOutSiteStore) {
		cpOutSiteStoreDAO.deleteByPrimaryKey(cpOutSiteStore.getId());

	}

	@Override
	public Page<CpCoupon> getCouponList(ShowSiteStoreRequest request) {
		Page<CpCoupon> result = new Page<CpCoupon>();
		result.setList(cpOutSiteStoreDAO.getCouponList(request));
		int total = cpOutSiteStoreDAO.getCouponCount(request);
		result.setTotalCount(total);
		result.setPageSize(request.getPageSize());
		result.setPageNumber(request.getPageNumber());

		return result;
	}

	@Override
	public Page<CpCoupon> getNewCouponList(ShowSiteStoreRequest request) {
		Page<CpCoupon> result = new Page<CpCoupon>();
		result.setList(cpOutSiteStoreDAO.getNewCouponList(request));
		int total = cpOutSiteStoreDAO.getNewCouponCount(request);
		result.setPageSize(request.getPageSize());
		result.setPageNumber(request.getPageNumber());
		result.setTotalCount(total);

		return result;
	}

	@Override
	public List<CpSitestoreType> getStoreSort(CpSitestoreRequest request) {
		return cpSitestoreTypeDAO.getStoreSort(request);
	}

	@Override
	public OutSiteStoreRsp getSiteStroreById(CpOutSiteStore obj) {
		if(null == obj){
			throw new BusinessRuntimeException("参数不能为空");
		}
		CpOutSiteStore store = cpOutSiteStoreDAO.selectByPrimaryKey(obj.getId());
		if(null == store){
			throw new BusinessRuntimeException("根据ID找不到商家记录");
		}
		final int storeId = store.getStoreId();
		CpStore cpStore = cpStoreDAO.selectByPrimaryKey(storeId);
		OutSiteStoreRsp result = new OutSiteStoreRsp();
		BeanUtils.copyProperties(store,result);
		if(null != cpStore){
			result.setLogo(cpStore.getLogoUrl());
			result.setName(cpStore.getName());
		}
		// TODO 找到当前商家在官网的分类
		CpTypeStore cpTypeStore = cpTypeStoreDAO.getByStore(storeId,store.getOutId());
		if(null != cpTypeStore){
			result.setTypeId(cpTypeStore.getTypeId());
		}
		return result;
	}

	@Override
	public void addCoupon(CpCoupon bean) {
		CpOutSiteCoupon siteCoupon = new CpOutSiteCoupon();
		siteCoupon.setTitle(bean.getTitle());

		siteCoupon.setOutSiteId(bean.getSiteId());
		bean.setSiteId(0);
		bean.setName(bean.getTitle());
		cpCouponDAO.insert(bean);
		siteCoupon.setStoreId(bean.getId());
		cpOutSiteCouponDAO.insert(siteCoupon);

	}

}
