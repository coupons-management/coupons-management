package com.gopher.system.service.impl;

import com.gopher.system.dao.mysql.*;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.*;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.request.StoreDetailJspRequest;
import com.gopher.system.model.vo.response.OutSiteStoreRsp;
import com.gopher.system.service.ShowSiteTwoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
		List<CpOutSiteStoreVo> list = cpOutSiteStoreDAO.getTwoList(request);
		if (list != null && list.size() > 0) {
    		final int siteId = request.getOutId();
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
				CpTypeStore type = cpTypeStoreDAO.getByStore(vo.getStoreId(), siteId);
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

	private void checkValue(OutSiteStoreRsp cpOutSiteStore, boolean isEdit){
	  if(cpOutSiteStore == null){
        throw new BusinessRuntimeException("参数不能为空");
      }
      final Integer outId = cpOutSiteStore.getOutId();
      if(null == outId){
        throw new BusinessRuntimeException("无效的网站ID");
      }
      if(isEdit){
        final Integer id = cpOutSiteStore.getId();
        final Integer storeId = cpOutSiteStore.getStoreId();
        if(null == id){
            throw new BusinessRuntimeException("非法的ID");
        }
        if(null == storeId){
            throw new BusinessRuntimeException("无效的商家ID");
        }
      }
      
      //如果网址重复则提示
      String website = cpOutSiteStore.getWebsite();
      StoreDetailJspRequest request = new StoreDetailJspRequest(website, outId);
      CpStore cpStore = cpStoreDAO.findByWebsite(request);
      if(cpStore != null && cpStore.getId() != cpOutSiteStore.getId()){
        throw new BusinessRuntimeException("该官网已存在，请重新输入");
      }
	}
	@Override
    public void addOutSiteStore(OutSiteStoreRsp cpOutSiteStore) {
	    checkValue(cpOutSiteStore, false);
        
        //新增店铺
	    CpStore cpStore = new CpStore();
        cpStore.setName(cpOutSiteStore.getName());
        cpStore.setWebsite(cpOutSiteStore.getWebsite());
        //cpStore.setCountry(stu.getStoreCountry());
        cpStore.setLogoUrl(cpOutSiteStore.getLogo());
        final Date now = new Date();
        cpStore.setCreateTime(now);
        cpStore.setUpdateTime(now);
        cpStore.setInType("1");// 0同步入库 1人工入库
//        cpStore.setTypeName(cpType.getName());
//        cpStore.setTypeId(cpType.getId());
        cpStore.setIsComplete("1");
        cpStore.setApproval("1");// 人工入库默认审核通过
        cpStoreDAO.insertSelective(cpStore);
        
        //新增网站店铺
        cpOutSiteStore.setStoreId(cpStore.getId());
        cpOutSiteStore.setCreateTime(now);
        cpOutSiteStore.setUpdateTime(now);
        cpOutSiteStoreDAO.insertSelective(cpOutSiteStore);
        // 同步分类
        final Integer typeId = cpOutSiteStore.getTypeId();
        if(typeId != null){
            CpTypeStore cpTypeStore = new CpTypeStore();
            cpTypeStore.setTypeId(typeId);
            cpTypeStore.setOutSiteId(cpOutSiteStore.getOutId());
            cpTypeStore.setStoreId(cpStore.getStoreId());
            cpTypeStore.setCreateTime(new Date());
            cpTypeStoreDAO.insert(cpTypeStore);
        }
    }
	
	@Override
	public void updateOutSiteStore(OutSiteStoreRsp cpOutSiteStore) {
		checkValue(cpOutSiteStore, true);
		
		final Integer outId = cpOutSiteStore.getOutId();
		final Integer storeId = cpOutSiteStore.getStoreId();
		
		cpOutSiteStoreDAO.updateByPrimaryKey(cpOutSiteStore);
		// 同步主表logo
		String logo = cpOutSiteStore.getLogo();
		if(StringUtils.hasText(logo)){
		  CpStore cpStore = new CpStore();
		  cpStore.setId(storeId);
		  cpStore.setLogoUrl(logo);
		  cpStoreDAO.updateByPrimaryKeySelective(cpStore);
		}
		// 同步分类
		final Integer typeId = cpOutSiteStore.getTypeId();
		CpTypeStore cpTypeStore = cpTypeStoreDAO.getByStore(storeId, outId);
		if(typeId != null){
			if(cpTypeStore == null){//之前没有分类，设置了分类，加中间表数据
				cpTypeStore = new CpTypeStore();
				cpTypeStore.setTypeId(typeId);
				cpTypeStore.setOutSiteId(outId);
				cpTypeStore.setStoreId(storeId);
				cpTypeStore.setCreateTime(new Date());
				cpTypeStoreDAO.insert(cpTypeStore);
			} else {
			  Integer oldTypeId = cpTypeStore.getTypeId(); 
			  if(!typeId.equals(oldTypeId)) {//之前有分类，但分类有改动，改数据
			    cpTypeStore.setTypeId(typeId);
			    cpTypeStore.setUpdateTime(new Date());
			    cpTypeStoreDAO.updateByPrimaryKeySelective(cpTypeStore);
			  }
			}
		} else if(cpTypeStore != null){//之前有分类，现在没有分类，删除数据
		  cpTypeStoreDAO.deleteByPrimaryKey(cpTypeStore.getId());
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
		CpTypeStore cpTypeStore = cpTypeStoreDAO.getByStore(storeId, store.getOutId());
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
