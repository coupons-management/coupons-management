package com.gopher.coupon.service.impl;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gopher.coupon.dao.StoreMapper;
import com.gopher.coupon.dao.SynMessageDataMapper;
import com.gopher.coupon.service.SynDataService;
import com.gopher.coupon.utils.CateGoryJson;
import com.gopher.coupon.utils.CouPonJson;
import com.gopher.coupon.utils.StoreJson;
import com.gopher.system.model.TMessage;
import com.gopher.system.model.TMessageStore;
@Service
public class SynDataServiceImpl implements SynDataService {
	private final Logger logger = LoggerFactory
			.getLogger(SynDataServiceImpl.class);
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	SynMessageDataMapper synMessageDataMapper;
	ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
			TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(5));

	@Override
	public void synStoreData() {
		try {
			List<TMessageStore> list = storeMapper.getStoreMessages();
			for (final TMessageStore message : list) {
				executor.execute(new Thread(new Runnable() {
					@Override
					public void run() {
						String objectStr = message.getMessageBody();
						JSONObject jsonObject = JSONObject
								.parseObject(objectStr);
						StoreJson stu = (StoreJson) JSONObject.toJavaObject(
								jsonObject, StoreJson.class);
						storeMapper.insert(stu);
						storeMapper.updateStoreMessageStatus(message.getPkId());

					}
				}, "name"));

			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}

	@Override
	public void synCouponData() {
		try {
			List<TMessage> list = synMessageDataMapper.getCouPonMessages();
			for (final TMessage message : list) {
				executor.execute(new Thread(new Runnable() {
					@Override
					public void run() {
						String objectStr = message.getMessageBody();
						JSONObject jsonObject = JSONObject
								.parseObject(objectStr);
						CouPonJson stu = (CouPonJson) JSONObject.toJavaObject(
								jsonObject, CouPonJson.class);
						synMessageDataMapper.insert(stu);
						synMessageDataMapper.updateCouPonMessageStatus(message
								.getPkId());

					}
				}, "name"));

			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

	}

	@Override
	public void synInSiteData() {
		try {
			// List<TMessageStore>list=storeMapper.getStoreMessages();
			List<TMessageStore> list = storeMapper.getStoreMessages();
			for (TMessageStore message : list) {
				String objectStr = message.getMessageBody();
				JSONObject jsonObject = JSONObject.parseObject(objectStr);
				StoreJson stu = (StoreJson) JSONObject.toJavaObject(jsonObject,
						StoreJson.class);
				storeMapper.insert(stu);
				// List<Store> ts = JSONArray.parseArray(me, Store.class);
				System.out.println("0000000000000000" + stu.getCouponCount()
						+ "=================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 同步当天的数据，同步完成后，删除当前信息，到备份表
	@Override
	public void synScrapyData() {
		try {

			List<TMessage> list = synMessageDataMapper.getScrapyeMessages();
			for (final TMessage message : list) {
				executor.execute(new Thread(new Runnable() {
					@Override
					public void run() {
						String objectStr = message.getMessageBody();
						JSONObject jsonObject = JSONObject
								.parseObject(objectStr);
						CateGoryJson json = (CateGoryJson) JSONObject
								.toJavaObject(jsonObject, CateGoryJson.class);
						synMessageDataMapper.insertScrapye(json);
						synMessageDataMapper.updateScMessageStatus(message
								.getPkId());

					}
				}, "name"));

			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

	}

}
