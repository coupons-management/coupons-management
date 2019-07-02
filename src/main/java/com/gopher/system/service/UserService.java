package com.gopher.system.service;

import com.gopher.system.model.entity.User;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.UserAddRequest;
import com.gopher.system.model.vo.request.UserPageRequst;
import com.gopher.system.model.vo.request.UserVerifyRequest;

public interface UserService {
	
	User findByAccount(final String account);
	
	User findById(final Integer id);
	
	User getCurrentUser();

	/**
	 * 创建账号
	 * @param userAddRequest
	 */
	void addAccount(UserAddRequest userAddRequest);


	/**
	 * 删除用户
	 * @param id
	 */
	void deleteAccount(Integer id);

	/**
	 * 用户列表
	 * @param userPageRequst
	 * @return
	 */
	Page<User> getPage(UserPageRequst userPageRequst);

	/**
	 * 修改用户信息
	 * @param verifyRequest
	 */
	void updateUser(UserVerifyRequest verifyRequest);


}
