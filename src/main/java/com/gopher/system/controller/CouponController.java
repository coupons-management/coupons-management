package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.service.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {
	@Autowired
	private CouponService couponService;
	@RequestMapping(path="/getPage")
	public Result getPage(@RequestBody CouponPageRequest couponPageRequest) {
		Result result = new Result();
		result.setData(couponService.getPage(couponPageRequest));
		return result;
	}
	@RequestMapping(path="/getListByStore")
	public Result getListByStore(@RequestParam(name="storeId",defaultValue="0") int storeId) {
		Result result = new Result();
		result.setData(couponService.getListByStore(storeId));
		return result;
	}
	/**
	 * 人工添加优惠券
	 * @return
	 */
	@RequestMapping(path="/create")
	public Result create(@RequestBody CpCoupon cpCoupon) {
		Result result = new Result();
		couponService.createCoupon(cpCoupon);
		return result;
	}
	/**
	 * 人工编辑优惠券
	 * @return
	 */
	@RequestMapping(path="/edit")
	public Result edit(@RequestBody CpCoupon cpCoupon) {
		Result result = new Result();
		couponService.editCoupon(cpCoupon);
		return result;
	}
	/**
	 * 根据ID查询优惠券详情
	 * @return
	 */
	@RequestMapping(path="/getOne")
	public Result getOne(@RequestParam(name="couponId",defaultValue="0") int couponId) {
		Result result = new Result();
		result.setData(couponService.getCoupon(couponId));
		return result;
	}
	
	@RequestMapping(path="/delete")
	public Result delete(@RequestParam(name="couponId",defaultValue="0") int couponId) {
		Result result = new Result();
		couponService.deleteCoupon(couponId);
		return result;
	}

}
