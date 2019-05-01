package com.gopher.system.service;

public interface CacheService<K,V> {
	/**
	 * 获取
	 * 
	 * @param key
	 * @return
	 */
	Object get(K k);

	/**
	 * 删除
	 * 
	 * @param key
	 */
	void delete(K k);

	/**
	 * 设置缓存
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 */
	void set(K k, V value, int timeout);

	/**
	 * 重设过期时间 单位秒
	 * 
	 * @param key
	 * @param timeout
	 */
	void expire(K k, int timeout);



}
