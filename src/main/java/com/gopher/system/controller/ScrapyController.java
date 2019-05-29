package com.gopher.system.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.ScrapyPageRequst;
import com.gopher.system.util.HttpRequest;
import com.gopher.system.util.Message;

@RestController
@RequestMapping(path="/scrapy")
public class ScrapyController {
	
	@RequestMapping(path="/start")
	public Result start(@RequestBody  ScrapyPageRequst request) {
		Result result = new Result();
		   if(request.getId()==1)
		   {
		    String sr=HttpRequest.sendPost("http://18.234.205.204:6800/schedule.json", "project=coupon_spider&spider=offer");
		    JSONObject jsonObject = JSONObject.parseObject(sr);
		    Message json = (Message) JSONObject.toJavaObject(jsonObject, Message.class);
		    if("ok".equals(json.getStatus()))
		    {
		    	 System.out.println("=========================================爬虫 offer 启动成功=================================================================");	
		    }else {
		    	 System.out.println("=========================================爬虫 offer 启动失败=================================================================");	
		    }
		   }else {
			   
			String s=HttpRequest.sendPost("http://18.234.205.204:6800/schedule.json", "project=coupon_spider&spider=ccouponchief");
		    JSONObject couObject = JSONObject.parseObject(s);
		    Message coujson = (Message) JSONObject.toJavaObject(couObject, Message.class);
		    if("ok".equals(coujson.getStatus()))
		    {
		    	 System.out.println("=========================================爬虫 ccouponchief 启动成功=================================================================");	
		    }else {
		    	 System.out.println("=========================================爬虫 ccouponchief 启动失败=================================================================");	
		    }
		   }
		return result;
	}
	
	@RequestMapping(path="/stop")
	public Result stop(@RequestBody   ScrapyPageRequst request) {
		Result result = new Result();
	    String msg=HttpRequest.sendPost("http://18.234.205.204:6800/cancel.json", "project=coupon_spider&job=6487ec79947edab326d6db28a2d86511e8247444");
	    
	    JSONObject jsonObject = JSONObject.parseObject(msg);
	    Message json = (Message) JSONObject.toJavaObject(jsonObject, Message.class);
	    if("ok".equals(json.getStatus()))
	    {
	    	 System.out.println("=========================================爬虫停止成功=================================================================");	
	    }else {
	    	 System.out.println("=========================================爬虫停止失败=================================================================");	
	    }
		return result;
	}
	
	

}


