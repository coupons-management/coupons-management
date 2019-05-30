package com.gopher.system.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.CpTypePageRequest;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.service.OfficialWebsiteService;

@RestController
@RequestMapping(path="/officialWebsite")
public class OfficialWebsiteController {
	@Resource
	OfficialWebsiteService officialWebsiteService;
	@RequestMapping(path="/getCategoriesList")
	Result getCategoriesList(){
		Result result = new Result();
		result.setData( officialWebsiteService.getCategoriesList());
		return result;
	}
	@RequestMapping(path="/getPopularStoresList")
	Result getPopularStoresList(){
		Result result = new Result();
		result.setData( officialWebsiteService.getCategoriesList());
		return result;
	}
	
	
	
	
	@RequestMapping(path="/getStorePageList")
	Result getStorePageList(StorePageRequst quest){
		Result result = new Result();
		result.setData( officialWebsiteService.getStorePageList(quest));
		return result;
	}
	
	

	@RequestMapping(path="/getCategoriesPageList")
	Result getCategoriesPageList(CpTypePageRequest quest){
		Result result = new Result();
		result.setData( officialWebsiteService.getCategoriesPageList(quest));
		return result;
	}

	
	
	@RequestMapping(path="/getCouponPageList")
	Result getCouponPageList(CouponPageRequest quest){
		Result result = new Result();
		result.setData( officialWebsiteService.getCouponPageList(quest));
		return result;
	}


}
