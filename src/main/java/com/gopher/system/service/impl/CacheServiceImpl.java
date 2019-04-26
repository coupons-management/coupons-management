package com.gopher.system.service.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.gopher.system.model.vo.CacheVO;
import com.gopher.system.service.CacheService;
@Service
public class CacheServiceImpl implements CacheService{
	private static final ConcurrentHashMap<String,Object> context = new ConcurrentHashMap<>();

	@Override
	public Object get(String key) {
		return context.get(key);
	}

	@Override
	public void set(String key, CacheVO<?> cacheVO) {
		context.put(key,cacheVO);
	}

	@Override
	public void delete(String key) {
		context.remove(key);
	}



}
