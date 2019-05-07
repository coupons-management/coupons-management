package com.gopher.system.interceptor;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.gopher.system.controller.model.Result;
import com.gopher.system.model.User;
import com.gopher.system.service.CacheService;
import com.gopher.system.util.CookieUtils;
import com.gopher.system.util.ThreadLocalUtils;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private CacheService<String,User> cacheService;

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		Cookie[] cookies = httpServletRequest.getCookies();
		boolean valid = false;
		if(null !=cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if(Objects.equals(cookie.getName(),CookieUtils.COOKIE_KEY)) {
					final String TOKEN = cookie.getValue();
					if(StringUtils.hasText(TOKEN)) {
						User user = cacheService.get(TOKEN);
						if(null != user) {
							// 当前用户写入线程
							valid = true;
							ThreadLocalUtils.setObject(ThreadLocalUtils.USER_KEY, user);
						}
					}
				}
			}
		}
		if(!valid) {
			httpServletResponse.getWriter().write(JSON.toJSONString(new Result(-1, "您还没登录,或会话已过期,请重新登录", false)));
			return valid;
		}
		return valid;
	}
    
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}
