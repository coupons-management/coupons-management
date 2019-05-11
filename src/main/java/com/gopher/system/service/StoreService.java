package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;

public interface StoreService {
	
	Page<StoreResponse> getPage(StorePageRequst storeRequest);

}
