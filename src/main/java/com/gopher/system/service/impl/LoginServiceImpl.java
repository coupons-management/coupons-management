package com.gopher.system.service.impl;

import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.User;
import com.gopher.system.model.vo.request.LoginRequest;
import com.gopher.system.model.vo.response.LoginResponse;
import com.gopher.system.service.CacheService;
import com.gopher.system.service.LoginService;
import com.gopher.system.service.UserService;
import com.gopher.system.util.CookieUtils;
import com.gopher.system.util.MD5Utils;

@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private UserService userService;
	@Resource
	private CacheService cacheService;

	@Override
	public LoginResponse login(LoginRequest loginRequest) {

		if (null == loginRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final String account = loginRequest.getAccount();
		final String password = loginRequest.getPassword();
		if (!StringUtils.hasText(account)) {
			throw new BusinessRuntimeException("账号不能为空");
		}
		if (!StringUtils.hasText(password)) {
			throw new BusinessRuntimeException("密码不能为空");
		}
		User user = userService.findByAccount(account);
		if (null == user) {
			throw new BusinessRuntimeException("无效的账号,请检查后重新输入");
		}
		final String password_DB = user.getPassword();
		if (!Objects.equals(password_DB, password)) {
			throw new BusinessRuntimeException("密码错误,请检查后重新输入");
		}
		final String sessionKey = MD5Utils.MD5(password_DB);
		this.loginSuccessHandle(sessionKey, user);
		LoginResponse result = new LoginResponse();
		return result;
	}

	private void loginSuccessHandle(final String sessionKey, final User user) {
		// 从当前线程中获取response
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		// 写入cookie
		CookieUtils.addCookie(response, sessionKey, CookieUtils.DEFAULT_TOKEN_ALIVE);
		// 写入缓存
		cacheService.set(sessionKey, user, CookieUtils.DEFAULT_TOKEN_ALIVE);
	}

	@Override
	public LoginResponse logout() {
		// 1 获取Cookie
		// 2 销毁cookie
		// 3 销毁缓存
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (Objects.equals(cookie.getName(), CookieUtils.COOKIE_KEY)) {
					final String sessionKey = cookie.getValue();
					cacheService.delete(sessionKey);
					CookieUtils.removeCookie(request);
					break;
				}

			}
		}
		return null;
	}

}
