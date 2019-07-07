package com.gopher.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gopher.system.dao.mysql.CpScrapyRecodeDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.service.SpiderService;
import com.gopher.system.util.DateUtils;
import com.gopher.system.util.HttpRequest;
import com.gopher.system.util.Message;
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
    private CpScrapyRecodeDAO cpScrapyRecodeDAO;

    private final String URL_START = "http://18.234.205.204:7033/schedule.json";
    private final String PARAM_START_PRE = "project=coupon&spider=";
    private final String URL_STOP = "http://18.234.205.204:6800/cancel.json";
    private final String PARAM_STOP_PRE = "project=coupon&job=";

    @Override
    public void start(CpScrapyRecode cpScrapyRecode) {
        this.commonValid(cpScrapyRecode);
        final String spider_name = cpScrapyRecode.getSpiderName();
        sendCmd(URL_START, PARAM_START_PRE + spider_name, spider_name);
    }

    private void commonValid(CpScrapyRecode cpScrapyRecode) {
        if (null == cpScrapyRecode) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        if (!StringUtils.hasText(cpScrapyRecode.getSpiderName())) {
            throw new BusinessRuntimeException("爬虫名称不能为空");
        }
    }

    @Override
    public void stop(CpScrapyRecode cpScrapyRecode) {
        this.commonValid(cpScrapyRecode);
        final String spider_name = cpScrapyRecode.getSpiderName();
        final String process = cpScrapyRecode.getProcess();
        if (!StringUtils.hasText(process)) {
            throw new BusinessRuntimeException("爬虫名称不能为空");
        }
        sendCmd(URL_STOP, PARAM_STOP_PRE + process, spider_name);

    }

    private void sendCmd(String url, String param, String spiderName) {
        String msg = HttpRequest.sendPost(url, param);
        Message message = JSON.parseObject(msg, Message.class);
        if (Objects.equals(message.getStatus(), "ok")) {
            //操作成功
            CpScrapyRecode recode = cpScrapyRecodeDAO.getBeanByScrapyName(spiderName);
            if (null == recode) {
                recode = new CpScrapyRecode();
            }
            if (Objects.equals(url, URL_START)) {
                recode.setStartTime(new Date());
                recode.setProcess(message.getJobid());
                recode.setStatus("1");
            } else if (Objects.equals(url, URL_STOP)) {
                recode.setStatus("0");
                recode.setEndTime(new Date());
            }
            if (null != recode.getId()) {
                cpScrapyRecodeDAO.updateByPrimaryKeySelective(recode);
            } else {
                cpScrapyRecodeDAO.insert(recode);
            }
        } else {
            throw new BusinessRuntimeException("操作爬虫失败");
        }
    }
}
