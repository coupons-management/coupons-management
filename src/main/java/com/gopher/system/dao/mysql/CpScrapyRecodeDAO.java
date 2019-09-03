package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.model.vo.request.ScrapyRecordPageRequst;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * CpScrapyRecodeDAO继承基类
 */
@Repository
public interface CpScrapyRecodeDAO extends MyBatisBaseDao<CpScrapyRecode, Integer> {
  
	CpScrapyRecode getBeanByScrapyName(String scrapyName);

	Integer updateRecordByProcess(CpScrapyRecode record);
	
	List<CpScrapyRecode> getList(ScrapyRecordPageRequst request);
	
	Integer getListCount(ScrapyRecordPageRequst request);
	
}