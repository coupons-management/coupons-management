package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StoreRequest;
import com.gopher.system.model.vo.response.StoreResponse;

public interface StoreService {
	
	Page<StoreResponse> getPage(StoreRequest storeRequest);

}
