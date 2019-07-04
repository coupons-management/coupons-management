package com.gopher.system.model.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author 1500
 * @Date 2019/7/4.
 */
@ApiModel(description = "角色信息")
public class ResourceResponse {

    /**
     * ID
     */
    @ApiModelProperty(value = "角色ID")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "地址")
    private String url;

    @ApiModelProperty(value = "排序码")
    private Integer orderNum;

    /**
     * 父节点id
     */
    @ApiModelProperty(value = "父节点id")
    private Integer pid;

    @ApiModelProperty(value = "子节点")
    private List<ResourceResponse> children;

    @ApiModelProperty(value = "无用字段")
    @JSONField(serialize = false)
    private Boolean hasResource = false;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<ResourceResponse> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceResponse> children) {
        this.children = children;
    }

    public Boolean getHasResource() {
        return hasResource;
    }

    public void setHasResource(Boolean hasResource) {
        this.hasResource = hasResource;
    }
}
