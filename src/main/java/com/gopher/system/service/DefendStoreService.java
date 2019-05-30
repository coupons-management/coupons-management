package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.DefendStorePageRequest;
import com.gopher.system.model.vo.response.StoreResponse;

public interface DefendStoreService {
	/**
	 * 维护操作 商家分页列表
	 * @param defendStorePageRequst
	 * @return
	 */
	Page<StoreResponse> getStorePage(DefendStorePageRequest defendStorePageRequst);
}
