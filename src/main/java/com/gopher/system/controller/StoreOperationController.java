package com.gopher.system.controller;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.service.StoreOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongyangyang
 * 维护操作(狗屎名字不知道谁起的) 接口
 */
@RestController
@RequestMapping(path="/storeOperation")
public class StoreOperationController {
    @Autowired
    private StoreOperationService storeOperationService;
    @RequestMapping(path="/getPageInSpider")
    public Result getStoreDetail(@RequestBody StorePageRequst storePageRequst){
        Result result = new Result();
        result.setData(storeOperationService.getPageInSpideer(storePageRequst));
        return result;
    }

    @RequestMapping(path="/getPageInSite")
    public Result getPageInSite(@RequestBody StorePageRequst storePageRequst){
        Result result = new Result();
        result.setData(storeOperationService.getPageInSite(storePageRequst));
        return result;
    }
}
