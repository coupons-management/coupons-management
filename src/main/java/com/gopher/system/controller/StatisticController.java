package com.gopher.system.controller;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    @RequestMapping("/spider")
    public Result getStatistic(@RequestBody StatisticRequest statisticRequest) {
        Result result = new Result();
        result.setData(statisticService.getStatistic(statisticRequest));
        return result;
    }

}
