package com.gopher.system.model.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "账号信息")
public class LoginRequest {
	@ApiModelProperty(value = "账号")
	private String account;
	@ApiModelProperty(value = "密码")
	private String password;
	@ApiModelProperty(value = "用户名")
	private String userName;
	@ApiModelProperty(value = "密码")
	private String passWord;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	
	

}
