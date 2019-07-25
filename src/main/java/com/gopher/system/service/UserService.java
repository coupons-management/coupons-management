package com.gopher.system.service;

import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.Role;
import com.gopher.system.model.entity.User;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.*;
import com.gopher.system.model.vo.response.UserListResponse;

import java.util.List;

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
	Page<UserListResponse> getPage(UserPageRequst userPageRequst);

	/**
	 * 修改用户信息
	 * @param verifyRequest
	 */
	void updateUser(UserVerifyRequest verifyRequest);


	/**
	 * 给员工分配商家
	 * @param userAssignStoreRequest
	 */
	void assignStore(UserAssignStoreRequest userAssignStoreRequest);


	/**
	 * 给员工分配角色
	 * @param userAssigRoleRequest
	 */
	void assignRole(UserAssigRoleRequest userAssigRoleRequest);

	/**
	 * 员工角色列表
	 * @param userId
	 * @return
	 */
	List<Role> userRole(Integer userId);

	/**
	 * 员工管理商家列表
	 * @param userStoreRequest
	 * @return
	 */
	Page<CpStore> userStore(UserStoreRequest userStoreRequest);

	/**
	 * 当前登陆用户管理商家列表
	 * @return
	 */
	Page<CpStore> currentUserStore(UserStoreRequest userStoreRequest);

	/**
	 * 分配、取消分配商家
	 * @param request
	 */
	void assignOrCancelStoreToUser(UserAssignOrCancelStoreRequest request);

}
