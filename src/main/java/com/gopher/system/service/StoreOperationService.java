package com.gopher.system.service;

import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;

public interface StoreOperationService {
    /**
     * 获取商家列表
     * @param storePageRequest
     * @return
     */
    Page<StoreResponse> getPage(StorePageRequst storePageRequest);
}
