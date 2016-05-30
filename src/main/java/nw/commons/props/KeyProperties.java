package nw.commons.props;

import java.math.BigDecimal;

public class KeyProperties extends AbstractProperties implements IProperties {

	public KeyProperties() {
		this("app.properties");
	}

	public KeyProperties(String properties) {
		setProperties(properties);
		read();
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#setProperty(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setProperty(String key, String value, String comments) {
		set(key, value, comments);
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#getProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public String getProperty(String key, String defaultVal) {
		String pty = get(key);
		return pty == null ? defaultVal : pty;
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#removeProperty(java.lang.String)
	 */
	@Override
	public synchronized void removeProperty(String key) {
		remove(key);
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#getInt(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Integer getInt(String key, Integer defaultVal) {
		return Integer.valueOf(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#getLong(java.lang.String, java.lang.Long)
	 */
	@Override
	public Long getLong(String key, Long defaultVal) {
		return Long.valueOf(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#getBigDecimal(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public BigDecimal getBigDecimal(String key, BigDecimal defaultVal) {
		return new BigDecimal(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#getDouble(java.lang.String, java.lang.Double)
	 */
	@Override
	public Double getDouble(String key, Double defaultVal) {
		return Double.valueOf(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#getFloat(java.lang.String, java.lang.Float)
	 */
	@Override
	public Float getFloat(String key, Float defaultVal) {
		return Float.valueOf(getProperty(key, defaultVal + ""));
	}

	/* (non-Javadoc)
	 * @see nw.commons.props.IProperties#getBool(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean getBool(String key, Boolean defaultVal){
		return Boolean.valueOf(getProperty(key, defaultVal.toString()));
	}

	public static void main(String[] args) {
		IProperties kp = new KeyProperties();
		kp.setProperty("high.score", "20000", "highest player score");
		kp.setProperty("low.score", "200", "lowest player score");
	}

}
