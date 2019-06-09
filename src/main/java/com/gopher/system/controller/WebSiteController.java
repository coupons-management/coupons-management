package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.CategoryRequest;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.service.ShowSiteTypeService;
import com.gopher.system.service.WebSiteService;
/**
 * 官网接口
 * @author dongyangyang
 *
 */
@RestController
@RequestMapping(path="/website")
public class WebSiteController {
	@Autowired
	private WebSiteService webSiteService;
	@Autowired
	private ShowSiteTypeService showSiteTypeService;
	/**
	 * 获取商家详情 涵盖商家所有信息
	 *          商家下的所有优惠券
	 * @param quest
	 * @return
	 */
	@RequestMapping(path="/getStoreDetail")
	Result getStoreDetail(@RequestBody StoreRequest storeRequest){
		Result result = new Result();
		result.setData(webSiteService.getStoreDetail(storeRequest));
		return result;
	}
	
	@RequestMapping(path="/getCouponsByCategory")
	Result getCouponsByCategory(@RequestBody CategoryRequest categoryRequest){
		Result result = new Result();
		result.setData(webSiteService.getCouponListByCategory(categoryRequest));
		return result;
	}
	
	@RequestMapping(path="/getCategoryChild")
	Result getCategoryChild(@RequestBody CategoryRequest categoryRequest){
		Result result = new Result();
		result.setData(showSiteTypeService.getSonList(categoryRequest.getId()));
		return result;
	}
}
