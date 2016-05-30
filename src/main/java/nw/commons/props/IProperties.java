package nw.commons.props;

import java.math.BigDecimal;

public interface IProperties {

	/**
	 * sets the value for a property.
	 *
	 * @param key reference key for property
	 * @param value property value
	 * @param comments message
	 */
	void setProperty(String key, String value, String comments);

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

}