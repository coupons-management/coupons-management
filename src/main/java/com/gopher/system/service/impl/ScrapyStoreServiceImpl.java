package com.gopher.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StoreAllPageRequst;
import com.gopher.system.service.ScrapyStoreService;
@Service
public class ScrapyStoreServiceImpl implements ScrapyStoreService {
    @Autowired
    private CpStoreDAO cpStoreDAO;

	/**
	 * 获得爬虫商家分页列表
	 * 
	 * @param storePageRequest
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
	 * 获得爬虫总数
	 * 
	 * @param storePageRequest
	 * @return
	 */
	int getScrapyCount(StoreAllPageRequst storeAllPageRequst) {
		return cpStoreDAO.getScrapyCount(storeAllPageRequst);
	}	

}
