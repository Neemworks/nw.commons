package nw.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Property of Neemworks Limited
 *
 * Provides a means of manipulating property files used by the project,
 * automatically creates a property file if it does not see one in application
 * root folder. Only a single instance of the class is expected to exists
 *
 * @author Ogwara O. Rowland (r.ogwara@nimworks.com)
 * @version 0.2
 * @since 11th May, 2013
 *
 */

public class BaseProperties {

	private static BaseProperties prop;
	private Properties props = new Properties(); // Empty Java properties object
	private String comments = "Auto Generated";
	private String fileName = "application.properties";
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private BaseProperties() {
		loadProperties();
	}

	/** loads or creates a default properties file */
	public static BaseProperties getInstance() {

		if (prop == null) {
			synchronized (BaseProperties.class) {
				prop = new BaseProperties();
			}
		}
		return prop;
	}

	private Properties loadProperties() {
		try {
			props.load(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			updateProperties();
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return props;
	}

	private void updateProperties() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			props.store(fos, comments);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			logger.error("Exception while updating properties file: ", e);
		}
	}

	/** Add or Modify Property list */
	public void saveProperties(HashMap<String, String> properties) {

		Set<String> keys = properties.keySet();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			props.setProperty(key, properties.get(key));
		}
		updateProperties();
	}

	/**
	 * sets the value for a property
	 *
	 * @param key
	 * @param value
	 */
	public synchronized void setProperty(String key, String value) {
		props.setProperty(key, value);
		updateProperties();
	}

	/**
	 * Retrieves a property with the specified key
	 *
	 * @param key
	 * @param defaultVal
	 * @return defaultVal if key does not exist in the property file or returns
	 *         the appropriate value
	 */
	public String getProperty(String key, String defaultVal) {
		return props.getProperty(key, defaultVal);
	}

	/**
	 * deletes an entry with the specified key
	 *
	 * @param key
	 */
	public synchronized void removeProperty(String key) {
		props.remove(key);
		updateProperties();
	}

	public Integer getInt(String key, String defaultVal) {
		return Integer.valueOf(props.getProperty(key, defaultVal));
	}
}
