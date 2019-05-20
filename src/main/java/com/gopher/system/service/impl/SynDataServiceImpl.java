package com.gopher.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpInSiteDAO;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpScrapyStoreDAO;
import com.gopher.system.dao.mysql.CpSiteStoreDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpStoreTypeDAO;
import com.gopher.system.dao.mysql.CpTypeDAO;
import com.gopher.system.dao.mysql.StoreMapper;
import com.gopher.system.dao.mysql.SynMessageDataMapper;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpInSite;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpScrapyStore;
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
	CpStoreTypeDAO cpStoreTypeDAO;
	@Autowired
	CpSiteStoreDAO cpSiteStoreDAO;
	@Autowired
	CpCouponDAO cpCouponDAO;
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	CpScrapyDAO cpScrapyDAO;

	@Autowired
	CpScrapyStoreDAO cpScrapyStoreDAO;

	ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
			new LinkedBlockingDeque<Runnable>(5));

	@Override
	public void synStoreData() {
		// 1、取得消息数据，只取当天状态为0的数据
		// 2、循环爬虫数据，保存爬取到的商家数
		// 3、建立商家跟站点关系
		// 4、建立商家跟类型关系
		// 5
		try {
			List<TMessage> list = synMessageDataMapper.getStoreMessages();
			for (final TMessage message : list) {
				/*
				 * executor.execute(new Thread(new Runnable() {
				 * 
				 * @Override public void run() {
				 */

				String objectStr = message.getMessageBody();
				JSONObject jsonObject = JSONObject.parseObject(objectStr);
				StoreJson stu = (StoreJson) JSONObject.toJavaObject(jsonObject, StoreJson.class);
				// 先加站点
			
				//String url = getUrl(stu.getWebsite());
				CpInSite site = cpInSiteDAO.getSiteName(stu.getSite());
				if (site == null) {
					site = new CpInSite();
					site.setUrl(stu.getSite());
					site.setName(stu.getSite());
					site.setCreateTime(new Date());
					cpInSiteDAO.insert(site);
				} /*else {
					//名字一样了，修改就没有意义了
					site = siteObj;
					site.setUrl(url);
					site.setUpdateTime(new Date());
					cpInSiteDAO.updateByPrimaryKey(site);
				}*/

				
				CpType cpType = cpTypeDAO.getBeanByName(stu.getCategory());
				if (cpType == null) {
					cpType = new CpType();
					cpType.setName(stu.getCategory());
					cpType.setInType("0");
					cpTypeDAO.insert(cpType);

				}
				// 增加爬虫

				// 增加商家
				CpStore cpStore = cpStoreDAO.getBeanByWebSite(stu.getFinalWebsite());
				if (cpStore == null) {
					cpStore = new CpStore();

					// 以后做属性拷贝，暂时一个个设值
					cpStore.setName(stu.getName());
					cpStore.setWebsite(stu.getFinalWebsite());
					cpStore.setTitle(stu.getTitle());
					cpStore.setCountry(stu.getCountry());
					cpStore.setCouponCount(Integer.parseInt(stu.getCouponCount()));
					cpStore.setLogoUrl(stu.getLogoUrl());
					cpStore.setDes(stu.getDescription());
					cpStore.setUuid(stu.getUuid());
					// 0同步入库 1人工入库
					cpStore.setInType("0");
					cpStore.setTypeId(cpType.getId());
					cpStore.setTypeName(cpType.getName());
					cpStore.setCreatedAt(DateUtils.getDateTime(stu.getCreatedAt()));
					cpStoreDAO.insert(cpStore);
					// synMessageDataMapper.insertStoreByMessage(stu);

				} else {
					cpStore.setName(stu.getName());
					cpStore.setWebsite(stu.getFinalWebsite());
					cpStore.setCountry(stu.getCountry());
					cpStore.setTitle(stu.getTitle());
					cpStore.setCouponCount(Integer.parseInt(stu.getCouponCount()));
					cpStore.setLogoUrl(stu.getLogoUrl());
					cpStore.setDes(stu.getDescription());
					cpStore.setUuid(stu.getUuid());
					cpStore.setTypeId(cpType.getId());
					cpStore.setTypeName(cpType.getName());
					// 0同步入库 1人工入库
					cpStore.setInType("0");
					cpStore.setCreatedAt(DateUtils.getDateTime(stu.getCreatedAt()));
					cpStoreDAO.updateByPrimaryKey(cpStore);
				}

				CpSiteStore cpSiteStore = new CpSiteStore();
				cpSiteStore.setInSiteId(site.getId());
				cpSiteStore.setStoreId(cpStore.getId());
				CpSiteStore siteStore = cpSiteStoreDAO.getBeanByOutKey(cpSiteStore);
				if (siteStore == null) {
					cpSiteStoreDAO.insert(cpSiteStore);
				}

				

				CpScrapy cpScrapy = cpScrapyDAO.getBeanByName(stu.getSite());
				if (cpScrapy == null) {
					cpScrapy = new CpScrapy();
					cpScrapy.setName(stu.getSite());
					cpScrapy.setCreateTime(new Date());
					cpScrapyDAO.insert(cpScrapy);
				}

				CpScrapyStore scrapyStore = new CpScrapyStore();
				scrapyStore.setStoreId(cpStore.getId());
				scrapyStore.setScrapyId(cpScrapy.getId());
				CpScrapyStore cpScrapyStore = cpScrapyStoreDAO.selectByOutKey(scrapyStore);
				if (cpScrapyStore == null) {
					cpScrapyStore = new CpScrapyStore();
					cpScrapyStore.setScrapyId(cpScrapy.getId());
					cpScrapyStore.setStoreId(cpStore.getId());
					cpScrapyStore.setCreateTime(new Date());
					cpScrapyStoreDAO.insert(cpScrapyStore);

				}

				storeMapper.updateStoreMessageStatus(message.getPkId());

				/*
				 * } }, "name"));
				 */

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

				/*
				 * executor.execute(new Thread(new Runnable() {
				 * 
				 * @Override public void run() {
				 */
				String objectStr = message.getMessageBody();
				JSONObject jsonObject = JSONObject.parseObject(objectStr);
				CouPonJson stu = (CouPonJson) JSONObject.toJavaObject(jsonObject, CouPonJson.class);
				CpStore cpStore = cpStoreDAO.getBeanByWebSite(stu.getStoreWebsite().trim());
				
				// 1、增加类型与商家关系
			/*	CpStoreType cpStoreType = new CpStoreType();
				cpStoreType.setStoreId(cpStore.getId());
				cpStoreType.setTypeId(cpType.getId());
				CpStoreType st = cpStoreTypeDAO.getBeanByOutKey(cpStoreType);
				if (st == null) {
					cpStoreTypeDAO.insert(cpStoreType);
				}*/
				
				CpType cpType = cpTypeDAO.getBeanByName(stu.getStoreCategory());
				if (cpType == null) {
					cpType = new CpType();
					cpType.setName(stu.getStoreCategory());
					cpType.setInType("0");
					cpTypeDAO.insert(cpType);

				}
				
				// 2、增加商家
				if (cpStore == null) {

					cpStore = new CpStore();
					// 以后做属性拷贝，暂时一个个设值
					cpStore.setName(stu.getStore());
					// cpStore.setWebsite(stu.getStoreWebsite());
					cpStore.setWebsite(stu.getFinalWebsite());
					cpStore.setCountry(stu.getStoreCountry());
					// cpStore.setCouponCount(1);
					cpStore.setLogoUrl(stu.getStorePicture());
					cpStore.setCreateTime(new Date());
					// cpStore.setDec(stu.getDescription());
					// cpStore.setUuid(stu.getUuid());
					cpStore.setInType("0");
					cpStore.setTypeName(cpType.getName());
					cpStore.setTypeId(cpType.getId());
					// cpStore.setCreatedAt(DateUtils.getDateTime(stu.getCreatedAt()));
					cpStoreDAO.insert(cpStore);
				}

			

				

				// 3、增加优惠卷
				CpCoupon qcpCoupon = new CpCoupon();
				qcpCoupon.setStoreId(cpStore.getId());
				qcpCoupon.setName(stu.getName());
				CpCoupon cpCoupon = cpCouponDAO.getBeanByName(qcpCoupon);

				if (cpCoupon == null) {
					cpCoupon = new CpCoupon();
					cpCoupon.setStoreId(cpStore.getId());
					cpCoupon.setName(stu.getName());
					cpCoupon.setCode(stu.getCode());
					cpCoupon.setExpireAt(stu.getExpire());
					cpCoupon.setFinalWebsite(stu.getFinalWebsite());
					cpCoupon.setLink(stu.getLink());
					cpCoupon.setStoreUrl(stu.getFinalWebsite());
					cpCoupon.setInType("0");
					cpCoupon.setSiteUrl(stu.getSite());
					cpCoupon.setScrapy(stu.getSite());
					cpCoupon.setCouponType(stu.getCouponType());
					cpCoupon.setCreateTime(new Date());
					cpCouponDAO.insert(cpCoupon);
				} else {
					cpCoupon.setStoreId(cpStore.getId());
					cpCoupon.setName(stu.getName());
					cpCoupon.setCode(stu.getCode());
					cpCoupon.setExpireAt(stu.getExpire());
					cpCoupon.setLink(stu.getLink());
					cpCoupon.setStoreUrl(stu.getFinalWebsite());
					cpCoupon.setFinalWebsite(stu.getFinalWebsite());
					cpCoupon.setScrapy(stu.getSite());
					cpCoupon.setSiteUrl(stu.getSite());
					cpCoupon.setCouponType(stu.getCouponType());
					cpCoupon.setUpdateTime(new Date());
					cpCouponDAO.updateByPrimaryKey(cpCoupon);
				}
				// 4、增加爬虫

				CpScrapy cpScrapy = cpScrapyDAO.getBeanByName(stu.getSite());
				if (cpScrapy == null) {
					cpScrapy = new CpScrapy();
					cpScrapy.setName(stu.getSite());
					cpScrapy.setCreateTime(new Date());
					cpScrapyDAO.insert(cpScrapy);
				}

				// 5、增加爬虫商家关系
				CpScrapyStore scrapyStore = new CpScrapyStore();
				scrapyStore.setStoreId(cpStore.getId());
				scrapyStore.setScrapyId(cpScrapy.getId());
				CpScrapyStore cpScrapyStore = cpScrapyStoreDAO.selectByOutKey(scrapyStore);
				if (cpScrapyStore == null) {
					cpScrapyStore = new CpScrapyStore();
					cpScrapyStore.setScrapyId(cpScrapy.getId());
					cpScrapyStore.setStoreId(cpStore.getId());
					cpScrapyStore.setCreateTime(new Date());
					cpScrapyStoreDAO.insert(cpScrapyStore);

				}

				// 6、增加站点
	
				//String url = getUrl(stu.getStoreWebsite());
				CpInSite site = cpInSiteDAO.getSiteName(stu.getSite());
				if (site == null) {
					site = new CpInSite();
					site.setUrl(stu.getSite());
					site.setName(stu.getSite());
					site.setCreateTime(new Date());
					cpInSiteDAO.insert(site);
				}

				// 7、增加站点商家关系
				CpSiteStore cpSiteStore = new CpSiteStore();
				cpSiteStore.setInSiteId(site.getId());
				cpSiteStore.setStoreId(cpStore.getId());
				CpSiteStore siteStore = cpSiteStoreDAO.getBeanByOutKey(cpSiteStore);
				if (siteStore == null) {
					cpSiteStoreDAO.insert(cpSiteStore);
				}

				// synMessageDataMapper.insert(stu);
				synMessageDataMapper.updateCouPonMessageStatus(message.getPkId());

				/*
				 * } }, "name"));
				 */

			}
		} catch (Exception e) {
			logger.debug(e.getMessage(),e);
		}

	}

	@Override
	public void initData() {
		/*
		 * try { List<TMessageStore> list = storeMapper.getStoreMessages(); for
		 * (TMessageStore message : list) { String objectStr = message.getMessageBody();
		 * JSONObject jsonObject = JSONObject.parseObject(objectStr); StoreJson stu =
		 * (StoreJson) JSONObject.toJavaObject(jsonObject, StoreJson.class);
		 * storeMapper.insert(stu); System.out.println("0000000000000000" +
		 * stu.getCouponCount() + "================="); } } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

	}

	// 同步当天的数据，同步完成后，删除当前信息，到备份表
	/*@Override
	public void synScrapyData() {
		try {

			List<TMessage> list = synMessageDataMapper.getScrapyeMessages();
			for (final TMessage message : list) {
				executor.execute(new Thread(new Runnable() {
					@Override
					public void run() {
						String objectStr = message.getMessageBody();
						JSONObject jsonObject = JSONObject.parseObject(objectStr);
						CateGoryJson json = (CateGoryJson) JSONObject.toJavaObject(jsonObject, CateGoryJson.class);
						synMessageDataMapper.insertScrapye(json);
						synMessageDataMapper.updateScMessageStatus(message.getPkId());

					}
				}, "name"));

			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

	}*/

	@Override
	public void synTypeData() {
		try {

			List<TMessage> list = synMessageDataMapper.getScrapyeMessages();
			for (final TMessage message : list) {
				/*
				 * executor.execute(new Thread(new Runnable() {
				 * 
				 * @Override public void run() {
				 */
				String objectStr = message.getMessageBody();
				JSONObject jsonObject = JSONObject.parseObject(objectStr);
				CateGoryJson json = (CateGoryJson) JSONObject.toJavaObject(jsonObject, CateGoryJson.class);
				// BeanUtils.copyProperties(source, target);
				CpType cpType = cpTypeDAO.getBeanByName(json.getName());

				if (cpType == null) {
					cpType = new CpType();
					cpType.setInType("0");
					cpType.setName(json.getName());
					cpType.setDes(json.getDescription());
					cpType.setCreateTime(new Date());
					cpTypeDAO.insert(cpType);
					// synMessageDataMapper.insertType(type);
				} else {
					cpType.setInType("0");
					cpType.setName(json.getName());
					cpType.setDes(json.getDescription());
					cpType.setUpdateTime(new Date());
					cpTypeDAO.updateByPrimaryKey(cpType);
					// synMessageDataMapper.insertType(type);
				}

				synMessageDataMapper.updateScMessageStatus(message.getPkId());

				/*
				 * } }, "name"));
				 */

			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

	}

	static String getUrl(String name) {
		int beginIndex = 0;
		int endIndex = 0;
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		if (name.startsWith("https://")) {
			beginIndex = "https://".length();
			endIndex = name.substring(beginIndex).indexOf("/");
			return name.substring(beginIndex, beginIndex + endIndex);
		}
		
		if (name.startsWith("http://")) {
			beginIndex = "http://".length();
			endIndex = name.substring(beginIndex).indexOf("/");
			if(name.substring(beginIndex).contains("?")) {
				endIndex = name.substring(beginIndex).indexOf("?");
			}
			return name.substring(beginIndex, endIndex);
		}
		return null;
	}

	static String getName(String url) {
		if (StringUtils.isEmpty(url)) {
			return null;
		}
		return url.split("\\.", -1)[1];

	}
}
