package com.gopher.system.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpInSiteDAO;
import com.gopher.system.dao.mysql.CpSiteStoreDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpStoreTypeDAO;
import com.gopher.system.dao.mysql.CpTypeDAO;
import com.gopher.system.dao.mysql.StoreMapper;
import com.gopher.system.dao.mysql.SynMessageDataMapper;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpInSite;
import com.gopher.system.model.entity.CpSiteStore;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.CpStoreType;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.entity.TMessage;
import com.gopher.system.service.SynDataService;
import com.gopher.system.util.CateGoryJson;
import com.gopher.system.util.CouPonJson;
import com.gopher.system.util.DateUtils;
import com.gopher.system.util.StoreJson;
@Service
public class SynDataServiceImpl implements SynDataService {
	private final Logger logger = LoggerFactory.getLogger(SynDataServiceImpl.class);

	@Autowired
	SynMessageDataMapper synMessageDataMapper;
	@Autowired
	CpInSiteDAO cpInSiteDAO;
	@Autowired
	CpStoreDAO cpStoreDAO;
	@Autowired
	CpTypeDAO cpTypeDAO;
	@Autowired
	CpStoreTypeDAO  cpStoreTypeDAO;
	@Autowired
	CpSiteStoreDAO cpSiteStoreDAO;
	@Autowired
	CpCouponDAO cpCouponDAO;
	@Autowired
	StoreMapper storeMapper;
	
	ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
			TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(5));

	@Override
	public void synStoreData() {
		//1、取得消息数据，只取当天状态为0的数据
		//2、循环爬虫数据，保存爬取到的商家数
		//3、建立商家跟站点关系
		//4、建立商家跟类型关系
		//5
		try {
			List<TMessage> list = synMessageDataMapper.getStoreMessages();
			for (final TMessage message : list) {
			/*	executor.execute(new Thread(new Runnable() {
					@Override
					public void run() {*/
						
						
						String objectStr = message.getMessageBody();
						JSONObject jsonObject = JSONObject.parseObject(objectStr);
						StoreJson stu = (StoreJson) JSONObject.toJavaObject(jsonObject, StoreJson.class);
						//先加站点
						CpInSite site=new CpInSite();
						CpInSite siteObj=cpInSiteDAO.getSiteByUrl(stu.getWebsite());
						if(siteObj==null)
						{	
						//stu.getWebsite().indexOf("//")
						site.setName(stu.getSite());
						site.setUrl(stu.getWebsite());
						site.setCreateTime(new Date());  
						cpInSiteDAO.insert(site);	
						}else {
							site=siteObj;
							site.setUrl(stu.getWebsite());
							site.setUpdateTime(new Date());
							cpInSiteDAO.updateByPrimaryKey(site);
						}
							
				//增加爬虫
						
						//增加商家
					CpStore cpStore=cpStoreDAO.getBeanByWebSite(stu.getFinalWebsite());
						if(cpStore==null)
						{
						cpStore=new CpStore();
						
						
					    //以后做属性拷贝，暂时一个个设值
					    cpStore.setName(stu.getName());
						cpStore.setWebsite(stu.getFinalWebsite());
						cpStore.setTitle(stu.getTitle());
						cpStore.setCountry(stu.getCountry());
						cpStore.setCouponCount(Integer.parseInt(stu.getCouponCount()));
						cpStore.setLogoUrl(stu.getLogoUrl());
						cpStore.setDes(stu.getDescription());
						cpStore.setUuid(stu.getUuid());
						//0同步入库 1人工入库
						cpStore.setInType("0");
						cpStore.setCreatedAt(DateUtils.getDateTime(stu.getCreatedAt()));
						cpStoreDAO.insert(cpStore);
						//synMessageDataMapper.insertStoreByMessage(stu);
						
						}else {
							 cpStore.setName(stu.getName());
								cpStore.setWebsite(stu.getFinalWebsite());
								cpStore.setCountry(stu.getCountry());
								cpStore.setTitle(stu.getTitle());
								cpStore.setCouponCount(Integer.parseInt(stu.getCouponCount()));
								cpStore.setLogoUrl(stu.getLogoUrl());
								cpStore.setDes(stu.getDescription());
								cpStore.setUuid(stu.getUuid());
								//0同步入库 1人工入库
								cpStore.setInType("0");
								cpStore.setCreatedAt(DateUtils.getDateTime(stu.getCreatedAt()));
								cpStoreDAO.updateByPrimaryKey(cpStore);
						}
						
						
						CpSiteStore cpSiteStore=new CpSiteStore();
						cpSiteStore.setInSiteId(site.getId());
						cpSiteStore.setStoreId(cpStore.getId());
						CpSiteStore siteStore=	cpSiteStoreDAO.getBeanByOutKey(cpSiteStore);
						if(siteStore==null)
						{
						cpSiteStoreDAO.insert(cpSiteStore);
						}
						
						
						
						CpType cpType= cpTypeDAO.getBeanByName(stu.getCategory());
						if(cpType==null)
						{  cpType=new CpType();
						   cpType.setName(stu.getCategory());
						   cpType.setInType("0");
						   cpTypeDAO.insert(cpType);
						   CpStoreType cpStoreType=new CpStoreType();
						   cpStoreType.setStoreId(cpStore.getId());
						   cpStoreType.setTypeId(cpType.getId());
						   cpStoreTypeDAO.insert(cpStoreType);
						   
						}else {
							 CpStoreType cpStoreType=new CpStoreType();
							   cpStoreType.setStoreId(cpStore.getId());
							   cpStoreType.setTypeId(cpType.getId());
							   CpStoreType st=cpStoreTypeDAO.getBeanByOutKey(cpStoreType);
							   if(st==null)
							   {
							   cpStoreTypeDAO.insert(cpStoreType);
							   }
							   
						}
						
						
						
						
						storeMapper.updateStoreMessageStatus(message.getPkId());

						
			/*		}
				}, "name"));*/

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
				
				/*executor.execute(new Thread(new Runnable() {
					@Override
					public void run() {*/
						String objectStr = message.getMessageBody();
						JSONObject jsonObject = JSONObject.parseObject(objectStr);
						CouPonJson stu = (CouPonJson) JSONObject.toJavaObject(jsonObject, CouPonJson.class);
						CpStore cpStore=cpStoreDAO.getBeanByWebSite(stu.getStoreWebsite().trim());
						if(cpStore==null)
						{
							
							cpStore=new CpStore();
							 //以后做属性拷贝，暂时一个个设值
						    cpStore.setName(stu.getStore());
							cpStore.setWebsite(stu.getStoreWebsite());
							cpStore.setCountry(stu.getStoreCountry());
							//cpStore.setCouponCount(Integer.parseInt(stu.getStoreCountry()));
							cpStore.setLogoUrl(stu.getStorePicture());
							//cpStore.setDec(stu.getDescription());
							//cpStore.setUuid(stu.getUuid());
							cpStoreDAO.insert(cpStore);
						}
						CpCoupon qcpCoupon=new CpCoupon();
						qcpCoupon.setStoreId(cpStore.getId());
						qcpCoupon.setName(stu.getName());
						CpCoupon cpCoupon=cpCouponDAO.getBeanByName(qcpCoupon);
						
						if(cpCoupon==null)
						{
						cpCoupon =new CpCoupon();
						cpCoupon.setStoreId(cpStore.getId());
						cpCoupon.setName(stu.getName());
						cpCoupon.setCode(stu.getCode());
						cpCoupon.setExpireAt(stu.getExpire());
						cpCoupon.setFinalWebsite(stu.getFinalWebsite());
						cpCoupon.setLink(stu.getLink());
						cpCoupon.setStoreUrl(stu.getFinalWebsite());
						cpCoupon.setInType("0");
						cpCoupon.setScrapy(stu.getSite());
						cpCoupon.setCouponType(stu.getCouponType());
						cpCouponDAO.insert(cpCoupon);
						}else {
							cpCoupon.setStoreId(cpStore.getId());
							cpCoupon.setName(stu.getName());
							cpCoupon.setCode(stu.getCode());
							cpCoupon.setExpireAt(stu.getExpire());
							cpCoupon.setFinalWebsite(stu.getFinalWebsite());	
						
						cpCouponDAO.updateByPrimaryKey(cpCoupon);	
						}
						
						
						//synMessageDataMapper.insert(stu);
						synMessageDataMapper.updateCouPonMessageStatus(message.getPkId());

				/*	}
				}, "name"));*/

			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

	}

	@Override
	public void synInSiteData() {
		/*try {
			List<TMessageStore> list = storeMapper.getStoreMessages();
			for (TMessageStore message : list) {
				String objectStr = message.getMessageBody();
				JSONObject jsonObject = JSONObject.parseObject(objectStr);
				StoreJson stu = (StoreJson) JSONObject.toJavaObject(jsonObject,
						StoreJson.class);
				storeMapper.insert(stu);
				System.out.println("0000000000000000" + stu.getCouponCount()
						+ "=================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/

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

	@Override
	public void synTypeData() {
		try {

			List<TMessage> list = synMessageDataMapper.getScrapyeMessages();
			for (final TMessage message : list) {
			/*	executor.execute(new Thread(new Runnable() {
					@Override
					public void run() {*/
						String objectStr = message.getMessageBody();
						JSONObject jsonObject = JSONObject
								.parseObject(objectStr);
						CateGoryJson json = (CateGoryJson) JSONObject
								.toJavaObject(jsonObject, CateGoryJson.class);
						//BeanUtils.copyProperties(source, target);
						CpType cpType= cpTypeDAO.getBeanByName(json.getName());
						if(cpType==null)
						{
							cpType=new CpType();
							cpType.setName(json.getName());
							cpType.setDes(json.getDescription());
							cpTypeDAO.insert(cpType);
							//synMessageDataMapper.insertType(type);
						}else {
							
							cpType.setName(json.getName());
							cpType.setDes(json.getDescription());
							cpTypeDAO.updateByPrimaryKey(cpType);
							//synMessageDataMapper.insertType(type);
						}
						
						synMessageDataMapper.updateScMessageStatus(message.getPkId());

				/*	}
				}, "name"));*/

			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

		
	}

}
