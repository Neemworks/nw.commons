package nw.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides none static slf4j logger access to
 * classes that extend it
 * @author Ogwara O. Rowland
 * @since 2.0
 *
 */
public abstract class Loggable {

	/**
	 * {@link Logger} instance used for all logging within the class
	 */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *
     * @return {@link Logger} reference
     */
    public Logger getLogger() {
		return logger;
	}

}
