package nw.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Property of Neemworks Limited Base class providing access to log factory and
 * property files. Eliminates the need to define these items while working. This
 * class is designed to be extended
 * 
 * @author Ogwara O. Rowland (r.ogwara@nimworks.com)
 * @version 0.1
 * @since 11th May, 2013
 * 
 */
public class NeemClazz {
    /**
     * logging
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Properties file manipulations
     */
    protected BaseProperties appProps = BaseProperties.getInstance();

}
