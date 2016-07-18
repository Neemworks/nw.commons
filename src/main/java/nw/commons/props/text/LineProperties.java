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
package nw.commons.props.text;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import nw.commons.props.IProp;

/**
 * Key Value properties, usually in text files
 * @author Ogwara O. Rowland
 *
 */
public class LineProperties extends TextLineManager implements IProp {

	public LineProperties() {
		this("application.properties");
	}

	public LineProperties(String properties) {
		setProperties(properties);
		read();
	}

	public LineProperties(File properties){
		properties.getParentFile().mkdirs();
		setProperties(properties.getAbsolutePath());
		read();
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#setProperty(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setProperty(String key, Object value, String comments) {
		set(key, value, comments);
	}

	/* (non-Javadoc)
	 * @see com.nimworks.commons.props.IProp#getProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public String getProperty(String key, String defaultVal) {
		String pty = get(key);
		return pty == null ? defaultVal.trim() : pty.trim();
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

	@Override
	public Boolean containsKey(String key) {
		return store.containsKey(key);
	}

	@Override
	public Set<String> getKeys() {
		return store.keySet();
	}

	@Override
	public Set<String> getKeys(String prefix) {
		// TODO build a trie for the keys, to enhance speed
		Set<String> ks = store.keySet();
		Set<String> res = new HashSet<String>();
		// O(n)
		for (String key : ks) {
			if(key.startsWith(prefix)){
				res.add(key);
			}
		}
		return res;
	}

	@Override
	public String[] getStringArray(String key) {
		return getStringArray(key, ",");
	}
	
	@Override
	public String[] getStringArray(String key, String delimter) {
		String delim = get(key);
		if(delim == null){
			return new String[0];
		}
		return delim.split(delimter);
	}
	
	public static void main(String[] args) {
		IProp kp = new LineProperties("application.properties");
		kp.setProperty("high.score", "120000", "highest player scored tonight");
		kp.setProperty("low.score", "200", "lowest player score");
		System.out.println(kp.getBool("has-eyes", false));
		kp.removeProperty("sex");
	}

}
