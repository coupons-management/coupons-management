package com.gopher.system.interceptor;

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
import com.gopher.system.util.ThreadLocalUtils;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private CacheService<String,User> cacheService;

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
		httpServletResponse.setCharacterEncoding("UTF-8");
		
		final String TOKEN = httpServletRequest.getParameter("token");
		final String APPLICATION = httpServletRequest.getParameter("application");
		if (!StringUtils.hasText(TOKEN)) {
			// 没有传token
			httpServletResponse.getWriter().write(JSON.toJSONString(new Result(-1, "您还没有登录,请登录", false)));
			return false;
		}
		User user = cacheService.get(TOKEN);
		if (null == user) {
			// 缓存中没有对应的缓存
			httpServletResponse.getWriter().write(JSON.toJSONString(new Result(-1, "会话已过期,请重新登录", false)));
			return false;
		}
		/**
		 * 当前用户
		 */
		ThreadLocalUtils.setObject(ThreadLocalUtils.USER_KEY, user);
		//当前所发送的请求的客户端类型(app,web)
		ThreadLocalUtils.setObject(ThreadLocalUtils.APPLICATION, APPLICATION);
		return true;
	}

	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}
