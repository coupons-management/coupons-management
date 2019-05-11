package com.gopher.system.service;

import com.gopher.system.model.entity.User;

public interface UserService {
	
	User findByAccount(final String account);
	
	User findById(final Integer id);

}
