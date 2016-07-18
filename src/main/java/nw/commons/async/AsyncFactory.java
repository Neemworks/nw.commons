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
package nw.commons.async;

import nw.commons.exception.NwException;

/**
 * Utility operations spawning threads
 * @author kulgan
 *
 */
public abstract class AsyncFactory {

	/**
	 *
	 * @param proc instance of runnable to execute as thread
	 * @param processName name of process
	 * @param autoStart should thread be started automatically
	 * @param daemon should the report run as a daemon
	 */
	public static void spawnRunnable(final Runnable proc, final String processName, final boolean autoStart, final boolean daemon){
		final Thread t = new Thread(proc); 
		t.setName(processName);
		if(daemon){
			t.setDaemon(daemon);
		}
		if(autoStart){
			t.start();
		}
	}

	/**
	 * Spawn a single thread
	 * @param proc Runnable class to spawn
	 * @param processName process name used to identify this thread
	 */
	public static void spawnRunnable(final Runnable proc, final String processName){
		spawnRunnable(proc, processName, true, false);
	}

	/**
	 *
	 * @param clazz must have a default constructor
	 * @param processName unique name for the thread
	 * @param numberOfProcess number of threads to spawn
	 */
	public static void spawnMultiple(final Class<?> clazz, final String processName, final int numberOfProcess){
		for(int z = 0; z <= numberOfProcess; z++){
			try {
				final Runnable proc = (Runnable) clazz.getConstructor().newInstance();
				spawnRunnable(proc, processName + "_" + z);
			} catch (Exception e) {
				throw new NwException("Spawn encountered an error: ", e);
			}
		}
	}
}
