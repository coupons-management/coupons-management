package com.gopher.system.model.vo.request;


/**
 * @author 1500
 * @Date 2019/7/2.
 */
public class UserAssignOrCancelStoreRequest {

    /**
     * 员工ID
     */
    private Integer userId;
    /**
     * 被分配、取消的商家ID
     */
    private Integer storeId;

    /**
     * 操作 1 分配 2取消
     */
    private Integer operation;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }
}
