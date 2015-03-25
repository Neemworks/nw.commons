package nw.commons.util;

import nw.commons.NeemClazz;

/**
 * Various utility operations using threads
 * @author kulgan
 *
 */
public class AsyncFactory extends NeemClazz{

	/**
	 * 
	 * @param proc instance of runnable to execute as thread
	 * @param processName name of process
	 * @param autoStart should thread be started automatically
	 * @param daemon should the report run as a daemon
	 */
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
	
	/**
	 * 
	 * @param clazz must have a default constructor
	 * @param processName unique name for the thread
	 * @param numberOfProcess number of threads to spawn
	 */
	public static void spawnMultiple(Class<?> clazz, String processName, int numberOfProcess){
		for(int z = 0; z <= numberOfProcess; z++){
			try {
				Runnable proc = (Runnable) clazz.getConstructor().newInstance();
				spawnRunnable(proc, processName + "_" + z);
			} catch (Exception e) {
				se(AsyncFactory.class, "", e);
			}
		}
	}
}
