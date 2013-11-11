package nw.commons.cache;

import java.util.Date;

import nw.commons.async.LoopProcess;

public class TR extends LoopProcess {

	@Override
	public void process() {
		System.out.println(new Date());
	}

}
