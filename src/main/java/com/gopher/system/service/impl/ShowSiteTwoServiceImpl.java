package com.gopher.system.service.impl;

import com.gopher.system.dao.mysql.*;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.*;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.service.ShowSiteTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public List<CpOutSite> getSiteList() {
		return cpOutSiteDAO.getList();
	}


	@Override
	public Page<CpOutSiteStoreVo> getTwoList(ShowSiteStoreRequest request) {
		Page<CpOutSiteStoreVo> result = new Page<CpOutSiteStoreVo>();
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
				vo.setValidCount(cpOutSiteStoreDAO.getValidCoupon(request));
				vo.setToalCount(cpOutSiteStoreDAO.getToalCoupon(request));
				vo.setShowCount(vo.getValidCount() + "/" + vo.getToalCount());
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
	public void updateOutSiteStore(CpOutSiteStore cpOutSiteStore) {
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
	public CpOutSiteStore getSiteStroreById(CpOutSiteStore obj) {
		if(null == obj){
			throw new BusinessRuntimeException("参数不能为空");
		}

		CpOutSiteStore store = cpOutSiteStoreDAO.selectByPrimaryKey(obj.getId());

		if(null == store){
			throw new BusinessRuntimeException("根据ID找不到商家记录");
		}
		CpStore cpStore = cpStoreDAO.selectByPrimaryKey(store.getStoreId());
		if(null != cpStore){
			store.setLogo(cpStore.getLogoUrl());
		}
//
//		if (StringUtils.isEmpty(store.getShowName())||"null".equals(store.getShowName())) {
//			store.setShowName(TitleUtils.getStoreMessage("SHOWNAME"));
//		}
//		if (StringUtils.isEmpty(store.getStoreDes())||"null".equals(store.getStoreDes())) {
//			store.setHeaderDes(TitleUtils.getStoreMessage("STOREDES"));
//		}
//
//		if (StringUtils.isEmpty(store.getTitle())||"null".equals(store.getTitle())) {
//			store.setTitle(TitleUtils.getStoreMessage("TITLE"));
//		}
//		if (StringUtils.isEmpty(store.getKeywords())||"null".equals(store.getKeywords())) {
//			store.setKeywords(TitleUtils.getStoreMessage("KEYWORD"));
//		}
//
//		if (StringUtils.isEmpty(store.getStoreDes())) {
//			store.setStoreDes(TitleUtils.getStoreMessage("DESCRIPTION"));
//		}

		return store;
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
