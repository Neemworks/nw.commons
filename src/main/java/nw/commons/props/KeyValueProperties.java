/*
 * File:	KeyValueProperties.java
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

import java.io.File;
import java.math.BigDecimal;

/**
 *
 * @author Ogwara O. Rowland
 *
 */
public class KeyValueProperties extends AbstractProp implements IProp {

	public KeyValueProperties() {
		this("application.properties");
	}

	public KeyValueProperties(String properties) {
		setProperties(properties);
		read();
	}

	public KeyValueProperties(File properties){
		properties.getParentFile().mkdirs();
		setProperties(properties.getAbsolutePath());
		read();
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#setProperty(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setProperty(String key, String value, String comments) {
		set(key, value, comments);
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#getProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public String getProperty(String key, String defaultVal) {
		String pty = get(key);
		return pty == null ? defaultVal : pty;
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#removeProperty(java.lang.String)
	 */
	@Override
	public synchronized void removeProperty(String key) {
		remove(key);
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#getInt(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Integer getInt(String key, Integer defaultVal) {
		return Integer.valueOf(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#getLong(java.lang.String, java.lang.Long)
	 */
	@Override
	public Long getLong(String key, Long defaultVal) {
		return Long.valueOf(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#getBigDecimal(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public BigDecimal getBigDecimal(String key, BigDecimal defaultVal) {
		return new BigDecimal(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#getDouble(java.lang.String, java.lang.Double)
	 */
	@Override
	public Double getDouble(String key, Double defaultVal) {
		return Double.valueOf(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#getFloat(java.lang.String, java.lang.Float)
	 */
	@Override
	public Float getFloat(String key, Float defaultVal) {
		return Float.valueOf(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#getBool(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean getBool(String key, Boolean defaultVal){
		return Boolean.valueOf(getProperty(key, defaultVal.toString()));
	}

	public static void main(String[] args) {
		IProp kp = new KeyValueProperties(new File(".build/v.properties"));
		kp.setProperty("high.score", "-20000", "highest player scored tonight");
		kp.setProperty("low.score", "200", "lowest player score");
	}

}
