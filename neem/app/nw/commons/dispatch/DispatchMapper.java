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
