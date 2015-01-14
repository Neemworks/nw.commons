package nw.commons.dispatch;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dispatch")
public class Dispatch {
	
	private String url;
	
	private String module;
	
	@XmlElement(name = "url", required = true)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@XmlElement(name = "module", required = true)
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}
