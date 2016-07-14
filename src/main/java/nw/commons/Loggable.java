package nw.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Loggable {
	
	/** simple slf4j logger. */
    protected Logger logger = LoggerFactory.getLogger(getClass());

}
