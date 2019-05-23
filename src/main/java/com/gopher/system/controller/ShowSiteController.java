package com.gopher.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.service.ShowSiteService;

@RestController
@RequestMapping(path="/showSite")
public class ShowSiteController {
	@Autowired
	private ShowSiteService showSiteService;
	
	@RequestMapping(path="/getList")
	public Result getList() {
		Result result = new Result();
		result.setData(showSiteService.getSiteList());
		return result;
	}
	
	@RequestMapping(path="/addStoreToSiteBatch")
	public Result addSiteStore(@RequestBody List<ShowSiteStoreRequest> showSiteStoreList) {
		Result result = new Result();
		showSiteService.addStoreToSiteBatch(showSiteStoreList);
		return result;
	}
	@RequestMapping(path="/addStoreToSite")
	public Result addSiteStoreBatch(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		showSiteService.addStoreToSite(showSiteStoreRequest);
		return result;
	}
	
	@RequestMapping(path="/deleteStoreToSite")
	public Result addSiteStore(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		showSiteService.deleteStoreInSite(showSiteStoreRequest);;
		return result;
	}
	

}
