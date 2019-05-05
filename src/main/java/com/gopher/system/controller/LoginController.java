package com.gopher.system.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.vo.request.LoginRequest;
import com.gopher.system.service.LoginService;

@RestController
public class LoginController {
	@Resource
	private LoginService loginService;
	@PostMapping(path="/login")
	public Result login(@RequestBody LoginRequest loginRequest) {
		loginService.login(loginRequest);
		return new Result();
	}
	@PostMapping(path="/logout")
	public Result logout() {
		loginService.logout();
		return new Result();
	}

}