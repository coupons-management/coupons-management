package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.request.ShowSiteCouponRequest;
import com.gopher.system.service.ShowSiteCouponService;
/**
 * 展示站点优惠券接口
 * @author dongyangyang
 *
 */
@RestController
@RequestMapping(path="/showSiteCoupon")
public class ShowSiteCouponController {
	@Autowired
	private ShowSiteCouponService showSiteCouponService;
	
	@RequestMapping(path="/getCouponPage")
	public Result getCouponPage(@RequestBody  ShowSiteCouponPageRequest showSiteCouponPageRequest) {
		Result result = new Result();
		result.setData(showSiteCouponService.getCouponPage(showSiteCouponPageRequest));
		return result;
	}

	/**
	 * 获取人工排序的优惠券列表
	 * @param showSiteCouponPageRequest
	 * @return
	 */
	@RequestMapping(path="/getCouponListWithSort")
	public Result getCouponListWithSort(@RequestBody  ShowSiteCouponPageRequest showSiteCouponPageRequest) {
		Result result = new Result();
		result.setData(showSiteCouponService.getCouponListWithSort(showSiteCouponPageRequest));
		return result;
	}
	
	@RequestMapping(path="/edit")
	public Result edit(@RequestBody  ShowSiteCouponRequest showSiteCouponRequest) {
		Result result = new Result();
		showSiteCouponService.edit(showSiteCouponRequest);
		return result;
	}
	
	@RequestMapping(path="/delete")
	public Result delete(@RequestBody  ShowSiteCouponRequest showSiteCouponRequest) {
		Result result = new Result();
		showSiteCouponService.delete(showSiteCouponRequest);
		return result;
	}
}
