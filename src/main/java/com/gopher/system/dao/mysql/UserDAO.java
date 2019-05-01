package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.User;
import com.gopher.system.model.vo.request.UserPageRequst;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, Integer> {
	
	List<User> selectPage(UserPageRequst userPageRequst);
	
	Integer selectTotalCount(UserPageRequst userPageRequst);
	
	User selectByAccount(final String account);
}