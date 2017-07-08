package com.nimworks.config;

/**
 * 
 * @author Ogwara O. Rowland
 * @since Jul 7, 2017
 *
 */
public interface IConfiguration {
	
	/**
	 * Reads and caches all configuration details from external source
	 */
	void init();
	
	/**
	 * Retrieves a String value for the provided key
	 * @param key
	 * @return Text property value
	 */
	String get(String key);
	
	/**
	 * Writes all cached config to external source
	 */
	void writeAll();
	
	<T> void update(String key, T value);
	
	<T> void add(String key, T value, String comments);

}
