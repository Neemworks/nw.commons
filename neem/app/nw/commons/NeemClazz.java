/*
 * Property of Neemworks Nigeria 
 * Copyright 2013 - 2015, all rights reserved
 */
package nw.commons;

import nw.commons.cache.PropertiesCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class providing access to log factory and
 * property files. Eliminates the need to define these items while working. This
 * class is meant to be extended
 * 
 * @author Ogwara O. Rowland (r.ogwara@nimworks.com)
 * @version 0.2
 * @since 10th November, 2013
 * 
 */
public abstract class NeemClazz {
    
    /** logger. */
    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    /** Enables or disables debug mode on. */
    private static boolean debugModeOn;
    
    /**
     * Specifies the name of the properties file to use
     */
    private String targetPropertyFilename = "application.properties";

    /**
     * Default Properties file manipulations (application.properties)
     */
    protected AppProperties appProps;
    
    /**
     * Initialization
     */
    public NeemClazz(){
    	appProps = PropertiesCache.getPropertyFile(getTargetPropertyFilename());
    }
    
    
    /**
     * Debug.
     *
     * @param msg the msg
     */
    public void debug(String msg){
    	if(isDebugModeOn()){
    		logger.debug(msg);
    	}
    }
    
    /**
     * static debug logging.
     *
     * @param clz class to be debugged
     * @param msg message to log
     */
    protected static void sd(Class<? extends NeemClazz> clz, String msg){
    	LoggerFactory.getLogger(clz).debug(msg);
    }
    
    /**
     * static info logging.
     *
     * @param clz class to be debugged
     * @param msg message to log
     */
    protected static void si(Class<? extends NeemClazz> clz, String msg){
    	LoggerFactory.getLogger(clz).info(msg);
    }
    
    /**
     * static trace logging.
     *
     * @param clz class to be debugged
     * @param msg message to log
     */
    protected static void st(Class<? extends NeemClazz> clz, String msg){
    	LoggerFactory.getLogger(clz).trace(msg);
    }
    
    /**
     * static warn logging.
     *
     * @param clz class to be logged
     * @param msg message to log
     * @param t exception to log
     */
    protected static void sd(Class<? extends NeemClazz> clz, String msg, Throwable t){
    	LoggerFactory.getLogger(clz).warn(msg, t);
    }
    
    /**
     * static error logging.
     *
     * @param clz class to be logged
     * @param msg message to log
     * @param t exception to log
     */
    protected static void se(Class<? extends NeemClazz> clz, String msg, Throwable t){
    	LoggerFactory.getLogger(clz).error(msg, t);
    }

	/**
	 * Checks if is debug mode on.
	 *
	 * @return true, if is debug mode on
	 */
	public boolean isDebugModeOn() {
		return debugModeOn;
	}

	/**
	 * Sets the debug mode on.
	 *
	 * @param debugModeOn the new debug mode on
	 */
	public void setDebugModeOn(boolean debugModeOn) {
		NeemClazz.debugModeOn = debugModeOn;
	}


	public String getTargetPropertyFilename() {
		return targetPropertyFilename;
	}


	public void setTargetPropertyFilename(String targetPropertyFilename) {
		this.targetPropertyFilename = targetPropertyFilename;
	}

}
