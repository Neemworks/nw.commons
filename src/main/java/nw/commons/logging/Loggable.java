package nw.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a class that provides none static slf4j logger access to
 * classes that extend it
 * @author Ogwara O. Rowland
 * @since 2.0
 *
 */
public abstract class Loggable {

	/**
	 * Logger instance for class
	 */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public Logger getLogger() {
		return logger;
	}

}
