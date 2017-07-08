package com.nimworks.config.impl;

import java.io.File;
import java.util.Map;

import com.nimworks.config.IConfiguration;
import com.nimworks.config.ISource;
import com.nimworks.config.cache.ConfigurationCache;
import com.nimworks.config.source.KeyValueFileSource;

/**
 * Main entry point for configuration class
 * @author Ogwara O. Rowland
 * @since Jul 8, 2017
 *
 */
public class Configuration implements IConfiguration {
	
	private ISource source;
	private String namespace;
	private ConfigurationCache cache;
	
	public Configuration() {
		this("application.properties");
	}
	
	public Configuration(String fileLocation) {
		
		File file = new File(fileLocation);
		this.namespace = file.getName();
		this.source = new KeyValueFileSource(file);
		
		this.init();
	}
	
	public Configuration(String namespace, ISource source) {
		this.source = source;
		this.namespace = namespace;
		
		this.init();
	}

	@Override
	public void init() {
		Map<String, Object> map = cache.get(namespace);
		if(map == null) {
			map = source.read();
		}
		cache.add(namespace, map);
	}
	
	@Override
	public String get(String key) {
		Map<String, Object> map = cache.get(namespace);
		return (String) map.get(key);
	}

	@Override
	public void writeAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void update(String key, T value) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void add(String key, T value, String comments) {
		// TODO Auto-generated method stub
		
	}

}
