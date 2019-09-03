package com.gopher.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mongo.CategoryDAO;
import com.gopher.system.dao.mongo.CouponDAO;
import com.gopher.system.dao.mongo.StoreDAO;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpScrapyRecodeDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.ScrapyRecordPageRequst;
import com.gopher.system.model.vo.response.CpCategoryMongoVo;
import com.gopher.system.model.vo.response.CpCouponMongoVo;
import com.gopher.system.model.vo.response.CpStoreMongoVo;
import com.gopher.system.service.ScrapyService;

@Service
public class ScrapyServiceImpl implements ScrapyService {

  @Autowired
  private CpScrapyDAO cpScrapyDAO;

  @Autowired
  private CpScrapyRecodeDAO cpScrapyRecodeDAO;
  
  @Autowired
  private StoreDAO storeDAO;

  @Autowired
  private CouponDAO couponDAO;

  @Autowired
  private CategoryDAO categoryDAO;
  
  @Override
  public List<CpScrapy> getList() {
    return cpScrapyDAO.getList();
  }

  @Override
  public Integer setWeight(Integer id, Integer weight) {
    if(id == null || weight == null){
      throw new BusinessRuntimeException("请输入权重");
    }
    CpScrapy scrapy = new CpScrapy();
    scrapy.setId(id);
    scrapy.setWeight(weight);
    return cpScrapyDAO.updateByPrimaryKeySelective(scrapy);
  }

  @Override
  public Page<CpScrapyRecode> getRecordList(ScrapyRecordPageRequst request) {
    Page<CpScrapyRecode> result = new Page<>();
    List<CpScrapyRecode> list = cpScrapyRecodeDAO.getList(request);
    result.setTotalCount(cpScrapyRecodeDAO.getListCount(request));
    result.setList(list);
    result.setPageNumber(request.getPageNumber());
    result.setPageSize(request.getPageSize());
    return result;
  }

  @Override
  public Page<CpStoreMongoVo> getLastStoreList(int pageNum, String spiderName, String name, String website) {
    Page<CpStoreMongoVo> result = new Page<>();
    List<CpStoreMongoVo> storeList = storeDAO.getLastStoreList(pageNum, spiderName, name, website);
    result.setTotalCount(storeDAO.getLastStoreCount(pageNum, spiderName, name, website));
    result.setList(storeList);
    result.setPageNumber(pageNum);
    result.setPageSize(10);
    return result;
  }

  @Override
  public Page<CpCouponMongoVo> getLastCouponList(int pageNum, String spiderName, String name, String type, String isPast) {
    Page<CpCouponMongoVo> result = new Page<>();
    List<CpCouponMongoVo> couponList = couponDAO.getLastCouponList(pageNum, spiderName, name, type, isPast);
    result.setTotalCount(couponDAO.getLastCouponCount(spiderName, name, type, isPast));
    result.setList(couponList);
    result.setPageNumber(pageNum);
    result.setPageSize(10);
    return result;
  }

  @Override
  public List<CpCategoryMongoVo> getLastCategoryList(String spiderName, String name) {
    List<CpCategoryMongoVo> categoryList = categoryDAO.getLastCategoryList(spiderName, name);
    return categoryList;
  }

}
