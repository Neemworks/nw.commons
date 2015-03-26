package nw.commons.cache;

import java.util.concurrent.ConcurrentHashMap;

import nw.commons.NeemClazz;
import nw.commons.AppProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertiesCache.
 */
public class PropertiesCache extends NeemClazz{
	
	/** The pties. */
	private static ConcurrentHashMap<String, AppProperties> pties = new ConcurrentHashMap<String, AppProperties>();

	/**
	 * Gets the property file.
	 *
	 * @param file the file
	 * @return the property file
	 */
	public static AppProperties getPropertyFile(String file) {
		AppProperties pf = pties.get(file);
		if(pf == null){
			pf = new AppProperties(file);
			pties.put(file, pf);
		}
		return pf;
	}
	
	/**
	 * Gets the property file.
	 *
	 * @return the property file
	 */
	public static AppProperties getPropertyFile() {
		String file = "application.properties";
		AppProperties pf = pties.get(file);
		if(pf == null){
			pf = new AppProperties(file);
			pties.put(file, pf);
		}
		return pf;
	}

}
