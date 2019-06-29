package com.gopher.system.dao.mysql;

import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.request.StorePageRequst;

import java.util.List;

public interface StoreOperationDAO {

    /**
     * 商家列表
     * @param storePageRequest
     * @return
     */
    List<CpStore> getPageList(StorePageRequst storePageRequest);

    /**
     * 总数
     * @param storePageRequest
     * @return
     */
    int getCount(StorePageRequst storePageRequest);


    /**
     * 商家列表
     * @param storePageRequest
     * @return
     */
    List<CpStore> getPageListInSite(StorePageRequst storePageRequest);

    /**
     * 总数
     * @param storePageRequest
     * @return
     */
    Integer getCountInSite(StorePageRequst storePageRequest);
}
