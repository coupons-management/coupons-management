package com.gopher.system.model.vo.request;

import java.util.List;

public class MannulSortRequest {

    private int storeId;

    List<CouponSortReq> sortList;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public List<CouponSortReq> getSortList() {
        return sortList;
    }

    public void setSortList(List<CouponSortReq> sortList) {
        this.sortList = sortList;
    }
}
