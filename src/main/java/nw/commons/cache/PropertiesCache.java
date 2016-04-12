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
package nw.commons.cache;

import java.util.concurrent.ConcurrentHashMap;

import nw.commons.AppProperties;

/**
 * The Class PropertiesCache.
 */
public class PropertiesCache {

	/** The hashmap of referenced property files. */
	private static ConcurrentHashMap<String, AppProperties> pties = new ConcurrentHashMap<String, AppProperties>();

	/**
	 * Retrieves the property object by name
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
	 * Retrieves the default property object
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
