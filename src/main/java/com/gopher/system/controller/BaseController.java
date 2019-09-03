package com.gopher.system.controller;

import com.alibaba.fastjson.JSON;
import com.gopher.system.controller.model.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {
    @RequestMapping("/demo")
    public Result demo(){
        return new Result();
    }

    @RequestMapping("/test")
    public Result test(@RequestBody  Object data){
        System.out.println("----------------:"+JSON.toJSONString(data));
        return new Result();
    }
}
