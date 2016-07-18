/*
 * File:	IProp.java
 * Author				Date			Change
 * Rowland				Jun 18, 2016			Created
 *
 *
 * Property of Neemworks, do not reproduce or reuse without permission
 * contact dev@neemworks.net for further information.
 * 
 * Copyright Neemworks
 * http://www.neemworks.net
 */
package nw.commons.props;

import java.math.BigDecimal;
import java.util.Set;

public interface IProp {

	/**
	 * sets the value for a property.
	 *
	 * @param key reference key for property
	 * @param value property value
	 * @param comments message
	 */
	void setProperty(String key, Object value, String comments);

	/**
	 * Retrieves a property with the specified key.
	 *
	 * @param key target key to retrieve
	 * @param defaultVal String value default
	 * @return defaultVal if key does not exist in the property file or returns
	 *         the appropriate value
	 */
	String getProperty(String key, String defaultVal);

	/**
	 * deletes an entry with the specified key.
	 *
	 * @param key reference item to remove
	 */
	void removeProperty(String key);

	/**
	 * Gets the int.
	 *
	 * @param key reference key
	 * @param defaultVal value if property is not set
	 * @return retrieves int from property files
	 */
	Integer getInt(String key, Integer defaultVal);

	/**
	 * Gets the long.
	 *
	 * @param key refernce key
	 * @param defaultVal value if property is not set
	 * @return retrieves Long from property files
	 */
	Long getLong(String key, Long defaultVal);

	/**
	 * Gets the big decimal.
	 *
	 * @param key refernce key
	 * @param defaultVal value if property is not set
	 * @return retrieves BigDecimal from property files
	 */
	BigDecimal getBigDecimal(String key, BigDecimal defaultVal);

	/**
	 * Gets the double.
	 *
	 * @param key the key
	 * @param defaultVal the default val
	 * @return retrieves double from property files
	 */
	Double getDouble(String key, Double defaultVal);

	/**
	 * Gets the float.
	 *
	 * @param key the key
	 * @param defaultVal the default val
	 * @return retrieves an int from property files
	 */
	Float getFloat(String key, Float defaultVal);

	/**
	 * Gets the boolean property for specified key.
	 *
	 * @param key the property key
	 * @param defaultVal the default value if nothing is found
	 * @return the bool value for the target key
	 */
	Boolean getBool(String key, Boolean defaultVal);
	
	/**
	 * Searches the property file to determine if there is any property
	 * specified for the key
	 * @param key key used to search
	 * @return true if key is found, else returns false
	 */
	Boolean containsKey(String key);
	
	/**
	 * Retrieves and return the set of all the keys contained 
	 * within the property file
	 * @return Set of all the keys found in the file
	 */
	Set<String> getKeys();
	
	/**
	 * Retrieves and returns all keys starting with the given
	 * prefix
	 * @param prefix key prefix
	 * @return
	 */
	Set<String> getKeys(String prefix);
	
	/**
	 * Splits a given property by comma and returns the resulting string array
	 * @param key the key of the property
	 * @return An array of strings
	 */
	String[] getStringArray(String key);
	
	/**
	 * Splits a property by the provided delimter
	 * @param key target key
	 * @param delimter the delimiter to use
	 * @return An array of strings
	 */
	String[] getStringArray(String key, String delimter);

}