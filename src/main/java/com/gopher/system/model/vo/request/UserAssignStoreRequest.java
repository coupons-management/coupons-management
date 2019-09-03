package com.gopher.system.model.vo.request;

import java.util.List;

/**
 * @author 1500
 * @Date 2019/7/2.
 */
public class UserAssignStoreRequest {

    /**
     * 员工ID
     */
    private Integer userId;
    /**
     * 被分配的商家ID集合
     */
    private List<Integer> stores;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getStores() {
        return stores;
    }

    public void setStores(List<Integer> stores) {
        this.stores = stores;
    }
}
