package com.gopher.system.service;

import com.gopher.system.model.vo.request.LoginRequest;
import com.gopher.system.model.vo.response.LoginResponse;

public interface LoginService {
	/**
	 * 登录
	 * 
	 * @param loginRequest
	 * @return
	 */
	public LoginResponse login(LoginRequest loginRequest);

	/**
	 * 登出
	 * 
	 * @param loginRequest
	 * @return
	 */
	public LoginResponse logout();

}
