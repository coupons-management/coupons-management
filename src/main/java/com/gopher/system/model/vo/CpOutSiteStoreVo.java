package com.gopher.system.model.vo;
import java.util.List;
public class CpOutSiteStoreVo {
	/**
	 * 商家ID
	 */
	    private Integer id;
	    private Integer outSiteId;
	    
	    public Integer getOutSiteId() {
			return outSiteId;
		}
		public void setOutSiteId(Integer outSiteId) {
			this.outSiteId = outSiteId;
		}
		
		/**
	     * 商家名
	     */
	    private String storeName;
	    /**
	     * 商家名官网
	     */
	    private String webSite;
	    /**
	     * 商家LOGO
	     */
	    private String logo;
	    /**
	     * 在爬虫统计
	     */
	    private int scrapyCount;
	    /**
	     *在爬虫统计
	     */
	    private  List<String> scrapyList ;
	  
	    /**
	     * 商家分类
	     */
	    private String storeType;
	    
	    /**
	     * 商家分类
	     */
	    private String typeId;
	    /**
	     * 商家分类
	     */
	    private String typeName;
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
	    
	    private int storeId;
	    
	    
		public int getStoreId() {
			return storeId;
		}
		public void setStoreId(int storeId) {
			this.storeId = storeId;
		}
		public String getWebSite() {
			return webSite;
		}
		public void setWebSite(String webSite) {
			this.webSite = webSite;
		}
		public List<String> getScrapyList() {
			return scrapyList;
		}
		public void setScrapyList(List<String> scrapyList) {
			this.scrapyList = scrapyList;
		}
		public String getTypeId() {
			return typeId;
		}
		public void setTypeId(String typeId) {
			this.typeId = typeId;
		}
		public String getTypeName() {
			return typeName;
		}
		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}
		public String getStoreType() {
			return storeType;
		}
		public void setStoreType(String storeType) {
			this.storeType = storeType;
		}
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

		public String getLogo() {
			return logo;
		}
		public void setLogo(String logo) {
			this.logo = logo;
		}
	
		public int getScrapyCount() {
			return scrapyCount;
		}
		public void setScrapyCount(int scrapyCount) {
			this.scrapyCount = scrapyCount;
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
