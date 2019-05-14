package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.service.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {
	@Autowired
	private CouponService couponService;
	@GetMapping(path="/getPage")
	public Result getPage(CouponPageRequest couponPageRequest) {
		Result result = new Result();
		result.setData(couponService.getPage(couponPageRequest));
		return result;
	}

}
