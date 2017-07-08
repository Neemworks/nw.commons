package com.nimworks.config;

import java.util.Map;

/**
 * An external source for configurations
 * @author Ogwara O. Rowland
 * @since Jul 7, 2017
 *
 */
public interface ISource {
	
	Map<String, Object> read();
	
	void write(Map<String, Object> configs);

}
