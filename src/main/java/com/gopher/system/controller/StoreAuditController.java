package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.service.CpOutSiteCouponService;
import com.gopher.system.service.StoreAuditService;

@RestController
@RequestMapping(path="/storeAudit")
public class StoreAuditController {
	@Autowired
	private StoreAuditService storeAuditService;
	@Autowired
	private CpOutSiteCouponService cpOutSiteCouponService;
	/**
	 * 增加站点到
	 * @param cpOutSiteStore
	 * @return
	 */
	@RequestMapping(path="/addSite")
	public Result addSite(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		storeAuditService.addSite(cpOutSiteStore);
		//result.setData(storeAuditService.addSite(cpSiteStore));
		return result;
	}
	@RequestMapping(path="/getOutSitleList")
	public Result getOutSitleList(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		result.setData(storeAuditService.getOutSitleList(cpOutSiteStore));
		return result;
	}
	
	/**
	 * 热门商家增加
	 * @param cpOutSiteStore
	 * @return  storeAudit/updateHotSort
	 */
	@RequestMapping(path="/updateHotSort")
	public Result updateHotSort(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		storeAuditService.updateHotSort(cpOutSiteStore);
		return result;
	}
	
	/**
	 * 删除热门商家增加
	 * @param cpOutSiteStore
	 * @return  storeAudit/updateHotSort
	 */
	@RequestMapping(path="/deleteHotSort")
	public Result deleteHotSort(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		storeAuditService.deleteHotSort(cpOutSiteStore);
		return result;
	}
	/**
	 * 增加推荐商家
	 * @param cpOutSiteStore
	 * @return
	 */
	@RequestMapping(path="/updateAdviseSort")
	public Result updateAdviseSort(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		storeAuditService.updateAdviseSort(cpOutSiteStore);
		return result;
	}
	
	/**
	 * 删除推荐商家
	 * @param cpOutSiteStore
	 * @return
	 */
	@RequestMapping(path="/deleteAdviseSort")
	public Result deleteAdviseSort(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		storeAuditService.deleteAdviseSort(cpOutSiteStore);
		return result;
	}
	
	
	
/**
 * 增加热门优惠卷
 * @param cpOutSiteCoupon
 * @return
 */
	@RequestMapping(path="/updateCouponHotSort")
	public Result updateCouponHotSort(@RequestBody CpOutSiteCoupon cpOutSiteCoupon) {
		Result result = new Result();
		cpOutSiteCouponService.updateHotSort(cpOutSiteCoupon);
		
		return result;
	}
	
	/**
	 * 删除热门优惠卷
	 * @param cpOutSiteCoupon
	 * @return
	 */
		@RequestMapping(path="/deleteCouponHotSort")
		public Result deleteCouponHotSort(@RequestBody CpOutSiteCoupon cpOutSiteCoupon) {
			Result result = new Result();
			cpOutSiteCouponService.deleteHotSort(cpOutSiteCoupon);
			//result.setData(storeAuditService.addSite(cpSiteStore));
			return result;
		}
		
	/**
	 * 增加推荐优惠卷
	 * @param cpOutSiteCoupon
	 * @return
	 */
	@RequestMapping(path="/updateCouponAdviseSort")
	public Result updateCouponAdviseSort(@RequestBody CpOutSiteCoupon cpOutSiteCoupon) {
		Result result = new Result();
		cpOutSiteCouponService.updateAdviseSort(cpOutSiteCoupon);
		//result.setData(storeAuditService.addSite(cpSiteStore));
		return result;
	}
	
	/**
	 * 删除推荐优惠卷
	 * @param cpOutSiteCoupon
	 * @return
	 */
	@RequestMapping(path="/deleteCouponAdviseSort")
	public Result deleteCouponAdviseSort(@RequestBody CpOutSiteCoupon cpOutSiteCoupon) {
		Result result = new Result();
		cpOutSiteCouponService.deleteAdviseSort(cpOutSiteCoupon);
		//result.setData(storeAuditService.addSite(cpSiteStore));
		return result;
	}
	/*@RequestMapping(path="/getHotCouponList")
	public Result getHotCouponList(@RequestBody CpOutSiteCoupon cpOutSiteCoupon) {
		Result result = new Result();
		result.setData(cpOutSiteCouponService.getHotList());
		return result;
	}*/
	@RequestMapping(path="/getAdviseCouponList2")
	public Result getAdviseCouponList(@RequestBody CpOutSiteCoupon cpOutSiteCoupon) {
		Result result = new Result();
		result.setData(cpOutSiteCouponService.getAdvisEList());
		return result;
	}
	
	
	
	@RequestMapping(path="/getHotCouponList")
	public Result getHotCouponList(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		result.setData(storeAuditService.getOutSitleHotList(cpOutSiteStore));
		return result;
	}
	@RequestMapping(path="/getAdviseCouponList")
	public Result getAdviseCouponList(@RequestBody CpOutSiteStore cpOutSiteStore) {
		Result result = new Result();
		result.setData(storeAuditService.getOutSitleAdviseList(cpOutSiteStore));
		return result;
	}
}
