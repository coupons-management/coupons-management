package com.gopher.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.service.ShowSiteTwoService;

@RestController
@RequestMapping(path="/showSiteTwo")
public class ShowSiteTwoController {
	@Autowired
	private ShowSiteTwoService showSiteTwoService;
	
	@RequestMapping(path="/getList")
	public Result getList(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		result.setData(showSiteTwoService.getSiteList());
		return result;
	}
	
/*	@RequestMapping(path="/getStoreSort")
	public Result getStoreSort(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		result.setData(showSiteTwoService.getSiteList());
		return result;
	}
*/
	
	@RequestMapping(path="/addStoreToSiteBatch")
	public Result addSiteStore(@RequestBody List<ShowSiteStoreRequest> showSiteStoreList) {
		Result result = new Result();
		showSiteTwoService.addStoreToSiteBatch(showSiteStoreList);
		return result;
	}
	@RequestMapping(path="/addStoreToSite")
	public Result addSiteStoreBatch(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		showSiteTwoService.addStoreToSite(showSiteStoreRequest);
		return result;
	}
	
	@RequestMapping(path="/deleteStoreToSite")
	public Result addSiteStore(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		showSiteTwoService.deleteStoreInSite(showSiteStoreRequest);;
		return result;
	}
	
	
	
	
	@RequestMapping(path="/getTwoList")
	public Result getTwoList(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
		Result result = new Result();
		result.setData(showSiteTwoService.getTwoList(showSiteStoreRequest));
		return result;
	}
	
	@RequestMapping(path="/updateSiteStore")
	public Result updateSiteStore(@RequestBody CpOutSiteStore outSiteStore) {
		Result result = new Result();
		showSiteTwoService.updateOutSiteStore(outSiteStore);
		return result;
	}
	@RequestMapping(path="/deleteSiteStore")
	public Result deleteSiteStore(@RequestBody CpOutSiteStore outSiteStore) {
		Result result = new Result();
		showSiteTwoService.deleteOutSiteStore(outSiteStore);
		return result;
	}
	
	@RequestMapping(path="/getCouponList")
	public Result getCouponList(@RequestBody ShowSiteStoreRequest outSiteStore) {
		Result result = new Result();
		result.setData(showSiteTwoService.getCouponList(outSiteStore));
		return result;
	}
	
	@RequestMapping(path="/getNewCouponList")
	public Result getNewCouponList(@RequestBody ShowSiteStoreRequest outSiteStore) {
		Result result = new Result();
		result.setData(showSiteTwoService.getNewCouponList(outSiteStore));
		return result;
	}
	@RequestMapping(path="/getStoreSort")
	public Result getStoreSort(@RequestBody CpSitestoreRequest showSiteStoreRequest) {
		Result result = new Result();
		result.setData(showSiteTwoService.getStoreSort(showSiteStoreRequest));
		return result;
	}
	
	
	@RequestMapping(path="/getSiteStroreById")
	public Result getSiteStroreById(@RequestBody CpOutSiteStore outSiteStore) {
		Result result = new Result();
		result.setData(showSiteTwoService.getSiteStroreById(outSiteStore));
		return result;
	}
	
	@RequestMapping(path="/addCoupon")
	public Result addCoupon(@RequestBody CpCoupon bean) {
		Result result = new Result();
		showSiteTwoService.addCoupon(bean);
		return result;
	}
	
}
