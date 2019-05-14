package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.vo.KV;

public interface CommonService {
	List<KV<Integer,String>> getSpiderList();
	List<KV<String,String>> getCouponTypeList();
	List<KV<Integer,String>> getExpiryList();
}
