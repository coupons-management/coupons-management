package com.gopher.system.controller;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.response.OutSiteStoreRsp;
import com.gopher.system.service.ShowSiteService;
import com.gopher.system.service.ShowSiteTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/showSiteTwo")
public class ShowSiteTwoController {
    @Autowired
    private ShowSiteTwoService showSiteTwoService;
    @Autowired
    private ShowSiteService showSiteService;

    @RequestMapping(path = "/getList")
    public Result getList() {
        Result result = new Result();
        result.setData(showSiteTwoService.getSiteList());
        return result;
    }

    @RequestMapping(path = "/getTwoList")
    public Result getTwoList(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
        Result result = new Result();
        result.setData(showSiteTwoService.getTwoList(showSiteStoreRequest));
        return result;
    }

    @RequestMapping(path = "/addSiteStore")
    public Result addSiteStore(@RequestBody OutSiteStoreRsp outSiteStore) {
      Result result = new Result();
      showSiteTwoService.addOutSiteStore(outSiteStore);
      return result;
    }
    
    @RequestMapping(path = "/updateSiteStore")
    public Result updateSiteStore(@RequestBody OutSiteStoreRsp outSiteStore) {
        Result result = new Result();
        showSiteTwoService.updateOutSiteStore(outSiteStore);
        return result;
    }

    @RequestMapping(path = "/deleteSiteStore")
    public Result deleteSiteStore(@RequestBody ShowSiteStoreRequest showSiteStoreRequest) {
        Result result = new Result();
        showSiteService.deleteStoreInSite(showSiteStoreRequest);
        return result;
    }

    @RequestMapping(path = "/getCouponList")
    public Result getCouponList(@RequestBody ShowSiteStoreRequest outSiteStore) {
        Result result = new Result();
        result.setData(showSiteTwoService.getCouponList(outSiteStore));
        return result;
    }

    @RequestMapping(path = "/getNewCouponList")
    public Result getNewCouponList(@RequestBody ShowSiteStoreRequest outSiteStore) {
        Result result = new Result();
        result.setData(showSiteTwoService.getNewCouponList(outSiteStore));
        return result;
    }

    @RequestMapping(path = "/getStoreSort")
    public Result getStoreSort(@RequestBody CpSitestoreRequest showSiteStoreRequest) {
        Result result = new Result();
        result.setData(showSiteTwoService.getStoreSort(showSiteStoreRequest));
        return result;
    }


    @RequestMapping(path = "/getSiteStroreById")
    public Result getSiteStroreById(@RequestBody CpOutSiteStore outSiteStore) {
        Result result = new Result();
        result.setData(showSiteTwoService.getSiteStroreById(outSiteStore));
        return result;
    }


}
