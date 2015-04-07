/*
 * Copyright 2013 - 2015, Neemworks Nigeria <dev@nimworks.com>
 Permission to use, copy, modify, and distribute this software for any
 purpose with or without fee is hereby granted, provided that the above
 copyright notice and this permission notice appear in all copies.

 THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package nw.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Provides a means of manipulating property files used by the project,
 * automatically creates a property file if it does not see one in application
 * root folder. Only a single instance of the class is expected to exists
 *
 * @author Ogwara O. Rowland
 * @version 0.3
 * @since 10th November, 2013
 *
 */

public class AppProperties {

	/** The referenced properties file. */
	private Properties props = new Properties(); // Empty Java properties object

	/** Optional comments attached to the property file. */
	private String comments = "Auto Generated Property File";

	/** The property file name. Defaults to <b>application.properties</b> */
	private String fileName = "application.properties";

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Instantiates a new base properties, using the default property file name.
	 */
	public AppProperties() {
		this("application.properties");
	}

	/**
	 * Instantiates a new base properties.
	 *
	 * @param fileName the file name
	 */
	public AppProperties(String fileName) {
		this.fileName = fileName;
		loadProperties();
	}

	/**
	 * Load properties.
	 *
	 * @return the properties
	 */
	private Properties loadProperties() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			props.load(fis);

			fis.close();
		} catch (FileNotFoundException e) {
			createProperties();
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return props;
	}

	/**
	 * Creates a blank properties file.
	 */
	private void createProperties() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			props.store(fos, comments);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			logger.error("Exception while updating properties file: ", e);
		}
	}

	/**
	 *
	 * @param properties property map to add to property file
	 */
	public void saveProperties(HashMap<String, String> properties) {

		Set<String> keys = properties.keySet();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			props.setProperty(key, properties.get(key));
		}
		createProperties();
	}

	/**
	 * sets the value for a property.
	 *
	 * @param key reference key for property
	 * @param value property value
	 */
	public synchronized void setProperty(String key, String value) {
		props.setProperty(key, value);
		createProperties();
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
		return props.getProperty(key, defaultVal);
	}

	/**
	 * deletes an entry with the specified key.
	 *
	 * @param key reference item to remove
	 */
	public synchronized void removeProperty(String key) {
		props.remove(key);
		createProperties();
	}

	/**
	 * Gets the int.
	 *
	 * @param key reference key
	 * @param defaultVal value if property is not set
	 * @return retrieves int from property files
	 */
	public Integer getInt(String key, Integer defaultVal) {
		return Integer.valueOf(props.getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the long.
	 *
	 * @param key refernce key
	 * @param defaultVal value if property is not set
	 * @return retrieves Long from property files
	 */
	public Long getLong(String key, Long defaultVal) {
		return Long.valueOf(props.getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the big decimal.
	 *
	 * @param key refernce key
	 * @param defaultVal value if property is not set
	 * @return retrieves BigDecimal from property files
	 */
	public BigDecimal getBigDecimal(String key, BigDecimal defaultVal) {
		return new BigDecimal(props.getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the double.
	 *
	 * @param key the key
	 * @param defaultVal the default val
	 * @return retrieves double from property files
	 */
	public Double getDouble(String key, Double defaultVal) {
		return Double.valueOf(props.getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the float.
	 *
	 * @param key the key
	 * @param defaultVal the default val
	 * @return retrieves an int from property files
	 */
	public Float getFloat(String key, Float defaultVal) {
		return Float.valueOf(props.getProperty(key, defaultVal + ""));
	}

	/**
	 * Gets the boolean property for specified key.
	 *
	 * @param key the property key
	 * @param defaultVal the default value if nothing is found
	 * @return the bool value for the target key
	 */
	public Boolean getBool(String key, Boolean defaultVal){
		return Boolean.valueOf(props.getProperty(key, defaultVal.toString()));
	}
}
