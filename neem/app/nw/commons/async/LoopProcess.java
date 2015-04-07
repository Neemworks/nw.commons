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

import java.util.UUID;

import nw.commons.NeemClazz;
import nw.commons.StopWatch;
import nw.commons.enums.ProcessState;

/**
 * Basic signature of a loop process. A process that repeats a particular action
 * (the process method) infinitely while sleeping for (sleepTime) milliseconds.
 * The process can be paused and unpaused and even stopped using the processState attribute
 * @author Ogwara O. Rowland
 *
 */
public abstract class LoopProcess extends NeemClazz implements Runnable{

	private Long sleepTime = 1L;
	private String processId;
	private ProcessState processState = ProcessState.ACTIVE;

	@Override
	public void run() {
		debug("Starting process with processId: " + processId);
		StopWatch  sw = new StopWatch();
		if(processId == null){
			processId = UUID.randomUUID().toString(); // Generate identifier for this process
		}
		while(processState != ProcessState.STOP){
			StopWatch pw = new StopWatch();
			doWork();
			debug("Current action has been concluded. " + processId + " Run Time: " + pw.elapsedTime() + " ms");
			sleep();
		}
		debug("Process has been terminated. " + processId + " Run Time: " + sw.elapsedTime() + " ms");
	}

	public Long getSleepTime() {
		return sleepTime;
	}

	/**
	 * Sets the time in milliseconds the process should wait before the next call
	 * @param sleepTime time in milliseconds
	 */
	public void setSleepTime(Long sleepTime) {
		this.sleepTime = sleepTime;
	}

	private final void doWork(){
		if(processState == ProcessState.PAUSE){
			pauseProcess();
		}
		process();
	}


	/**
	 * Pauses the current process until the resume method is called
	 *
	 */
	private final void pauseProcess() {
		synchronized (this) {
			debug("Process has been paused: pid " + processId);
			processState = ProcessState.PAUSE;
			try {
				this.wait();
			} catch (Exception e) {
				logger.error("Interrupted Exception while pausing process: ", e);
			}
		}

	}

	/**
	 * resumes the current process
	 */
	public final void resumeProcess(){
		synchronized (this) {
			processState = ProcessState.ACTIVE;
			debug("Process has been resumed: pid " + processId);
			this.notify();
		}
	}

	private void sleep(){
		try {
			Thread.sleep(getSleepTime());
		} catch (InterruptedException e) {
			logger.error("Interrupted Exception while sleeping process: ", e);
		}
	}

	public ProcessState getProcessState() {
		return processState;
	}

	/**
	 * Update the process state
	 * @param processState see {@link ProcessState}
	 */
	public void setProcessState(ProcessState processState) {
		this.processState = processState;
	}

	/**
	 *
	 * @return the processId for this task
	 */
	public String getProcessId() {
		return processId;
	}

	public abstract void process();

}
