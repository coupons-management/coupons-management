package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.StoreAllPageRequst;
import com.gopher.system.service.ScrapyStoreService;


@RestController
@RequestMapping(path="/scrapyStore")
public class ScrapyStoreController {
	@Autowired
	private ScrapyStoreService scrapyStoreService;
	@RequestMapping(path="/getListPage")
	public Result getListPage(@RequestBody  StoreAllPageRequst storeAllPageRequst) {
		Result result = new Result();
		result.setData(scrapyStoreService.getScrapyPageList(storeAllPageRequst));
		return result;
	}
	
}
