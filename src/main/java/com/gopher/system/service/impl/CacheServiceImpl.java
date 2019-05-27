package com.gopher.system.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gopher.system.service.CacheService;
/**
 * 
 * @author dongyangyang
 *
 * @param <K>
 * @param <V>
 */
@Service
public class CacheServiceImpl<K,V> implements CacheService<K,V> {
	@Autowired
	private RedisTemplate<K,V> redisTemplate;

	@Override
	public V get(K key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void set(K key, V value,int timeout) {
		redisTemplate.opsForValue().set(key, value, timeout,TimeUnit.SECONDS);
	}
	
	@Override
	public void expire(K key,int timeout) {
		redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
	}

	@Override
	public void delete(K key) {
		redisTemplate.delete(key);
	}


}
