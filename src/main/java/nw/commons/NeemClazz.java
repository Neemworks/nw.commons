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

import nw.commons.cache.PropertiesCache;
import nw.commons.logging.Loggable;
import nw.commons.props.KeyProperties;

import org.slf4j.LoggerFactory;

/**
 * Base class that includes logger and property file access
 *
 * @author Ogwara O. Rowland
 * @version 0.3
 *
 */
public abstract class NeemClazz extends Loggable{

    /** Enables or disables debug mode on. */
    private static boolean debugModeOn;

    /**
     * Property file name
     */
    private String targetPropertyFilename = "apps.properties";

    /**
     * Default Properties file manipulations (application.properties)
     */
    protected KeyProperties appProps;

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
