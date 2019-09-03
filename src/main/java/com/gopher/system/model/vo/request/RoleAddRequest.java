package com.gopher.system.model.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 1500
 * @Date 2019/7/3.
 */
@ApiModel(description = "角色信息")
public class RoleAddRequest {

    /**
     * ID
     */
    @ApiModelProperty(value = "角色ID(更新操作时必填)")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "角色名称")
    private String name;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述")
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
