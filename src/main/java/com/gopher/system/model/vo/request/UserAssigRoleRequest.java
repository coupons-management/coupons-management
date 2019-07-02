package com.gopher.system.model.vo.request;

import java.util.List;

/**
 * @author 1500
 * @Date 2019/7/2.
 */
public class UserAssigRoleRequest {

    /**
     * 员工ID
     */
    private Integer userId;
    /**
     * 被分配的角色ID集合
     */
    private List<Integer> roles;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }
}
