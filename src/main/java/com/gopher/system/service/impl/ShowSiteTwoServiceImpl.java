package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.constant.CodeAndMsg;
import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.dao.mysql.CpOutSiteDAO;
import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.dao.mysql.CpSitestoreTypeDAO;
import com.gopher.system.dao.mysql.CpSitestoreTypeMapDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpTypeStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.entity.CpSitestoreTypeMap;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.CpTypeStore;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.ShowSiteTwoService;
import com.gopher.system.util.TitleUtils;

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
		cpOutSiteStoreDAO.updateByPrimaryKey(cpOutSiteStore);
		// 修改商家logo
		CpStore store = new CpStore();

		store.setId(cpOutSiteStore.getStoreId());
		if (StringUtils.isEmpty(cpOutSiteStore.getLogo()) || StringUtils.isEmpty(cpOutSiteStore.getStoreId())) {
			return;
		}
		store.setLogoUrl(cpOutSiteStore.getLogo());
		store.setUpdateTime(new Date());
		store.setUpdateUser(1);
		cpStoreDAO.updateLogo(store);

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
		// TODO Auto-generated method stub
		return cpSitestoreTypeDAO.getStoreSort(request);
	}

	@Override
	public CpOutSiteStore getSiteStroreById(CpOutSiteStore obj) {
		CpOutSiteStore store = cpOutSiteStoreDAO.selectByPrimaryKey(obj.getId());
		if (store == null) {
			return null;
		}

		if (StringUtils.isEmpty(store.getShowName())||"null".equals(store.getShowName())) {
			store.setShowName(TitleUtils.getStoreMessage("SHOWNAME"));
		}
		if (StringUtils.isEmpty(store.getStoreDes())||"null".equals(store.getStoreDes())) {
			store.setHeaderDes(TitleUtils.getStoreMessage("STOREDES"));
		}

		if (StringUtils.isEmpty(store.getTitle())||"null".equals(store.getTitle())) {
			store.setTitle(TitleUtils.getStoreMessage("TITLE"));
		}
		if (StringUtils.isEmpty(store.getKeywords())||"null".equals(store.getKeywords())) {
			store.setKeywords(TitleUtils.getStoreMessage("KEYWORD"));
		}

		if (StringUtils.isEmpty(store.getStoreDes())) {
			store.setStoreDes(TitleUtils.getStoreMessage("DESCRIPTION"));
		}

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
