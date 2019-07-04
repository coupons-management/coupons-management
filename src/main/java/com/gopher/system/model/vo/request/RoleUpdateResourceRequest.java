package com.gopher.system.model.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author 1500
 * @Date 2019/7/4.
 */
@ApiModel(description = "角色资源信息")
public class RoleUpdateResourceRequest {

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Integer roleId;

    /**
     * 资源id集合
     */
    @ApiModelProperty(value = "资源id集合")
    private List<Integer> resources;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getResources() {
        return resources;
    }

    public void setResources(List<Integer> resources) {
        this.resources = resources;
    }
}
