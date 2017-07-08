package nw.commons.beans;

import com.nimworks.NeemClazz;

public class TestClazz extends NeemClazz{

	public TestClazz() {
		super();
	}

	@Override
	public void setTargetPropertyFilename() {
		this.targetPropertyFilename = "test.properties";

	}

}
