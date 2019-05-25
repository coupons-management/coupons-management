package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping("/getSpiderList")
	public Result getSpiderList() {
		Result result = new Result();
		result.setData(commonService.getSpiderList());
		return result;
	}
	
	@RequestMapping("/getCouponTypeList")
	public Result getCouponTypeList() {
		Result result = new Result();
		result.setData(commonService.getCouponTypeList());
		return result;
	}
	
	@RequestMapping("/getExpiryList")
	public Result getExpiryList() {
		Result result = new Result();
		result.setData(commonService.getExpiryList());
		return result;
	}
	
	@RequestMapping("/getTypeList")
	public Result getTypeList() {
		Result result = new Result();
		result.setData(commonService.getTypeList());
		return result;
	}
	
	@RequestMapping("/getHasSpiderTypeDict")
	public Result getHasSpiderTypeDict() {
		Result result = new Result();
		result.setData(commonService.getHasSpiderTypeDict());
		return result;
	}
	
	@RequestMapping("/getCountryDict")
	public Result getCountryDict() {
		Result result = new Result();
		result.setData(commonService.getCountryDict());
		return result;
	}
	@RequestMapping("/getApprovalDict")
	public Result getApprovalDict() {
		Result result = new Result();
		result.setData(commonService.getApprovalDict());
		return result;
	}
	@RequestMapping("/getIsCompleteDict")
	public Result getIsComplete() {
		Result result = new Result();
		result.setData(commonService.getApprovalDict());
		return result;
	}
	
	@RequestMapping("getCreateTypeDict")
	public Result getCreateTypeDict() {
		Result result = new Result();
		result.setData(commonService.getCreateType());
		return result;
	}
	
}
