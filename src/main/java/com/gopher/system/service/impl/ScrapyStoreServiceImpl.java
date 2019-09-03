package com.gopher.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.StoreAllPageRequst;
import com.gopher.system.service.ScrapyStoreService;
@Service
public class ScrapyStoreServiceImpl implements ScrapyStoreService {
    @Autowired
    private CpStoreDAO cpStoreDAO;
    
    @Autowired
    private CpCouponDAO cpCouponDAO;

	/**
	 * 获得爬虫商家分页列表
	 * 
	 * @param storeAllPageRequst
	 * @return
	 */
    public Page<StoreAllPageRequst> getScrapyPageList(StoreAllPageRequst storeAllPageRequst)
	{
    	Page<StoreAllPageRequst> result = new Page<>();
		result.setPageNumber(storeAllPageRequst.getPageNumber());
		result.setPageSize(storeAllPageRequst.getPageSize());
		List<StoreAllPageRequst> list = cpStoreDAO.getScrapyPageList(storeAllPageRequst);
		final int count = cpStoreDAO.getScrapyCount(storeAllPageRequst);
		result.setList(list);
		result.setTotalCount(count);
		return result;
	}

    
    


    
    
    /**
	 * 获得爬虫商家分页列表
	 * 
	 * @param storeAllPageRequst
	 * @return
	 */
    public Page<StoreAllPageRequst> getErrScrapyPageList(StoreAllPageRequst storeAllPageRequst)
	{
    	Page<StoreAllPageRequst> result = new Page<>();
		result.setPageNumber(storeAllPageRequst.getPageNumber());
		result.setPageSize(storeAllPageRequst.getPageSize());
		List<StoreAllPageRequst> list = cpStoreDAO.getErrScrapyPageList(storeAllPageRequst);
		final int count = cpStoreDAO.getErrScrapyCount(storeAllPageRequst);
		result.setList(list);
		result.setTotalCount(count);
		return result;
	}

    
    
    
    
    /**
 	 * 获得优惠卷分页列表
 	 * 
 	 * @param couponPageRequest
 	 * @return
 	 */
     public Page<CpCoupon> getScrapyCouponPageList(CouponPageRequest couponPageRequest)
 	{
     	Page<CpCoupon> result = new Page<>();
 		result.setPageNumber(couponPageRequest.getPageNumber());
 		result.setPageSize(couponPageRequest.getPageSize());
 		List<CpCoupon> list = cpCouponDAO.getScapyPageList(couponPageRequest);
 		final int count = cpCouponDAO.getScapyCount(couponPageRequest);
 		result.setList(list);
 		result.setTotalCount(count);
 		return result;
 	}

    
    /**
	 * 获得优惠卷分页列表
	 * 
	 * @param couponPageRequest
	 * @return
	 */
    public Page<CpCoupon> getErrScrapyCouponPageList(CouponPageRequest couponPageRequest)
	{
    	Page<CpCoupon> result = new Page<>();
		result.setPageNumber(couponPageRequest.getPageNumber());
		result.setPageSize(couponPageRequest.getPageSize());
		List<CpCoupon> list = cpCouponDAO.getErrScapyPageList(couponPageRequest);
		final int count = cpCouponDAO.getErrScapyCount(couponPageRequest);
		result.setList(list);
		result.setTotalCount(count);
		return result;
	}

    
    

    
    
	/**
	 * 获得爬虫总数
	 * 
	 * @param storeAllPageRequst
	 * @return
	 */
	int getScrapyCount(StoreAllPageRequst storeAllPageRequst) {
		return cpStoreDAO.getScrapyCount(storeAllPageRequst);
	}	

}
