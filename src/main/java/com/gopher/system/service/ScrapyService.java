package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.ScrapyRecordPageRequst;
import com.gopher.system.model.vo.response.CpCategoryMongoVo;
import com.gopher.system.model.vo.response.CpCouponMongoVo;
import com.gopher.system.model.vo.response.CpStoreMongoVo;

public interface ScrapyService {
	
	List<CpScrapy> getList();
	
	Integer setWeight(Integer id, Integer weight);

	Page<CpScrapyRecode> getRecordList(ScrapyRecordPageRequst request);
	
	Page<CpStoreMongoVo> getLastStoreList(int pageNum, String spiderName, String name, String website);

	Page<CpCouponMongoVo> getLastCouponList(int pageNum, String spiderName, String name, String type, String isPast);
	
	List<CpCategoryMongoVo> getLastCategoryList(String spiderName, String name);
	
}
