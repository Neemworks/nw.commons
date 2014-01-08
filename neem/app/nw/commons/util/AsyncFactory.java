package nw.commons.util;

import nw.commons.NeemClazz;

/**
 * Various utility operations using threads
 * @author kulgan
 *
 */
public class AsyncFactory extends NeemClazz{

	public static void spawnRunnable(Runnable proc, String processName, boolean autoStart, boolean daemon){
		Thread t = new Thread(proc);
		t.setName(processName);
		if(daemon)
			t.setDaemon(daemon);
		if(autoStart)
			t.start();
	}
	
	/**
	 * Spawn a single thread
	 * @param proc Runnable class to spawn
	 * @param processName process name used to identify this thread
	 */
	public static void spawnRunnable(Runnable proc, String processName){
		spawnRunnable(proc, processName, true, false);
	}
}
