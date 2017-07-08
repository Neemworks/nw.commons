package com.nimworks.config.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author Ogwara O. Rowland
 * @since Jul 8, 2017
 *
 */
public class ConfigurationCache {
	
	private static ConfigurationCache store;
	
	private ConcurrentHashMap<String, Map<String, Object>> cache;
	
	private ConfigurationCache() {
		cache = new ConcurrentHashMap<String, Map<String, Object>>();
	}
	
	public static ConfigurationCache getInstance() {
		if(store == null) {
			synchronized (ConfigurationCache.class) {
				if(store == null) {
					store = new ConfigurationCache();
				}
			}
		}
		
		return store;
	}
	
	public void add(String namespace, Map<String, Object> entries) {
		cache.put(namespace, entries);
	}
	
	public Map<String, Object> get(String namespace) {
		return cache.get(namespace);
	}
	
	

}
