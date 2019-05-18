package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.service.StoreService;

@RestController
@RequestMapping(path="/store")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(path="/getPage")
	public Result getPage(@RequestBody StorePageRequst storeRequest) {
		Result result = new Result();
		result.setData(storeService.getPage(storeRequest));
		return result;
	}
	@RequestMapping(path="/edit")
	public Result edit(@RequestBody CpStore cpStore) {
		Result result = new Result();
		storeService.edit(cpStore);
		return result;
	}
	

}
