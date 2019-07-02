package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.Role;
import com.gopher.system.model.vo.request.UserAssigRoleRequest;
import com.gopher.system.model.vo.request.UserAssignStoreRequest;
import com.gopher.system.model.vo.request.UserStoreRequest;
import com.gopher.system.model.vo.response.BasicInfoResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.User;
import com.gopher.system.model.vo.request.UserPageRequst;

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

	List<Role> userRole(Integer userId);

	List<CpStore> userStore(UserStoreRequest userStoreRequest);

	int userStoreCount(UserStoreRequest userStoreRequest);




}