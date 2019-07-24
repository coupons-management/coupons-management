package com.gopher.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gopher.system.dao.mysql.*;
import com.gopher.system.model.entity.*;
import com.gopher.system.service.SynDataService;
import com.gopher.system.util.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.*;

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

    @Override
    public void synStoreData() {
        // 1、取得消息数据，只取当天状态为0的数据
        // 2、循环爬虫数据，保存爬取到的商家数
        // 3、建立商家跟站点关系
        // 4、建立商家跟类型关系
        List<TMessage> list = synMessageDataDao.getStoreMessages();
        for (final TMessage message : list) {
            try {
                String objectStr = message.getMessageBody();
                StoreJson stu = JSONObject.parseObject(objectStr, StoreJson.class);
                // 来源站点
                final String sourceUrl = stu.getSourceSite();
                // 商家官网
                final String storeUrl = stu.getFinalWebsite();

                CpInSite site = cpInSiteDAO.getSiteUrl(sourceUrl);
                if (site == null) {
                    site = new CpInSite();
                    if (StringUtils.isNotEmpty(sourceUrl)) {
                        site.setUrl(sourceUrl);
                        site.setName(getName(sourceUrl));
                        site.setLanguage("en");
                    }
                    site.setCreateTime(new Date());
                    cpInSiteDAO.insert(site);
                }
                //增加商家类型
                CpType cpType = cpTypeDAO.getBeanByName(stu.getCategory());
                if (cpType == null) {
                    cpType = new CpType();
                    cpType.setName(stu.getCategory());
                    cpType.setInType("0");
                    cpTypeDAO.insert(cpType);
                }
                // 增加商家
                CpStore cpStore = cpStoreDAO.getBeanByWebSite(storeUrl);
                if (cpStore == null) {
                    cpStore = new CpStore();
                    // 以后做属性拷贝，暂时一个个设值
                    cpStore.setName(stu.getName());
                    cpStore.setWebsite(storeUrl);
                    cpStore.setTitle(stu.getTitle());
                    cpStore.setCountry(stu.getCountry());
                    if (StringUtils.isEmpty(stu.getCouponCount())) {
                        cpStore.setCouponCount(0);
                    } else {
                        cpStore.setCouponCount(Integer.parseInt(stu.getCouponCount()));
                    }
                    cpStore.setLogoUrl(stu.getLogoUrl());
                    cpStore.setDes(stu.getDescription());
                    cpStore.setUuid(stu.getUuid());
                    // 0同步入库 1人工入库
                    cpStore.setInType("0");
                    cpStore.setApproval("0");
                    cpStore.setTypeId(cpType.getId());
                    cpStore.setTypeName(cpType.getName());
                    cpStore.setCreatedAt(DateUtils.getDateTime(stu.getCreatedAt()));
                    cpStore.setCreateTime(new Date());
                    if (StringUtils.isNotEmpty(stu.getName())
                            && StringUtils.isNotEmpty(stu.getFinalWebsite())
                            && StringUtils.isNotEmpty(cpType.getName())
                            && StringUtils.isNotEmpty(stu.getLogoUrl())) {
                        cpStore.setIsComplete("1");
                    } else {
                        cpStore.setIsComplete("0");
                    }
                    cpStoreDAO.insert(cpStore);
                } else {
                    if (!Objects.equals(cpStore.getApproval(), "1")) {
                        //合格的商家不更新
                        Integer weight = DataCacheUtils.scrapyMap.get(stu.getSpiderName());
                        Integer last_weight = DataCacheUtils.scrapyMap.get(cpStore.getLastSpider());
                        // 本次爬虫权重高于上一次 更新数据
                        if (last_weight < weight) {
                            cpStore.setName(stu.getName());
                            cpStore.setWebsite(storeUrl);
                            cpStore.setCountry(stu.getCountry());
                            cpStore.setTitle(stu.getTitle());
                            if (StringUtils.isEmpty(stu.getCouponCount())) {
                                cpStore.setCouponCount(0);
                            } else {
                                cpStore.setCouponCount(Integer.parseInt(stu.getCouponCount()));
                            }
                            cpStore.setLogoUrl(stu.getLogoUrl());
                            cpStore.setDes(stu.getDescription());
                            cpStore.setUuid(stu.getUuid());
                            cpStore.setTypeId(cpType.getId());
                            cpStore.setTypeName(cpType.getName());
                            // 0同步入库 1人工入库
                            cpStore.setInType("0");
                            cpStore.setCreatedAt(DateUtils.getDateTime(stu.getCreatedAt()));
                            cpStore.setUpdateTime(new Date());
                            if (StringUtils.isNotEmpty(stu.getName())
                                    && StringUtils.isNotEmpty(stu.getFinalWebsite())
                                    && StringUtils.isNotEmpty(cpType.getName())
                                    && StringUtils.isNotEmpty(stu.getLogoUrl())) {
                                cpStore.setIsComplete("1");
                            } else {
                                cpStore.setIsComplete("0");
                            }
                            cpStoreDAO.updateByPrimaryKeySelective(cpStore);
                        }
                    }

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
            } catch (Exception e) {
                logger.info(e.getMessage(), e);
            } finally {
                synMessageDataDao.updateStoreMessageStatus(message.getPkId());
            }
        }
    }

    @Override
    public void synCouponData() {
        List<TMessage> list = synMessageDataDao.getCouPonMessages();
        final Date now = new Date();
        for (final TMessage message : list) {
            try {
                String objectStr = message.getMessageBody();
                JSONObject jsonObject = JSONObject.parseObject(objectStr);
                CouPonJson stu = JSONObject.toJavaObject(jsonObject, CouPonJson.class);
                CpType cpType = cpTypeDAO.getBeanByName(stu.getStoreCategory());
                if (cpType == null) {
                    cpType = new CpType();
                    cpType.setName(stu.getStoreCategory());
                    cpType.setInType("0");
                    cpTypeDAO.insert(cpType);
                }
                final String storeUrl = stu.getStoreWebsite();
                final String code = stu.getCode();
                CpStore cpStore = cpStoreDAO.getBeanByWebSite(storeUrl);
                // 2、增加商家
                if (cpStore == null) {
                    cpStore = new CpStore();
                    // 以后做属性拷贝，暂时一个个设值
                    cpStore.setName(stu.getStore());
                    cpStore.setWebsite(storeUrl);
                    cpStore.setCountry(stu.getStoreCountry());
                    cpStore.setLogoUrl(stu.getStorePicture());
                    cpStore.setCreateTime(now);
                    cpStore.setUpdateTime(now);
                    cpStore.setInType("0");
                    cpStore.setTypeName(cpType.getName());
                    cpStore.setTypeId(cpType.getId());
                    if (StringUtils.isNotEmpty(stu.getStore()) && StringUtils.isNotEmpty(stu.getFinalWebsite()) && StringUtils.isNotEmpty(cpType.getName()) && StringUtils.isNotEmpty(stu.getStorePicture())) {
                        cpStore.setIsComplete("1");
                    } else {
                        cpStore.setIsComplete("0");
                    }
                    cpStore.setApproval("0");
                    cpStoreDAO.insert(cpStore);
                }
                // 3、增加优惠卷
                CpCoupon qcpCoupon = new CpCoupon();
                qcpCoupon.setStoreId(cpStore.getId());
                CpCoupon cpCoupon = null;
                if (StringUtils.isNotEmpty(code)) {
                    //code 类型的优惠券 通过code验证是否重复
                    qcpCoupon.setCode(code);
                    cpCoupon = cpCouponDAO.getBeanByCode(qcpCoupon);
                } else {
                    qcpCoupon.setName(stu.getName());
                    cpCoupon = cpCouponDAO.getBeanByName(qcpCoupon);
                }
                Integer weight = DataCacheUtils.scrapyMap.get(stu.getSpiderName());
                final int index = weight * (DataCacheUtils.VALUES - stu.getIndex());
                if (cpCoupon == null) {
                    cpCoupon = new CpCoupon();
                    cpCoupon.setStoreId(cpStore.getId());
                    cpCoupon.setName(stu.getName());
                    cpCoupon.setCode(stu.getCode());
                    final Date expire = stu.getExpire();
                    if (null == expire) {
                        cpCoupon.setExpireAt(DateUtils.getDateTime("2099-01-01"));
                    } else {
                        if (index == 0) {

                        } else {
                            cpCoupon.setExpireAt(stu.getExpire());
                        }
                    }
                    cpCoupon.setFinalWebsite(stu.getFinalWebsite());
                    cpCoupon.setLink(stu.getLink());
                    cpCoupon.setStoreUrl(storeUrl);
                    cpCoupon.setInType("0");
                    cpCoupon.setSiteUrl(stu.getSourceSite());
                    cpCoupon.setScrapy(stu.getSpiderName());
                    cpCoupon.setCouponType(stu.getCouponType());
                    if (stu.getDescription() != null && stu.getDescription().length() < 1000) {
                        cpCoupon.setDes(stu.getDescription());
                    }
                    cpCoupon.setCreateTime(now);
                    cpCoupon.setUpdateTime(now);
                    cpCoupon.setIsPass("0");
                    cpCoupon.setTitle(TitleUtils.getMessage(stu.getName()));
                    cpCoupon.setIndex(index);
                    cpCouponDAO.insert(cpCoupon);
                    this.synOutSiteCoupon(cpStore.getId(), cpCoupon, now);
                } else {
                    cpCoupon.setStoreId(cpStore.getId());
                    cpCoupon.setName(stu.getName());
                    cpCoupon.setCode(stu.getCode());
                    final Date expire = stu.getExpire();
                    if (null == expire) {
                        cpCoupon.setExpireAt(DateUtils.getDateTime("2099-01-01"));
                    } else {
                        if (index == 0) {

                        } else {
                            cpCoupon.setExpireAt(stu.getExpire());
                        }
                    }
                    cpCoupon.setLink(stu.getLink());
                    cpCoupon.setStoreUrl(storeUrl);
                    cpCoupon.setFinalWebsite(stu.getFinalWebsite());
                    cpCoupon.setScrapy(stu.getSpiderName());
                    cpCoupon.setSiteUrl(stu.getSourceSite());
                    cpCoupon.setCouponType(stu.getCouponType());
                    if (stu.getDescription() != null && stu.getDescription().length() < 1000) {
                        cpCoupon.setDes(stu.getDescription());
                    }
                    cpCoupon.setUpdateTime(now);
                    cpCoupon.setIndex(index > cpCoupon.getIndex() ? index : cpCoupon.getIndex());
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
                    cpScrapyStore.setCreateTime(now);
                    cpScrapyStoreDAO.insert(cpScrapyStore);

                }
                // 6、增加站点
                final String siteUrl = stu.getSourceSite();
                CpInSite site = cpInSiteDAO.getSiteUrl(siteUrl);
                if (site == null) {
                    site = new CpInSite();
                    site.setUrl(siteUrl);
                    site.setName(this.getName(siteUrl));
                    site.setCreateTime(now);
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
                CpCouponCensus param = new CpCouponCensus();
                param.setCouponName(cpCoupon.getName());
                param.setScrapyName(cpScrapy.getName());
                param.setStoreId(cpStore.getId());
                CpCouponCensus census = cpCouponCensusDAO.getBean(param);
//                Integer weight = DataCacheUtils.scrapyMap.get(cpScrapy.getName());
//                if (weight == null || weight <= 0) {
//                    weight = 1;
//                }
//                if (census == null) {
//                    census = new CpCouponCensus();
//                    census.setCouponId(cpCoupon.getId());
//                    census.setScrapyId(cpScrapy.getId());
//                    census.setCouponName(cpCoupon.getName());
//                    census.setScrapyName(cpScrapy.getName());
//                    census.setStoreId(cpStore.getId());
//                    census.setSort(weight * (DataCacheUtils.VALUES - stu.getIndex()));
//                    census.setScrapyTime(now);
//                    census.setCreateTime(now);
//                    cpCouponCensusDAO.insert(census);
//                } else {
//                    census.setSort(weight * (DataCacheUtils.VALUES - stu.getIndex()));
//                    census.setScrapyTime(now);
//                    census.setUpdateTime(now);
//                    cpCouponCensusDAO.updateByPrimaryKeySelective(census);
//                }
            } catch (Exception e) {
                logger.info(e.getMessage(), e);
            } finally {
                synMessageDataDao.updateCouPonMessageStatus(message.getPkId());
            }
        }

    }

    /**
     * 初始化模板信息 等
     */
    @PostConstruct
    @Override
    public void initData() {
        List<CpTitleMessage> list = cpTitleMessageDAO.getAllList();
        if (list != null && list.size() > 0) {
            for (CpTitleMessage message : list) {
                if (TitleUtils.messageMap.get(message.getTitle()) == null) {
                    List<String> dataList = new ArrayList<>();
                    dataList.add(message.getMessage());
                    TitleUtils.messageMap.put(message.getTitle(), dataList);
                } else {
                    List<String> dataList = TitleUtils.messageMap.get(message.getTitle());
                    dataList.add(message.getMessage());
                    TitleUtils.messageMap.put(message.getTitle(), dataList);
                }
            }

        }

        List<CpStoreTemplate> tempList = cpStoreTemplateDAO.getList();

        if (tempList != null && tempList.size() > 0) {
            for (CpStoreTemplate message : tempList) {

                if (TitleUtils.storeMessageMap.get(message.getName()) == null) {
                    List<String> dataList = new ArrayList<>();
                    dataList.add(message.getMessage());
                    TitleUtils.storeMessageMap.put(message.getName(), dataList);
                } else {
                    List<String> dataList = TitleUtils.storeMessageMap.get(message.getName());
                    if (dataList == null) continue;
                    dataList.add(message.getMessage());
                    TitleUtils.storeMessageMap.put(message.getName(), dataList);
                }
            }

        }

        //初始化爬虫权重比 0-100
        List<CpScrapy> spiderList = cpScrapyDAO.getList();
        if (null != spiderList) {
            spiderList.forEach(e -> {
                DataCacheUtils.scrapyMap.put(e.getName(), e.getWeight());
            });
        }


    }

    @Autowired
    private CpOutSiteCouponDAO cpOutSiteCouponDAO;
    @Autowired
    private CpOutSiteStoreDAO cpOutSiteStoreDAO;

    /**
     * 同步已经加入展示站点内的优惠券
     */
    private void synOutSiteCoupon(int storeId, CpCoupon cpCoupon, Date now) {
        // 1 通过商家ID 找OUT_SITE_STORE 记录如果有就
        List<CpOutSiteStore> list = cpOutSiteStoreDAO.getListByStore(storeId);
        if (!CollectionUtils.isEmpty(list)) {
            //如果有 同步新增的优惠券到当前这个站点下
            list.forEach(e -> {
                CpOutSiteCoupon cpOutSiteCoupon = new CpOutSiteCoupon();
                cpOutSiteCoupon.setCouponId(cpCoupon.getId());
                cpOutSiteCoupon.setStoreId(storeId);
                cpOutSiteCoupon.setTitle(TitleUtils.getMessage(cpCoupon.getTitle()));
                cpOutSiteCoupon.setCreateTime(now);
                cpOutSiteCoupon.setUpdateTime(now);
                cpOutSiteCoupon.setOutSiteId(e.getOutId());
                cpOutSiteCouponDAO.insert(cpOutSiteCoupon);
            });

        }

    }


    @Override
    public void synTypeData() {
        List<TMessage> list = synMessageDataDao.getScrapyeMessages();
        for (final TMessage message : list) {
            try {
                String objectStr = message.getMessageBody();
                JSONObject jsonObject = JSONObject.parseObject(objectStr);
                CateGoryJson json = JSONObject.toJavaObject(jsonObject, CateGoryJson.class);
                CpType cpType = cpTypeDAO.getBeanByName(json.getName());

                if (cpType == null) {
                    cpType = new CpType();
                    cpType.setInType("0");
                    cpType.setName(json.getName());
                    cpType.setDes(json.getDescription());
                    cpType.setCreateTime(new Date());
                    cpTypeDAO.insert(cpType);
                } else {
                    cpType.setInType("0");
                    cpType.setName(json.getName());
                    cpType.setDes(json.getDescription());
                    cpType.setUpdateTime(new Date());
                    cpTypeDAO.updateByPrimaryKeySelective(cpType);
                }

            } catch (Exception e) {
                logger.info(e.getMessage());
            } finally {
                synMessageDataDao.updateCategoryMessageStatus(message.getPkId());
            }
        }

    }


    private String getName(String url) {
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
        CpScrapyRecode recode = cpScrapyRecodeDAO.getBeanByScrapyName(scrapy);
        if (recode == null) {
            recode = new CpScrapyRecode();
            recode.setStatus("1");
            recode.setScrapyName(scrapy);
            recode.setStartTime(new Date());
            cpScrapyRecodeDAO.insert(recode);
        } else {
            recode.setStatus("1");
            recode.setStartTime(new Date());
            cpScrapyRecodeDAO.updateByPrimaryKey(recode);
        }


    }

    //    private String getUrl(String name) {
//
//        int beginIndex;
//        int endIndex;
//        if (StringUtils.isEmpty(name)) {
//            return "None";
//        }
//        try {
//            if (name.startsWith("https://")) {
//                beginIndex = "https://".length();
//                endIndex = name.substring(beginIndex).indexOf("/");
//                if (endIndex == -1) {
//                    return name.substring(beginIndex);
//                }
//                return name.substring(beginIndex, beginIndex + endIndex);
//            }
//
//            if (name.startsWith("http://")) {
//                beginIndex = "http://".length();
//                endIndex = name.substring(beginIndex).indexOf("/");
//                if (endIndex == -1) {
//                    return name.substring(beginIndex);
//                }
//                if (name.substring(beginIndex).contains("?")) {
//                    endIndex = name.substring(beginIndex).indexOf("?");
//                }
//                return name.substring(beginIndex, endIndex);
//            }
//        } catch (Exception e) {
//            logger.info(e.getMessage(), e);
//        }
//        return name;
//    }
}
