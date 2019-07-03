package com.gopher.system.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.LoginRequest;
import com.gopher.system.service.LoginService;
/**
 * 登录登出
 * @author dongyangyang
 *
 */
@RestController
@Api(value="login", description = "登陆管理")
public class LoginController {
	@Resource
	private LoginService loginService;

	@ApiOperation(value = "登陆",httpMethod = "POST" ,response = Result.class)
	@RequestMapping(path="/login")
	public Result login(@RequestBody LoginRequest loginRequest) {
		Result result = new Result();
		result.setData(loginService.login(loginRequest));
		return result;
	}
	
	@RequestMapping(path="/logout")
	public Result logout() {
		loginService.logout();
		return new Result();
	}

}
