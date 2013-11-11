package nw.commons.cache;

import java.util.concurrent.ConcurrentHashMap;

import nw.commons.NeemClazz;
import nw.commons.BaseProperties;

public class PropertiesCache extends NeemClazz{
	
	private static ConcurrentHashMap<String, BaseProperties> pties = new ConcurrentHashMap<String, BaseProperties>();

	public static BaseProperties getPropertyFile(String file) {
		BaseProperties pf = pties.get(file);
		if(pf == null){
			pf = new BaseProperties(file);
			pties.put(file, pf);
		}
		return pf;
	}
	
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
