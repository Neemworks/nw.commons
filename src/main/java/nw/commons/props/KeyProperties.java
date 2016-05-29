package nw.commons.props;

import java.math.BigDecimal;

public class KeyProperties extends AbstractProperties {

	public KeyProperties() {
		this("app.properties");
	}

	public KeyProperties(String properties) {
		setProperties(properties);
		read();
	}

	/**
	 * sets the value for a property.
	 *
	 * @param key reference key for property
	 * @param value property value
	 * @param comments message
	 */
	public void setProperty(String key, String value, String comments) {
		set(key, value, comments);
	}

	/**
	 * Retrieves a property with the specified key.
	 *
	 * @param key target key to retrieve
	 * @param defaultVal String value default
	 * @return defaultVal if key does not exist in the property file or returns
	 *         the appropriate value
	 */
	public String getProperty(String key, String defaultVal) {
		String pty = get(key);
		return pty == null ? defaultVal : pty;
	}

	/**
	 * deletes an entry with the specified key.
	 *
	 * @param key reference item to remove
	 */
	public synchronized void removeProperty(String key) {
		remove(key);
	}

	/**
	 * Gets the int.
	 *
	 * @param key reference key
	 * @param defaultVal value if property is not set
	 * @return retrieves int from property files
	 */
	public Integer getInt(String key, Integer defaultVal) {
		return Integer.valueOf(getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the long.
	 *
	 * @param key refernce key
	 * @param defaultVal value if property is not set
	 * @return retrieves Long from property files
	 */
	public Long getLong(String key, Long defaultVal) {
		return Long.valueOf(getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the big decimal.
	 *
	 * @param key refernce key
	 * @param defaultVal value if property is not set
	 * @return retrieves BigDecimal from property files
	 */
	public BigDecimal getBigDecimal(String key, BigDecimal defaultVal) {
		return new BigDecimal(getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the double.
	 *
	 * @param key the key
	 * @param defaultVal the default val
	 * @return retrieves double from property files
	 */
	public Double getDouble(String key, Double defaultVal) {
		return Double.valueOf(getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the float.
	 *
	 * @param key the key
	 * @param defaultVal the default val
	 * @return retrieves an int from property files
	 */
	public Float getFloat(String key, Float defaultVal) {
		return Float.valueOf(getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the boolean property for specified key.
	 *
	 * @param key the property key
	 * @param defaultVal the default value if nothing is found
	 * @return the bool value for the target key
	 */
	public Boolean getBool(String key, Boolean defaultVal){
		return Boolean.valueOf(getProperty(key, defaultVal.toString()));
	}

	public static void main(String[] args) {
		KeyProperties kp = new KeyProperties();
		kp.setProperty("high.score", "20000", "highest player score");
		kp.setProperty("low.score", "200", "lowest player score");
	}

}
