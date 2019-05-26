package com.gopher.system.model.vo;
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
	    private int validCount;
	    /**
	     *总的优惠卷
	     */
	    private int toalCount;
	    /**
	     *显示比例
	     */
	    private String showCount;

	    /**
	     *新增时间
	     */
	    private String addTime;
	    /**
	     *有效优惠卷最后新增时间
	     */
	    private String endTime;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getLogo() {
			return logo;
		}
		public void setLogo(String logo) {
			this.logo = logo;
		}
		public String getScrapyCount() {
			return scrapyCount;
		}
		public void setScrapyCount(String scrapyCount) {
			this.scrapyCount = scrapyCount;
		}
		public Map<String, String> getScrapyMap() {
			return scrapyMap;
		}
		public void setScrapyMap(Map<String, String> scrapyMap) {
			this.scrapyMap = scrapyMap;
		}
		public String getSiteType() {
			return siteType;
		}
		public void setSiteType(String siteType) {
			this.siteType = siteType;
		}
	
		public int getValidCount() {
			return validCount;
		}
		public void setValidCount(int validCount) {
			this.validCount = validCount;
		}
		public int getToalCount() {
			return toalCount;
		}
		public void setToalCount(int toalCount) {
			this.toalCount = toalCount;
		}
		public String getShowCount() {
			return showCount;
		}
		public void setShowCount(String showCount) {
			this.showCount = showCount;
		}
		public String getAddTime() {
			return addTime;
		}
		public void setAddTime(String addTime) {
			this.addTime = addTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
	    
	    
	    
	    
	    
	    
}
