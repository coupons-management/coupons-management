package com.gopher.system.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 1500
 * @Date 2019/7/1.
 */
@ApiModel(description = "角色信息")
public class Resource implements Serializable{

    /**
   * 
   */
  private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "角色ID")
    private Integer id;


    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String name;

    /**
     * 父节点id
     */
    @ApiModelProperty(value = "父节点id")
    private Integer pid;

    /**
     * url
     */
    @ApiModelProperty(value = "url")
    private String url;


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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(id, resource.id) &&
                Objects.equals(name, resource.name) &&
                Objects.equals(pid, resource.pid) &&
                Objects.equals(url, resource.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, pid, url);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", url='" + url + '\'' +
                '}';
    }
}
