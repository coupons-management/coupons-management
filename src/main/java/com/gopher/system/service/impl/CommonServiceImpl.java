package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.constant.SystemConstants;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.vo.KV;
import com.gopher.system.service.CommonService;
@Service
public class CommonServiceImpl implements CommonService{
	@Autowired
	private CpScrapyDAO cpScrapyDAO;
	@Override
	public List<KV<Integer,String>> getSpiderList(){
		List<CpScrapy> list = cpScrapyDAO.getList();
		List<KV<Integer,String>> result = null;
		if(null != list) {
			result = new ArrayList<>(list.size());
			for (CpScrapy cp : list) {
				result.add(new KV<>(cp.getId(),cp.getName()));
			}
		}
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
		List<KV<Integer,String>> result = new ArrayList<>(3);
		result.add(new KV<>(SystemConstants.EXPIRY_ALL.getValue(),SystemConstants.EXPIRY_ALL.getDescription()));
		result.add(new KV<>(SystemConstants.EXPIRY_EXPERID.getValue(),SystemConstants.EXPIRY_EXPERID.getDescription()));
		result.add(new KV<>(SystemConstants.EXPIRY_NOT.getValue(),SystemConstants.EXPIRY_NOT.getDescription()));
		return  result;
	}
}
