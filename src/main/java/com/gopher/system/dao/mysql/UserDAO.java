package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.Role;
import com.gopher.system.model.vo.request.*;
import com.gopher.system.model.vo.response.BasicInfoResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.User;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, Integer> {
	
	List<User> selectPage(UserPageRequst userPageRequst);
	
	Integer getCount(UserPageRequst userPageRequst);
	
	User selectByAccount(final String account);

	Integer addAccount(User user);

	void deleteUserStore(Integer id);

	void deleteUserRole(Integer id);

	void assignStore(@Param("param") UserAssignStoreRequest param);

	int assignedCount(@Param("stores") List<Integer> stores);

	void assignRole(@Param("param") UserAssigRoleRequest param);

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
	List<CpStore> userStore(UserStoreRequest userStoreRequest);

	int userStoreCount(UserStoreRequest userStoreRequest);

	/**
	 * 将商家分配给员工
	 * @param request
	 */
	void assignStoreToUser(UserAssignOrCancelStoreRequest request);

	/**
	 * 取消分配商家
	 * @param request
	 */
	void cancelUserStore(UserAssignOrCancelStoreRequest request);


}