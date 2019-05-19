package com.gopher.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.constant.SystemConstants;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpTypeDAO;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.vo.KV;
import com.gopher.system.service.CommonService;
@Service
public class CommonServiceImpl implements CommonService{
	@Autowired
	private CpScrapyDAO cpScrapyDAO;
	@Autowired
	private CpTypeDAO cpTypeDAO;
	
	@Override
	public List<KV<Integer,String>> getSpiderList(){
		List<CpScrapy> list = cpScrapyDAO.getList();
		List<KV<Integer,String>> result = null;
		if(null != list) {
			result = new ArrayList<>(list.size()+1);
			result.add(new KV<>(0,"全部"));
			for (CpScrapy cp : list) {
				result.add(new KV<>(cp.getId(),cp.getName()));
			}
		}
		return  result;
	}
	
	@Override
	public List<KV<String,String>> getCouponTypeList(){
		List<KV<String,String>> result = new ArrayList<>(3);
		result.add(new KV<>("","全部"));
		result.add(new KV<>("CODE","CODE"));
		result.add(new KV<>("DEAL","DEAL"));
		return  result;
	}
	
	@Override
	public List<KV<String,String>> getCountryDict(){
		List<KV<String,String>> result = new ArrayList<>(2);
		result.add(new KV<>("","全部"));
		result.add(new KV<>("US","美国"));
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
    /**
     * 获取所有爬虫分类
     */
	@Override
	public List<KV<Integer, String>> getTypeList() {
		List<CpType> list = cpTypeDAO.getList();
		List<KV<Integer,String>> result = null;
		if(null != list ) {
			result = new ArrayList<>(list.size()+1);
			result.add(new KV<>(0,"全部"));
			for (CpType cp : list) {
				result.add(new KV<>(cp.getId(),cp.getName()));
			}
		}
		return result;
	}
	/**
	 * 是否有爬虫分类
	 * @return
	 */
	public List<KV<Integer, String>> getHasSpiderTypeDict(){
		List<KV<Integer,String>> result = new ArrayList<>(3);
		result.add(new KV<>(SystemConstants.SPIDER_TYPE_ALL.getValue(),SystemConstants.SPIDER_TYPE_ALL.getDescription()));
		result.add(new KV<>(SystemConstants.SPIDER_TYPE_REQUIRED.getValue(),SystemConstants.SPIDER_TYPE_REQUIRED.getDescription()));
		result.add(new KV<>(SystemConstants.SPIDER_TYPE_NOT_REQUIRED.getValue(),SystemConstants.SPIDER_TYPE_NOT_REQUIRED.getDescription()));
		return result;
	}
	/**
	 * 获取审核状态列表
	 * @return
	 */
	public List<KV<String,String>> getApprovalDict(){
		List<KV<String,String>> result = new ArrayList<>(4);
		result.add(new KV<>("","全部"));
		result.add(new KV<>("0","待审核"));
		result.add(new KV<>("1","合格"));
		result.add(new KV<>("2","不合格"));
		return  result;
	}
}
