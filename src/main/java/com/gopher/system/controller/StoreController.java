package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(path="/getPage")
	public Result getPage(@ModelAttribute StorePageRequst storeRequest) {
		Result result = new Result();
		result.setData(storeService.getPage(storeRequest));
		return result;
	}
	@PostMapping(path="/edit")
	public Result edit(@RequestBody CpStore cpStore) {
		Result result = new Result();
		storeService.edit(cpStore);
		return result;
	}
	

}
