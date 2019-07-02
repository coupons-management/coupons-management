package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

/**
 * @author 1500
 * @Date 2019/7/2.
 */
public class UserStoreRequest extends PageRequestBase {

    /**
     * 员工ID
     */
    private Integer userId;

    /**
     * 商家名称
     */
    private String name;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
