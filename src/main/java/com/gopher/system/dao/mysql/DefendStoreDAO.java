package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.vo.request.DefendStorePageRequest;
import com.gopher.system.model.vo.response.StoreResponse;

@Repository
public interface DefendStoreDAO {
	
	List<StoreResponse> getStorePageList(DefendStorePageRequest defendStorePageRequst);
	
	int getStoreCount(DefendStorePageRequest defendStorePageRequst);
}
