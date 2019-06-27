package com.gopher.system.worker;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.gopher.system.service.SynDataService;
import com.gopher.system.util.HttpRequest;
import com.gopher.system.util.Message;
import com.gopher.system.util.TitleUtils;
import org.springframework.stereotype.Service;

public class SynBasicsData {
    @Autowired
    private SynDataService synDataService;
    private static final Logger LOGGER = LoggerFactory.getLogger(SpiderStatisticJob.class);


    @SuppressWarnings("unchecked")
    public void synDate() {
//        LOGGER.info("--------------同步数据--------------------");
        //同步类型
        synDataService.synTypeData();
        //同步商家
        synDataService.synStoreData();
        //同步优惠卷
        synDataService.synCouponData();
    }

    @SuppressWarnings("unchecked")
    public void initData() {
        synDataService.initData();
        String messgae = initKeyWords();
        if (StringUtils.isEmpty(messgae)) {
            return;
        }
        String[] messgaes = messgae.split(",", -1);
        for (String me : messgaes) {
            TitleUtils.keyWordsMap.put(me, me);
        }

    }

    //读取keyword消息
    String initKeyWords() {
        Properties properties = new Properties();
        InputStream in = SynBasicsData.class.getClassLoader().getResourceAsStream("keyword.properties");
        try {
            properties.load(in);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return properties.getProperty("keyword");
    }


    @SuppressWarnings("unchecked")
    public void clearDatd() {

        synDataService.clearData();

    }


    @SuppressWarnings("unchecked")
    public void initScrapy() {

        String sr = HttpRequest.sendPost("http://18.234.205.204:6800/schedule.json", "project=coupon_spider&spider=offer");
        JSONObject jsonObject = JSONObject.parseObject(sr);
        Message json = (Message) JSONObject.toJavaObject(jsonObject, Message.class);
        if ("ok".equals(json.getStatus())) {
            System.out.println("=========================================爬虫 offer 启动成功=================================================================");
            synDataService.startScrapy("offer");
        } else {
            System.out.println("=========================================爬虫 offer 启动失败=================================================================");
        }
        String s = HttpRequest.sendPost("http://18.234.205.204:6800/schedule.json", "project=coupon_spider&spider=ccouponchief");
        JSONObject couObject = JSONObject.parseObject(s);
        Message coujson = (Message) JSONObject.toJavaObject(jsonObject, Message.class);
        if ("ok".equals(coujson.getStatus())) {
            System.out.println("=========================================爬虫 ccouponchief 启动成功=================================================================");
        } else {
            System.out.println("=========================================爬虫 ccouponchief 启动失败=================================================================");
        }

        String m = HttpRequest.sendPost("http://18.234.205.204:6800/cancel.json", "project=coupon_spider&job=6487ec79947edab326d6db28a2d86511e8247444");

    }


    @SuppressWarnings("unchecked")
    public void initStopScrapy() {

        String msg = HttpRequest.sendPost("http://18.234.205.204:6800/cancel.json", "project=coupon_spider&job=6487ec79947edab326d6db28a2d86511e8247444");

        JSONObject jsonObject = JSONObject.parseObject(msg);
        Message json = (Message) JSONObject.toJavaObject(jsonObject, Message.class);
        if ("ok".equals(json.getStatus())) {
            System.out.println("=========================================爬虫停止成功=================================================================");
        } else {
            System.out.println("=========================================爬虫停止失败=================================================================");
        }

    }


}
