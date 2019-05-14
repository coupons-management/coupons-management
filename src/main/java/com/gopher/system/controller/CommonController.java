package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.service.CommonService;

/**
 * 基础通用接口
 * 
 * @author dongyangyang
 *
 */
@RestController
@RequestMapping("/commons")
public class CommonController {
	@Autowired
	private CommonService commonService;
	@GetMapping("/getSpiderList")
	public Result getSpiderList() {
		Result result = new Result();
		result.setData(commonService.getSpiderList());
		return result;
	}
	
	@GetMapping("/getCouponTypeList")
	public Result getCouponTypeList() {
		Result result = new Result();
		result.setData(commonService.getCouponTypeList());
		return result;
	}
	
	@GetMapping("/getExpiryList")
	public Result getExpiryList() {
		Result result = new Result();
		result.setData(commonService.getExpiryList());
		return result;
	}

}
