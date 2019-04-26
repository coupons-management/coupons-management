package com.gopher.system.model;

/**
 * 商家
 * @author dongyangyang
 *
 */
public class CpStore  extends BaseModel{
	private static final long serialVersionUID = 1L;
    /**
            * 商家名称
     */
	private String name;
	/**
	 * 商家网站
	 */
	private String website;
	/**
	 * 广告网站地址
	 */
	private String advertising;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 商家名称
	 */
	private String nameCrc;
	/**
	 * 网站CRC
	 */
	private String websiteCrc;
	/**
	 * 优惠券数量
	 */
	private Integer couponCount;
	/**
	 * 有效优惠券数量
	 */
	private Integer couponCountValid;
	/**
	 * 入库方式
	 */
	private String inType;
	/**
	 * 审核方式
	 */
	private String approval;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAdvertising() {
		return this.advertising;
	}

	public void setAdvertising(String advertising) {
		this.advertising = advertising;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNameCrc() {
		return this.nameCrc;
	}

	public void setNameCrc(String nameCrc) {
		this.nameCrc = nameCrc;
	}

	public String getWebsiteCrc() {
		return this.websiteCrc;
	}

	public void setWebsiteCrc(String websiteCrc) {
		this.websiteCrc = websiteCrc;
	}

	public Integer getCouponCount() {
		return this.couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	public Integer getCouponCountValid() {
		return this.couponCountValid;
	}

	public void setCouponCountValid(Integer couponCountValid) {
		this.couponCountValid = couponCountValid;
	}

	public String getInType() {
		return this.inType;
	}

	public void setInType(String inType) {
		this.inType = inType;
	}

	public String getApproval() {
		return this.approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}


}