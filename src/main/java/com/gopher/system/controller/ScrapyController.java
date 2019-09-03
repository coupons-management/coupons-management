package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.ScrapyRecordPageRequst;
import com.gopher.system.service.ScrapyService;
import com.gopher.system.service.SpiderService;

@RestController
@RequestMapping(path="/scrapy")
public class ScrapyController {
  
  @Autowired
  private ScrapyService scrapyService;

  @Autowired
  private SpiderService spiderService;

//	@RequestMapping(path="/start")
//	public Result start(@RequestBody  ScrapyPageRequst request) {
//		Result result = new Result();
//		   if(request.getId()==1)
//		   {
//		    String sr=HttpRequest.sendPost("http://18.234.205.204:6800/schedule.json", "project=coupon_spider&spider=offer");
//		    JSONObject jsonObject = JSONObject.parseObject(sr);
//		    Message json = (Message) JSONObject.toJavaObject(jsonObject, Message.class);
//		    if("ok".equals(json.getStatus()))
//		    {
//		    	 System.out.println("=========================================爬虫 offer 启动成功=================================================================");	
//		    }else {
//		    	 System.out.println("=========================================爬虫 offer 启动失败=================================================================");	
//		    }
//		   }else {
//			   
//			String s=HttpRequest.sendPost("http://18.234.205.204:6800/schedule.json", "project=coupon_spider&spider=ccouponchief");
//		    JSONObject couObject = JSONObject.parseObject(s);
//		    Message coujson = (Message) JSONObject.toJavaObject(couObject, Message.class);
//		    if("ok".equals(coujson.getStatus()))
//		    {
//		    	 System.out.println("=========================================爬虫 ccouponchief 启动成功=================================================================");	
//		    }else {
//		    	 System.out.println("=========================================爬虫 ccouponchief 启动失败=================================================================");	
//		    }
//		   }
//		return result;
//	}
//	
//	@RequestMapping(path="/stop")
//	public Result stop(@RequestBody   ScrapyPageRequst request) {
//		Result result = new Result();
//	    String msg=HttpRequest.sendPost("http://18.234.205.204:6800/cancel.json", "project=coupon_spider&job=6487ec79947edab326d6db28a2d86511e8247444");
//	    
//	    JSONObject jsonObject = JSONObject.parseObject(msg);
//	    Message json = (Message) JSONObject.toJavaObject(jsonObject, Message.class);
//	    if("ok".equals(json.getStatus()))
//	    {
//	    	 System.out.println("=========================================爬虫停止成功=================================================================");	
//	    }else {
//	    	 System.out.println("=========================================爬虫停止失败=================================================================");	
//	    }
//		return result;
//	}
  
  @RequestMapping("/getListPage")
  public Result getListPage() {
    Result result = new Result();
    result.setData(scrapyService.getList());
    return result;
  }
  
  @RequestMapping("/setWeight")
  public Result setWeight(Integer id, Integer weight) {
    scrapyService.setWeight(id, weight);
    return new Result();
  }
  
  @RequestMapping("/startScrapy")
  public Result startScrapy(Integer id, String name) {
    Result result = new Result();
    spiderService.start(id, name);
    return result;
  }
  
  @RequestMapping("/stopScrapy")
  public Result stopScrapy(Integer id, String process) {
    Result result = new Result();
    spiderService.stop(id, process);
    return result;
  }

  @RequestMapping("/recordList")
  public Result recordList(ScrapyRecordPageRequst request) {
    Result result = new Result();
    result.setData(scrapyService.getRecordList(request));
    return result;
  }

  @RequestMapping("/lastStoreData")
  public Result lastStoreData(Integer pageNum, String spiderName, String name, String website) {
    Result result = new Result();
    result.setData(scrapyService.getLastStoreList(pageNum, spiderName, name, website));
    return result;
  }

  @RequestMapping("/lastCouponData")
  public Result lastCouponData(Integer pageNum, String spiderName, String name, String type, String isPast) {
    Result result = new Result();
    result.setData(scrapyService.getLastCouponList(pageNum, spiderName, name, type, isPast));
    return result;
  }

  @RequestMapping("/lastCategoryData")
  public Result lastCategoryData(String spiderName, String name) {
    Result result = new Result();
    result.setData(scrapyService.getLastCategoryList(spiderName, name));
    return result;
  }

}


