package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.request.SourceTypeRequest;
import com.gopher.system.model.vo.request.TypeMapRequest;
import com.gopher.system.service.ShowSiteTypeService;

@RestController
@RequestMapping(path="/showSiteType")
public class ShowSiteTypeController {
	@Autowired
	private ShowSiteTypeService showSiteTypeService;
	

	@RequestMapping(path="/getTree")
	public Result getList(int siteId) {
		Result result = new Result();
		result.setData(showSiteTypeService.getTree(siteId));
		return result;
	}
	
	@RequestMapping(path="/create")
	public Result getPage(@RequestBody CpSitestoreType cpSitestoreType) {
		Result result = new Result();
		showSiteTypeService.create(cpSitestoreType);
		return result;
	}
	
	@RequestMapping(path="/delete")
	public Result getPage(int id) {
		Result result = new Result();
		showSiteTypeService.delete(id);
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
