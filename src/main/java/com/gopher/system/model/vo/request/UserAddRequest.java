package com.gopher.system.model.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 1500
 * @Date 2019/7/1.
 */
@ApiModel(description = "账号信息")
public class UserAddRequest {

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称",required = true)
    private String name;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号",required = true)
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true)
    private String password;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
