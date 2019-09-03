package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.request.CouponSortRequest;
import com.gopher.system.model.vo.request.StoreSortRequest;
import com.gopher.system.service.CpOutSiteCouponService;
import com.gopher.system.service.StoreAuditService;

@RestController
@RequestMapping(path = "/storeAudit")
public class StoreAuditController {
    @Autowired
    private StoreAuditService storeAuditService;
    @Autowired
    private CpOutSiteCouponService cpOutSiteCouponService;


    @RequestMapping(path = "/getOutSitleList")
    public Result getOutSitleList(@RequestBody CpOutSiteStore cpOutSiteStore) {
        Result result = new Result();
        result.setData(storeAuditService.getOutSitleList(cpOutSiteStore));
        return result;
    }

    /**
     * 热门商家增加
     *
     * @param storeSortRequest
     * @return storeAudit/updateHotSort
     */
    @RequestMapping(path = "/updateHotSortBatch")
    public Result updateHotSort(@RequestBody StoreSortRequest storeSortRequest) {
        Result result = new Result();
        storeAuditService.updateHotSort(storeSortRequest);
        return result;
    }


    /**
     * 增加推荐商家
     *
     * @param storeSortRequest
     * @return
     */
    @RequestMapping(path = "/updateAdviseSortBatch")
    public Result updateAdviseSort(@RequestBody StoreSortRequest storeSortRequest) {
        Result result = new Result();
        storeAuditService.updateAdviseSort(storeSortRequest);
        return result;
    }



    @RequestMapping(path = "/updateCouponHotSortBatch")
    public Result updateCouponHotSortBatch(@RequestBody CouponSortRequest couponSortRequest) {
        Result result = new Result();
        cpOutSiteCouponService.updateHotSort(couponSortRequest);
        return result;
    }

    /**
     * 增加推荐优惠卷 批量
     *
     * @param couponSortRequest
     * @return
     */
    @RequestMapping(path = "/updateCouponAdviseSortBatch")
    public Result updateCouponAdviseSortBatch(@RequestBody CouponSortRequest couponSortRequest) {
        Result result = new Result();
        cpOutSiteCouponService.updateAdviseSort(couponSortRequest);
        return result;
    }


    /**
     * 热门商家前10
     *
     * @param cpOutSiteStore
     * @return storeAudit/updateHotSort
     */
    @RequestMapping(path = "/getTopHotStroreList")
    public Result topHotSort(@RequestBody CpOutSiteStore cpOutSiteStore) {
        Result result = new Result();
        result.setData(storeAuditService.getTopHotStoreList(cpOutSiteStore));
        return result;
    }


    /**
     * 查询进站推荐商家前10
     *
     * @param cpOutSiteStore
     * @return
     */
    @RequestMapping(path = "/getTopAdviseStroreList")
    public Result getTopAdviseStroreList(@RequestBody CpOutSiteStore cpOutSiteStore) {
        Result result = new Result();
        result.setData(storeAuditService.getTopAdviseStroreList(cpOutSiteStore));
        return result;
    }


    @RequestMapping(path = "/getTopHotCouponList")
    public Result getTopHotCouponList(@RequestBody CpOutSiteCoupon obj) {
        Result result = new Result();
        result.setData(cpOutSiteCouponService.getTopHotList(obj));
        return result;
    }


    @RequestMapping(path = "/getTopAdviseCouponList")
    public Result getTopAdviseCouponList(@RequestBody CpOutSiteCoupon obj) {
        Result result = new Result();
        result.setData(cpOutSiteCouponService.getTopAdviseList(obj));
        return result;
    }
}
