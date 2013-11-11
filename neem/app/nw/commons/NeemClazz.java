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
public class NeemClazz {
    /**
     * logger
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Default Properties file manipulations (application.properties)
     */
    protected BaseProperties appProps = PropertiesCache.getPropertyFile();
    
    /**
     * static debug logging
     * @param clz
     * @param e
     */
    protected static void sd(Class<? extends NeemClazz> clz, String msg){
    	LoggerFactory.getLogger(clz).debug(msg);
    }
    
    /**
     * static info logging
     * @param clz
     * @param e
     */
    protected static void si(Class<? extends NeemClazz> clz, String msg){
    	LoggerFactory.getLogger(clz).info(msg);
    }
    
    /**
     * static trace logging
     * @param clz
     * @param e
     */
    protected static void st(Class<? extends NeemClazz> clz, String msg){
    	LoggerFactory.getLogger(clz).trace(msg);
    }
    
    /**
     * static warn logging
     * @param clz
     * @param e
     */
    protected static void sd(Class<? extends NeemClazz> clz, String msg, Throwable t){
    	LoggerFactory.getLogger(clz).warn(msg, t);
    }
    
    /**
     * static error logging
     * @param clz
     * @param t 
     * @param e
     */
    protected static void se(Class<? extends NeemClazz> clz, String msg, Throwable t){
    	LoggerFactory.getLogger(clz).error(msg, t);
    }

}
