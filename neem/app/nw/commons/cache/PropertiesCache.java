package nw.commons.cache;

import java.util.concurrent.ConcurrentHashMap;

import nw.commons.NeemClazz;
import nw.commons.BaseProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertiesCache.
 */
public class PropertiesCache extends NeemClazz{
	
	/** The pties. */
	private static ConcurrentHashMap<String, BaseProperties> pties = new ConcurrentHashMap<String, BaseProperties>();

	/**
	 * Gets the property file.
	 *
	 * @param file the file
	 * @return the property file
	 */
	public static BaseProperties getPropertyFile(String file) {
		BaseProperties pf = pties.get(file);
		if(pf == null){
			pf = new BaseProperties(file);
			pties.put(file, pf);
		}
		return pf;
	}
	
	/**
	 * Gets the property file.
	 *
	 * @return the property file
	 */
	public static BaseProperties getPropertyFile() {
		String file = "application.properties";
		BaseProperties pf = pties.get(file);
		if(pf == null){
			pf = new BaseProperties(file);
			pties.put(file, pf);
		}
		return pf;
	}

}
