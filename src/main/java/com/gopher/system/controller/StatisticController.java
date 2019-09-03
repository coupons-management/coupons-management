package com.gopher.system.controller;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongyangyang
 * 统计
 */
@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    /**
     * 基础数据下的报表统计
     * @param statisticRequest
     * @return
     */
    @RequestMapping("/spider")
    public Result getStatisticBySpider(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getStatisticBySpider(statisticRequest));
        return result;
    }

    /**
     * 站点下面的报表统计
     * @param statisticRequest
     * @return
     */
    @RequestMapping("/site")
    public Result getStatisticBySite(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getStatisticBySite(statisticRequest));
        return result;
    }

    /**
     * 商家统计 站点的传siteId(必填) 基础数据下面的传spiderId(爬虫筛选 选填)
     * @param statisticRequest
     * @return
     */
    @RequestMapping("/storeStatistic")
    public Result storeStatistic(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getStoreStatistic(statisticRequest));
        return result;
    }

    /**
     * 展示站点下面的 站点统计
     * @param statisticRequest
     * @return
     */
    @RequestMapping("/siteStatistic")
    public Result siteStatistic(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getSiteStatistic(statisticRequest));
        return result;
    }


}
