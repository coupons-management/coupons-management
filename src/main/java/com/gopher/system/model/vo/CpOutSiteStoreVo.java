package com.gopher.system.model.vo;

import java.util.Date;
import java.util.Map;

public class CpOutSiteStoreVo {
	    private Integer id;
	    
	    /**
	     * 商家名
	     */
	    private String storeName;
	    /**
	     * 商家名官网
	     */
	    private String url;
	    /**
	     * 商家LOGO
	     */
	    private String logo;
	    /**
	     * 在爬虫统计
	     */
	    private String scrapyCount;
	    /**
	     *在爬虫统计
	     */
	    private  Map<String,String>scrapyMap ;
	    /**
	     * 站点分类
	     */
	    private String siteType;
	    
	    /**
	     *有效优惠卷
	     */
	    private String validCount;

	    /**
	     *有效优惠卷
	     */
	    private String addTime;
	    /**
	     *有效优惠卷最后新增时间
	     */
	    private String endTime;
	    
	    
	    
	    
	    
	    
}
