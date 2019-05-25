package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.request.SiteTypeTreeRequest;
import com.gopher.system.model.vo.request.SourceTypeRequest;
import com.gopher.system.model.vo.request.TypeMapRequest;
import com.gopher.system.service.ShowSiteTypeService;

@RestController
@RequestMapping(path="/showSiteType")
public class ShowSiteTypeController {
	@Autowired
	private ShowSiteTypeService showSiteTypeService;
	

	@RequestMapping(path="/getTree")
	public Result getList(@RequestBody SiteTypeTreeRequest siteTypeTreeRequest) {
		Result result = new Result();
		final int siteId = siteTypeTreeRequest.getSiteId();
		result.setData(showSiteTypeService.getTree(siteId));
		return result;
	}
	
	@RequestMapping(path="/create")
	public Result create(@RequestBody CpSitestoreType cpSitestoreType) {
		Result result = new Result();
		showSiteTypeService.create(cpSitestoreType);
		return result;
	}
	
	@RequestMapping(path="/delete")
	public Result delete(@RequestBody CpSitestoreType cpSitestoreType) {
		Result result = new Result();
		showSiteTypeService.delete(cpSitestoreType.getId());
		return result;
	}
	
	@RequestMapping(path="/addTypeMap")
	public Result addTypeMap(@RequestBody TypeMapRequest typeMapRequest) {
		Result result = new Result();
		showSiteTypeService.addTypeMap(typeMapRequest);
		return result;
	}
	
	@RequestMapping(path="/getSourceTypeList")
	public Result getSourceTypeList(@RequestBody SourceTypeRequest sourceTypeRequest) {
		Result result = new Result();
		result.setData(showSiteTypeService.getSourceTypeList(sourceTypeRequest));
		return result;
	}

}
