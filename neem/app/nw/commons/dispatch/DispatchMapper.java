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
package nw.commons.dispatch;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import nw.commons.NeemClazz;

public class DispatchMapper extends NeemClazz{
	
	private Map<Pattern, String> map;
	private String page404;
	
	public DispatchMapper() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	protected void init(){
		logger.debug("Initializing URL Mapper");
		page404 = appProps.getProperty("", "/WEB-INF/html/status/404.jsp");
		loadMappings();
	}
	
	private void loadMappings(){
		try {
			map = new HashMap<Pattern, String>();
			JAXBContext ctx = JAXBContext.newInstance(Dispatcher.class);
			Unmarshaller um = ctx.createUnmarshaller();
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("route.xml");
			Dispatcher dl = (Dispatcher) um.unmarshal(is);
			logger.debug(dl + " list");
			if(dl != null){
				for(Dispatch de: dl.getEntries()){
					logger.debug(" [url: " + de.getUrl() + " jsp: " + de.getModule() + " }");
					map.put(Pattern.compile(de.getUrl(), Pattern.CASE_INSENSITIVE), de.getModule());
				}
			}
		} catch (Exception e) {
			logger.error("Exception ", e);
		}
	}
	
	public String getCommand(String page){
		for(Pattern p: map.keySet()){
			if(p.matcher(page).matches()){
				return map.get(p);
			}
		}
		
		return page404;
	}
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext ctx = JAXBContext.newInstance(Dispatcher.class);
		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		Dispatch de = new Dispatch();
		de.setModule("sss");
		de.setUrl("sss");
		
		Dispatcher dl = new Dispatcher();
		dl.addEntry(de);
		dl.addEntry(de);
		
		StringWriter sw = new StringWriter();
		m.marshal(dl, sw);
		System.out.println(sw.toString());
		
	}

}
