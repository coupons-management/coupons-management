package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.vo.KV;

public interface CommonService {
	/**
	 * 爬虫站字典
	 * @return
	 */
	List<KV<Integer,String>> getSpiderList();
	/**
	 * 优惠券类型字典
	 * @return
	 */
	List<KV<String,String>> getCouponTypeList();
	/**
	 * 是否过期字典
	 * @return
	 */
	List<KV<Integer,String>> getExpiryList();
	/**
	 * 获取爬虫分类
	 * @return
	 */
	List<KV<Integer,String>> getTypeList();
	/**
	 * 获取是否有爬虫分类字典
	 * @return
	 */
	List<KV<Integer,String>> getHasSpiderTypeDict();
	/**
	 * 获取国家字典
	 * @return
	 */
	List<KV<String,String>> getCountryDict();
	/**
	 * 获取审核状态字典
	 * @return
	 */
	List<KV<String, String>> getApprovalDict();
	/**
	 * 获取信息是否完整字典
	 * @return
	 */
	List<KV<String, String>> getIsComplete();
	
	
}
