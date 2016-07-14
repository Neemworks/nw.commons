package nw.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides none static slf4j logger access to
 * classes that extend it
 * @author Ogwara O. Rowland
 * @since 1.3.0
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
    

    /**
     * static debug logging.
     *
     * @param clz class to be debugged
     * @param msg message to log
     */
    protected static void sd(Class<?> clz, String msg){
    	LoggerFactory.getLogger(clz).debug(msg);
    }

    /**
     * static info logging.
     *
     * @param clz class to be debugged
     * @param msg message to log
     */
    protected static void si(Class<?> clz, String msg){
    	LoggerFactory.getLogger(clz).info(msg);
    }

    /**
     * static trace logging.
     *
     * @param clz class to be debugged
     * @param msg message to log
     */
    protected static void st(Class<?> clz, String msg){
    	LoggerFactory.getLogger(clz).trace(msg);
    }

    /**
     * static warn logging.
     *
     * @param clz class to be logged
     * @param msg message to log
     * @param t exception to log
     */
    protected static void sd(Class<?> clz, String msg, Throwable t){
    	LoggerFactory.getLogger(clz).warn(msg, t);
    }

    /**
     * static error logging.
     *
     * @param clz class to be logged
     * @param msg message to log
     * @param t exception to log
     */
    protected static void se(Class<?> clz, String msg, Throwable t){
    	LoggerFactory.getLogger(clz).error(msg, t);
    }

}
