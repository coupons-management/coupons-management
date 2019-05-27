package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StoreAllPageRequst;

public interface ScrapyStoreService {
	Page<StoreAllPageRequst> getScrapyPageList(StoreAllPageRequst storeAllPageRequst);
	

}
