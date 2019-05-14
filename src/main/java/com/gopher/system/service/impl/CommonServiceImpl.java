package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gopher.system.model.vo.KV;
import com.gopher.system.service.CommonService;
@Service
public class CommonServiceImpl implements CommonService{
	@Override
	public List<KV<Integer,String>> getSpiderList(){
		List<KV<Integer,String>> result = new ArrayList<>(2);
		result.add(new KV<>(1,"爬虫1"));
		result.add(new KV<>(2,"爬虫2"));
		return  result;
	}
	@Override
	public List<KV<String,String>> getCouponTypeList(){
		List<KV<String,String>> result = new ArrayList<>(2);
		result.add(new KV<>("CODE","CODE"));
		result.add(new KV<>("DEAL","DEAL"));
		return  result;
	}
	
	@Override
	public List<KV<Integer,String>> getExpiryList(){
		List<KV<Integer,String>> result = new ArrayList<>(2);
		result.add(new KV<>(0,"全部"));
		result.add(new KV<>(1,"已过期"));
		result.add(new KV<>(2,"未过期"));
		return  result;
	}
}
