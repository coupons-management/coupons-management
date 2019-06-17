package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gopher.system.dao.mysql.CpCouponCensusDAO;
import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpInSiteDAO;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpScrapyRecodeDAO;
import com.gopher.system.dao.mysql.CpScrapyStoreDAO;
import com.gopher.system.dao.mysql.CpSiteStoreDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpStoreTemplateDAO;
import com.gopher.system.dao.mysql.CpTitleMessageDAO;
import com.gopher.system.dao.mysql.CpTypeDAO;
import com.gopher.system.dao.mysql.StoreMapper;
import com.gopher.system.dao.mysql.SynMessageDataDao;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpCouponCensus;
import com.gopher.system.model.entity.CpInSite;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.model.entity.CpScrapyStore;
import com.gopher.system.model.entity.CpSiteStore;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.CpStoreTemplate;
import com.gopher.system.model.entity.CpTitleMessage;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.entity.TMessage;
import com.gopher.system.service.SynDataService;
import com.gopher.system.util.CateGoryJson;
import com.gopher.system.util.CouPonJson;
import com.gopher.system.util.DataCacheUtils;
import com.gopher.system.util.DateUtils;
import com.gopher.system.util.StoreJson;
import com.gopher.system.util.TitleUtils;

@Service
public class SynDataServiceImpl implements SynDataService {
	private final Logger logger = LoggerFactory.getLogger(SynDataServiceImpl.class);

	@Autowired
	SynMessageDataDao synMessageDataDao;
	@Autowired
	CpInSiteDAO cpInSiteDAO;
	@Autowired
	CpStoreDAO cpStoreDAO;
	@Autowired
	CpTypeDAO cpTypeDAO;
	@Autowired
	CpSiteStoreDAO cpSiteStoreDAO;
	@Autowired
	CpCouponDAO cpCouponDAO;
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	CpScrapyDAO cpScrapyDAO;
	@Autowired
	CpCouponCensusDAO cpCouponCensusDAO;
	
	@Autowired
	CpScrapyStoreDAO cpScrapyStoreDAO;
	@Autowired
	CpTitleMessageDAO cpTitleMessageDAO;
	@Autowired
	CpStoreTemplateDAO cpStoreTemplateDAO;
	@Autowired
	CpScrapyRecodeDAO cpScrapyRecodeDAO;
	
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
			List<TMessage> list = synMessageDataDao.getStoreMessages();
			for (final TMessage message : list) {
				/*
				 * executor.execute(new Thread(new Runnable() {
				 * 
				 * @Override public void run() {
				 */

				String objectStr = message.getMessageBody();
				JSONObject jsonObject = JSONObject.parseObject(objectStr);
				StoreJson stu = (StoreJson) JSONObject.toJavaObject(jsonObject, StoreJson.class);
				// 先加爬虫站点
				String siteUrl = getUrl(stu.getSourceSite());
				CpInSite site = cpInSiteDAO.getSiteUrl(siteUrl);
				if (site == null) {
					site = new CpInSite();
					if(StringUtils.isNotEmpty(siteUrl))
					{
						site.setUrl(siteUrl);
						site.setName(getName(siteUrl));
						site.setLanguage("en");
					}
					site.setCreateTime(new Date());
					cpInSiteDAO.insert(site);
				} /*else {
					//名字一样了，修改就没有意义了
					site = siteObj;
					site.setUrl(url);
					site.setUpdateTime(new Date());
					cpInSiteDAO.updateByPrimaryKey(site);
				}*/

				//增加商家类型
				CpType cpType = cpTypeDAO.getBeanByName(stu.getCategory());
				if (cpType == null) {
					cpType = new CpType();
					cpType.setName(stu.getCategory());
					cpType.setInType("0");
					cpTypeDAO.insert(cpType);

				}
				// 增加爬虫

				// 增加商家
				String storeUrl = getUrl(stu.getFinalWebsite());
				CpStore cpStore = cpStoreDAO.getBeanByWebSite(storeUrl);
				if (cpStore == null) {
					cpStore = new CpStore();

					// 以后做属性拷贝，暂时一个个设值
					cpStore.setName(stu.getName());
					cpStore.setWebsite(storeUrl);
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
					cpStore.setCreateTime(new Date());
					if(StringUtils.isNotEmpty(stu.getName())&&StringUtils.isNotEmpty(stu.getFinalWebsite())&&StringUtils.isNotEmpty(cpType.getName())&&StringUtils.isNotEmpty(stu.getLogoUrl()))
					{
						cpStore.setIsComplete("1");	
					}else {
						cpStore.setIsComplete("0");		
					}
					cpStoreDAO.insert(cpStore);
					// synMessageDataMapper.insertStoreByMessage(stu);

				} else {
					cpStore.setName(stu.getName());
					cpStore.setWebsite(storeUrl);
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
					cpStore.setUpdateTime(new Date());
					if(StringUtils.isNotEmpty(stu.getName())&&StringUtils.isNotEmpty(stu.getFinalWebsite())&&StringUtils.isNotEmpty(cpType.getName())&&StringUtils.isNotEmpty(stu.getLogoUrl()))
					{
						cpStore.setIsComplete("1");	
					}else {
						cpStore.setIsComplete("0");		
					}
					cpStoreDAO.updateByPrimaryKeySelective(cpStore);
					
				}
                //修改站点与商家关系
				CpSiteStore cpSiteStore = new CpSiteStore();
				cpSiteStore.setInSiteId(site.getId());
				cpSiteStore.setStoreId(cpStore.getId());
				CpSiteStore siteStore = cpSiteStoreDAO.getBeanByOutKey(cpSiteStore);
				if (siteStore == null) {
					cpSiteStoreDAO.insert(cpSiteStore);
				}

				

				CpScrapy cpScrapy = cpScrapyDAO.getBeanByName(stu.getSpiderName());
				if (cpScrapy == null) {
					cpScrapy = new CpScrapy();
					cpScrapy.setName(stu.getSpiderName());
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

				synMessageDataDao.updateStoreMessageStatus(message.getPkId());

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
			List<TMessage> list = synMessageDataDao.getCouPonMessages();
			for (final TMessage message : list) {

				/*
				 * executor.execute(new Thread(new Runnable() {
				 * 
				 * @Override public void run() {
				 */
				String objectStr = message.getMessageBody();
				JSONObject jsonObject = JSONObject.parseObject(objectStr);
				CouPonJson stu = (CouPonJson) JSONObject.toJavaObject(jsonObject, CouPonJson.class);
				
				
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
				String storeUrl = getUrl(stu.getFinalWebsite());
				CpStore cpStore = cpStoreDAO.getBeanByWebSite(storeUrl);
				// 2、增加商家
				if (cpStore == null) {

					cpStore = new CpStore();
					// 以后做属性拷贝，暂时一个个设值
					cpStore.setName(stu.getStore());
					// cpStore.setWebsite(stu.getStoreWebsite());
					cpStore.setWebsite(storeUrl);
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
					if(StringUtils.isNotEmpty(stu.getStore())&&StringUtils.isNotEmpty(stu.getFinalWebsite())&&StringUtils.isNotEmpty(cpType.getName())&&StringUtils.isNotEmpty(stu.getStorePicture()))
					{
						cpStore.setIsComplete("1");	
					}else {
						cpStore.setIsComplete("0");		
					}
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
					cpCoupon.setStoreUrl(storeUrl);
					cpCoupon.setInType("0");
					cpCoupon.setSiteUrl(stu.getSourceSite());
					cpCoupon.setScrapy(stu.getSpiderName());
					cpCoupon.setCouponType(stu.getCouponType());
					cpCoupon.setDes(stu.getDescription());
					cpCoupon.setCreateTime(new Date());
					cpCoupon.setTitle(TitleUtils.getMessage(stu.getName()));
					cpCouponDAO.insert(cpCoupon);
				} else {
					cpCoupon.setStoreId(cpStore.getId());
					cpCoupon.setName(stu.getName());
					cpCoupon.setCode(stu.getCode());
					cpCoupon.setExpireAt(stu.getExpire());
					cpCoupon.setLink(stu.getLink());
					cpCoupon.setStoreUrl(storeUrl);
					cpCoupon.setFinalWebsite(stu.getFinalWebsite());
					cpCoupon.setScrapy(stu.getSpiderName());
					cpCoupon.setSiteUrl(stu.getSourceSite());
					cpCoupon.setCouponType(stu.getCouponType());
					cpCoupon.setDes(stu.getDescription());
					cpCoupon.setUpdateTime(new Date());
					cpCoupon.setIndex(stu.getIndex());

					cpCoupon.setTitle(TitleUtils.getMessage(stu.getName()));
					cpCouponDAO.updateByPrimaryKeySelective(cpCoupon);
				}
				// 4、增加爬虫

				CpScrapy cpScrapy = cpScrapyDAO.getBeanByName(stu.getSpiderName());
				if (cpScrapy == null) {
					cpScrapy = new CpScrapy();
					cpScrapy.setName(stu.getSpiderName());
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
	
				String siteUrl = getUrl(stu.getSourceSite());
				
				CpInSite site = cpInSiteDAO.getSiteUrl(siteUrl);
				if (site == null) {
					site = new CpInSite();
					site.setUrl(siteUrl);
					site.setName(this.getName(siteUrl));
					site.setCreateTime(new Date());
					//site.setLanguage("e2n");
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
				synMessageDataDao.updateCouPonMessageStatus(message.getPkId());
				
				//CpCouponCensus census=cpCouponCensusDAO.getBeanByCouponId(cpCoupon.getId());
				CpCouponCensus param=new CpCouponCensus();
				param.setCouponName(cpCoupon.getName());
				param.setScrapyName(cpScrapy.getName());
				param.setStoreId(cpStore.getId());
				CpCouponCensus census=cpCouponCensusDAO.getBean(param);
				Integer weight=DataCacheUtils.scrapyMap.get(cpScrapy.getName());
				if(weight==null||weight<=0)
				{
					weight=1;	
				}
				if(census==null)
				{
				census=new CpCouponCensus();
				census.setCouponId(cpCoupon.getId());
				census.setScrapyId(cpScrapy.getId());
				census.setCouponName(cpCoupon.getName());
				census.setScrapyName(cpScrapy.getName());
				census.setStoreId(cpStore.getId());
				//census.setSort(stu.getIndex());
				census.setSort(weight*(DataCacheUtils.VALUES-stu.getIndex()));
				census.setScrapyTime(new Date());
				census.setCreateTime(new Date());
				cpCouponCensusDAO.insert(census);
				}else {
					//census.setSort(stu.getIndex());
					census.setSort(weight*(DataCacheUtils.VALUES-stu.getIndex()));
					census.setScrapyTime(new Date());
					census.setUpdateTime(new Date());
					cpCouponCensusDAO.updateByPrimaryKeySelective(census);
				}

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
		List<CpTitleMessage> list=	cpTitleMessageDAO.getAllList();
		if(list!=null&&list.size()>0)
		{
			for(CpTitleMessage  message:list)
			{
				if(TitleUtils.messageMap.get(message.getTitle())==null)
				{
					List<String>dataList=new ArrayList<String>();
					dataList.add(message.getMessage());
					TitleUtils.messageMap.put(message.getTitle(), dataList);
				}else {
					List<String>dataList=TitleUtils.messageMap.get(message.getTitle());
					dataList.add(message.getMessage());
					TitleUtils.messageMap.put(message.getTitle(), dataList);	
				}
			}
			
		}
		
		List<CpStoreTemplate> tempList=	cpStoreTemplateDAO.getList();
		
		if(tempList!=null&&tempList.size()>0)
		{
			for(CpStoreTemplate  message:tempList)
			{
				
				if(TitleUtils.storeMessageMap.get(message.getName())==null)
				{
					List<String>dataList=new ArrayList<String>();
					dataList.add(message.getMessage());
					TitleUtils.storeMessageMap.put(message.getName(), dataList);
				}else {
					List<String>dataList=TitleUtils.storeMessageMap.get(message.getName());
					if(dataList==null)continue;
					dataList.add(message.getMessage());
					TitleUtils.storeMessageMap.put(message.getName(), dataList);	
				}
			}
			
		}

	}



	@Override
	public void synTypeData() {
		try {

			List<TMessage> list = synMessageDataDao.getScrapyeMessages();
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
					cpTypeDAO.updateByPrimaryKeySelective(cpType);
					// synMessageDataMapper.insertType(type);
				}

				synMessageDataDao.updateCategoryMessageStatus(message.getPkId());

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
		try {
		if (name.startsWith("https://")) {
			beginIndex = "https://".length();
			endIndex = name.substring(beginIndex).indexOf("/");
			if(endIndex==-1)
			{
			return name.substring(beginIndex);
			}
			return name.substring(beginIndex, beginIndex + endIndex);
		}
		
		if (name.startsWith("http://")) {
			beginIndex = "http://".length();
			endIndex = name.substring(beginIndex).indexOf("/");
			if(endIndex==-1)
			{
				return name.substring(beginIndex);
			}
			if(name.substring(beginIndex).contains("?")) {
				endIndex = name.substring(beginIndex).indexOf("?");
			}
			return name.substring(beginIndex, endIndex);
		}
		}catch(Exception e) {
			System.out.println(name);
		}
		
		return name;
	}

	static String getName(String url) {
		if (StringUtils.isEmpty(url)) {
			return null;
		}
		return url.split("\\.", -1)[1];

	}

	@Override
	public void clearData() {
		synMessageDataDao.deleteCategoryMessage();
		synMessageDataDao.deleteCouPonMessages();
		synMessageDataDao.deleteStoreMessage();
		
	}

	@Override
	public void startScrapy(String scrapy) {
		CpScrapyRecode recode=cpScrapyRecodeDAO.getBeanByScrapyName(scrapy);
		if(recode==null)
		{     recode=new CpScrapyRecode();
		      recode.setStatus("1");
		      recode.setScrapyName(scrapy);
		      recode.setStartTime(new Date());
		      cpScrapyRecodeDAO.insert(recode);
		}else {
			   recode.setStatus("1");
			   recode.setStartTime(new Date());
		      cpScrapyRecodeDAO.updateByPrimaryKey(recode);	
		}

		
	}
}
