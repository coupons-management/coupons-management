package com.gopher.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpScrapyRecodeDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.service.SpiderService;
import com.gopher.system.util.HttpRequest;
import com.gopher.system.util.Message;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Date;
import java.util.Objects;

/**
 * 爬虫开启 关闭
 *
 * @author dongyangyang
 */
@Service
public class SpiderServiceImpl implements SpiderService {
    /**
     * 爬虫启动记录
     */
    @Autowired
    private CpScrapyDAO cpScrapyDAO;
    
    @Autowired
    private CpScrapyRecodeDAO cpScrapyRecodeDAO;

    private final static String URL = "http://18.234.205.204:7033";
    
    private final static String URL_LIST = URL + "/listjobs.json";
    private final static String PARAM_LIST_PRE = "project=coupon";
    
    private final static String URL_START = URL + "/schedule.json";
    private final static String PARAM_START_PRE = "project=coupon&spider=";
    
    private final String URL_STOP = URL + "/cancel.json";
    private final String PARAM_STOP_PRE = "project=coupon&job=";

    private void parametervalidator(Integer id, String param) {
      if (id == null || StringUtils.isEmpty(param)) {
        throw new BusinessRuntimeException("请选择爬虫");
      }
    }
    
    @Override
    public void start(Integer id, String spiderName) {
      parametervalidator(id, spiderName);
      sendCmd(id, URL_START, PARAM_START_PRE + spiderName, true, spiderName);
    }

    @Override
    public void stop(Integer id, String job) {
      parametervalidator(id, job);
      sendCmd(id, URL_STOP, PARAM_STOP_PRE + job, false, "");
    }

    private void sendCmd(Integer id, String url, String param, boolean isStart, String spiderName) {
        String msg = HttpRequest.sendPost(url, param);
        Message message = JSON.parseObject(msg, Message.class);
        //操作成功
        if (Objects.equals(message.getStatus(), "ok")) {
          boolean isSuc = updateScrapyState(id, isStart, message.getJobid());
          if(isSuc && isStart){
            Thread thread = new Thread(() -> {
              listenScrapyState(id, message.getJobid(), spiderName);
            });
            thread.start();
          }
          
          //CpScrapyRecode record = new CpSc
//            CpScrapyRecode recode = cpScrapyRecodeDAO.getBeanByScrapyName(spiderName);
//            if (null == recode) {
//                recode = new CpScrapyRecode();
//            }
//            if (Objects.equals(url, URL_START)) {
//                recode.setStartTime(new Date());
//                recode.setProcess(message.getJobid());
//                recode.setStatus("1");
//            } else if (Objects.equals(url, URL_STOP)) {
//                recode.setEndTime(new Date());
//                recode.setStatus("0");
//            }
//            if (null != recode.getId()) {
//                cpScrapyRecodeDAO.updateByPrimaryKeySelective(recode);
//            } else {
//                cpScrapyRecodeDAO.insert(recode);
//            }
        } else {
            throw new BusinessRuntimeException("操作爬虫失败");
        }
    }
    
    //修改爬虫运行状态,新建爬虫记录
    private boolean updateScrapyState(Integer id, boolean isStart, String process){
      CpScrapy scrapy = new CpScrapy();
      scrapy.setId(id);
      scrapy.setIsRunning(isStart?1:0);
      if(isStart){
        scrapy.setProcess(process);
      }
      Integer cnt1 = cpScrapyDAO.updateByPrimaryKeySelective(scrapy);
      
      Integer cnt2 = 0;
      CpScrapyRecode record = new CpScrapyRecode();
      if(isStart){
        record.setScrapyId(id);
        record.setStartTime(new Date());
        record.setProcess(process);
        record.setCreateTime(new Date());
        cnt2 = cpScrapyRecodeDAO.insertSelective(record);
      } else {
        record.setProcess(process);
        record.setEndTime(new Date());
        cnt2 = cpScrapyRecodeDAO.updateRecordByProcess(record);
      }
      return cnt1 > 0 && cnt2 > 0;
    }
    
    /**
     * 启动爬虫后，开始监听爬虫是否结束(10秒一次)，结束后修改爬虫运行状态
     * @param jobId 爬虫进程
     */
    public void listenScrapyState(Integer id, String jobId, String spiderName){
      String msg = HttpRequest.sendGet(URL_LIST, PARAM_LIST_PRE);
      Message message = JSON.parseObject(msg, Message.class);
      if("ok".equals(message.getStatus())){
        JSONArray running = message.getRunning();
        //爬虫停止
        if(isStop(running, jobId)){
          updateScrapyState(id, false, jobId);
        } else {
          try {
            Thread.sleep(10*1000);//10秒请求一次
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          listenScrapyState(id, jobId, spiderName);
        }
      }
    }
    
    private boolean isStop(JSONArray running, String jobId){
      if(running == null || running.isEmpty()){
        return true;
      }
      for (Object obj : running) {
        JSONObject jsonObj = JSONObject.fromObject(obj);
        String id = jsonObj.getString("id");
        if(jobId.equals(id)){
          return false;
        }
      }
      return true;
    }
    
}
