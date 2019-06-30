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

    @RequestMapping("/spider")
    public Result getStatisticBySpider(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getStatisticBySpider(statisticRequest));
        return result;
    }

    @RequestMapping("/storeStatistic")
    public Result storeStatistic(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getStoreStatistic(statisticRequest));
        return result;
    }

    @RequestMapping("/site")
    public Result getStatisticBySite(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getStatisticBySite(statisticRequest));
        return result;
    }

    @RequestMapping("/siteStatistic")
    public Result siteStatistic(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getSiteStatistic(statisticRequest));
        return result;
    }
}
