package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.service.StoreAuditService;

@RestController
@RequestMapping(path="/storeAudit")
public class StoreAuditController {
	@Autowired
	private StoreAuditService storeAuditService;
	
	@RequestMapping(path="/addSite")
	public Result addSite(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		storeAuditService.addSite(cpOutSiteStore);
		//result.setData(storeAuditService.addSite(cpSiteStore));
		return result;
	}
	@RequestMapping(path="/getOutSitleList")
	public Result getOutSitleList(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		result.setData(storeAuditService.getOutSitleList(cpOutSiteStore));
		return result;
	}
}
