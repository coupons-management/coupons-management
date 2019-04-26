package com.gopher.system.service;

import com.gopher.system.model.vo.CacheVO;

public interface CacheService {
	/**
	 * 获取
	 * 
	 * @param key
	 * @return
	 */
	Object get(String key);

	/**
	 * 删除
	 * 
	 * @param key
	 */
	void delete(String key);

	/**
	 * 设置缓存
	 * 
	 * @param key
	 */
	void set(String key, CacheVO<?> cacheVO);


}
