package com.nimworks.config;

import java.util.Map;

/**
 * An external source for configurations
 * @author Ogwara O. Rowland
 * @since Jul 7, 2017
 *
 */
public interface ISource {
	
	/**
	 * Reads all entries from the external source
	 * @return A key value map of entries
	 */
	Map<String, Object> read();
	
	/**
	 * overwrites the entire config entries
	 */
	void refresh();
	
	void add(String key, String value, String comment);
	
	void update(String key, String value);
	
	void remove(String key);
	
	void write(Map<String, Object> configs);

}
