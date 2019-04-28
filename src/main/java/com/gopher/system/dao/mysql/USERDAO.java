package com.gopher.system.dao.mysql;

import com.gopher.system.model.User;
import org.springframework.stereotype.Repository;

/**
 * USERDAO继承基类
 */
@Repository
public interface USERDAO extends MyBatisBaseDao<User, String> {
}