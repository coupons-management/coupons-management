package com.gopher.system.service.impl;

import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.User;
import com.gopher.system.model.vo.request.LoginRequest;
import com.gopher.system.model.vo.response.LoginResponse;
import com.gopher.system.service.CacheService;
import com.gopher.system.service.LoginService;
import com.gopher.system.service.UserService;
import com.gopher.system.util.CookieUtils;
import com.gopher.system.util.MD5Utils;
/**
 * 登录登出业务
 * @author dongyangyang
 *
 */
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Resource
	private UserService userService;
	@Resource
	private CacheService<String,User> cacheService;

	@Override
	public LoginResponse login(LoginRequest loginRequest) {

		if (null == loginRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final String account  = StringUtils.hasText(loginRequest.getAccount())?loginRequest.getAccount():loginRequest.getUserName();
		final String password = StringUtils.hasText(loginRequest.getPassword())?loginRequest.getPassword():loginRequest.getPassWord();
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
		result.setSessionKey(sessionKey);
		result.setExpiryTime(System.currentTimeMillis()+CookieUtils.DEFAULT_AGE*1000L);
		return result;
	}

	private void loginSuccessHandle(final String sessionKey, final User user) {
		// 从当前线程中获取response
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		// 写入cookie
		CookieUtils.addCookie(response, sessionKey, CookieUtils.DEFAULT_AGE);
		// 写入缓存
		cacheService.set(sessionKey, user, CookieUtils.DEFAULT_AGE);
	}

	@Override
	public LoginResponse logout() {
		// 1 获取Cookie
		// 2 销毁cookie
		// 3 销毁缓存
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (Objects.equals(cookie.getName(), CookieUtils.DEFAULT_NAME)) {
					final String sessionKey = cookie.getValue();
					cacheService.delete(sessionKey);
					CookieUtils.deleteCookie(response, cookie);
					break;
				}

			}
		}
		return null;
	}

}
