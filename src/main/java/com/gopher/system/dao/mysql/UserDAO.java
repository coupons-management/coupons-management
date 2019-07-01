package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.vo.request.UserAddRequest;
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

}