package com.gopher.system.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.CpTypePageRequest;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.service.OfficialWebsiteService;
import com.gopher.system.service.impl.ShowSiteTypeServiceImpl;

@RestController
@RequestMapping(path="/officialWebsite")
public class OfficialWebsiteController {
	@Resource
	OfficialWebsiteService officialWebsiteService;
	@Resource
	ShowSiteTypeServiceImpl  showSiteTypeServiceImpl;
	@RequestMapping(path="/getCategoriesList")
	Result getCategoriesList(@RequestBody CpSitestoreRequest quest){
		Result result = new Result();
		//result.setData( officialWebsiteService.getCategoriesList());
		result.setData( showSiteTypeServiceImpl.getList(quest.getSiteId(), 2));
		return result;
	}
	@RequestMapping(path="/getPopularStoresList")
	Result getPopularStoresList(@RequestBody CpSitestoreRequest quest){
		Result result = new Result();
		//result.setData( officialWebsiteService.getCategoriesList());
		result.setData( showSiteTypeServiceImpl.getList(quest.getSiteId(), 2));
		return result;
	}
	
	
	
	
	@RequestMapping(path="/getStorePageList")
	Result getStorePageList(@RequestBody StorePageRequst quest){
		Result result = new Result();
		result.setData( officialWebsiteService.getStorePageList(quest));
		return result;
	}
	
	

	@RequestMapping(path="/getCategoriesPageList")
	//Result getCategoriesPageList(CpTypePageRequest quest){
	Result getCategoriesPageList(@RequestBody CpSitestoreRequest  quest){
		Result result = new Result();
		//result.setData( officialWebsiteService.getCategoriesPageList(quest));
		result.setData( showSiteTypeServiceImpl.getList(quest.getSiteId(), 2));
		return result;
	}

	
	
	@RequestMapping(path="/getCouponPageList")
	Result getCouponPageList(@RequestBody CouponPageRequest quest){
		Result result = new Result();
		result.setData( officialWebsiteService.getCouponPageList(quest));
		return result;
	}

	
	@RequestMapping(path="/getTopStoreList")
	Result getTopStoreList(@RequestBody CpSitestoreRequest quest){
		Result result = new Result();
		result.setData( officialWebsiteService.getTopStoreList(quest));
		return result;
	}
	
	@RequestMapping(path="/getTopCouponList")
	Result getTopCouponList(@RequestBody CouponPageRequest quest){
		Result result = new Result();
		result.setData( officialWebsiteService.getTopCouponList(quest));
		return result;
	}

}
