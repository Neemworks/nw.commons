package nw.commons.async;

import java.util.UUID;

import nw.commons.NeemClazz;
import nw.commons.StopWatch;
import nw.commons.enums.ProcessState;

/**
 * Basic signature of a loop process. A process that repeats a particular action
 * (the process method) infinitely while sleeping for (sleepTime) milliseconds.
 * The process can be paused and unpaused and even stopped using the processState attribute
 * @author kulgan
 *
 */
public abstract class LoopProcess extends NeemClazz implements Runnable{
	
	private Long sleepTime = 1L;
	private String processId;
	private ProcessState processState = ProcessState.ACTIVE;

	@Override
	public void run() {
		StopWatch  sw = new StopWatch();
		if(processId == null)
			processId = UUID.randomUUID().toString(); // Generate identifier for this process
		System.out.println(processState == ProcessState.STOP);
		while(processState != ProcessState.STOP){
			StopWatch pw = new StopWatch();
			doWork();
			logger.info("Current action has been concluded. " + processId + " Run Time: " + pw.elapsedTime() + " ms");
			sleep();
		}

		logger.info("Process has been terminated. " + processId + " Run Time: " + sw.elapsedTime() + " ms");
	}
	
	private final void doWork(){
		try {
			if(processState == ProcessState.PAUSE)
				pauseProcess();
			else if(processState == ProcessState.RESUME)
				resume();
			process();
		} catch (InterruptedException e) {
			logger.error("Interrupted Exception while pausing process: ", e);
		}
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
	
	private final void pauseProcess() throws InterruptedException {
		synchronized (this) {
			logger.info("Process has been paused: pid " + processId);
			wait();
		}

	}
	
	private final void resume(){
		synchronized (this) {
			processState = ProcessState.ACTIVE;
			logger.info("Process has been resumed: pid " + processId);
			notify();
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
	 * @param processState
	 */
	public void setProcessState(ProcessState processState) {
		this.processState = processState;
	}

	public String getProcessId() {
		return processId;
	}

	public abstract void process();

}
