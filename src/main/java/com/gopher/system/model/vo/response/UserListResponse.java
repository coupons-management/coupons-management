package com.gopher.system.model.vo.response;

import com.gopher.system.model.entity.Role;
import com.gopher.system.model.entity.User;

import java.util.List;

/**
 * @author 1500
 * @Date 2019/7/22.
 */
public class UserListResponse extends User {
    /**
   * 
   */
  private static final long serialVersionUID = 1L;
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
