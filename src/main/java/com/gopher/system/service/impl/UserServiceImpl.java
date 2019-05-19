package com.gopher.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopher.system.dao.mysql.UserDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.User;
import com.gopher.system.service.UserService;
import com.gopher.system.util.ThreadLocalUtils;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDAO userDAO;

	@Override
	public User findByAccount(String account) {
		if (!StringUtils.hasText(account)) {
			throw new BusinessRuntimeException("无效的账号");
		}
		return userDAO.selectByAccount(account);
	}

	@Override
	public User findById(Integer id) {
		if (null == id || id < 0) {
			throw new BusinessRuntimeException("无效的ID");
		}
		return userDAO.selectByPrimaryKey(id);
	}

	@Override
	public User getCurrentUser() {
		Object object = ThreadLocalUtils.getObject(ThreadLocalUtils.USER_KEY);
		User user = null;
		if (null != object) {
			user = (User) object;
		}
		return user;
	}

}
