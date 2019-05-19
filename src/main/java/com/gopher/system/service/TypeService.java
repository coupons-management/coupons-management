package com.gopher.system.service;

import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.vo.response.TypeResponse;

public interface TypeService {
	
	TypeResponse getList();
	
	void create(CpType cpType);
	
	void delete(final int id);

}
