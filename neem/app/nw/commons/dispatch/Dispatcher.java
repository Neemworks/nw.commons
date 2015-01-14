package nw.commons.dispatch;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dispatcher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dispatcher {
	
	@XmlElement(name = "dispatch")
	private List<Dispatch> entries;
	
	public void addEntry(Dispatch entry){
		if(entries == null){
			entries = new ArrayList<Dispatch>();
		}
		entries.add(entry);
	}
	
	public List<Dispatch> getEntries(){
		return entries;
	}

}
