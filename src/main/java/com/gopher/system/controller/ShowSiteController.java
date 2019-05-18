package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
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

}
