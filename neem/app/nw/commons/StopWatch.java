/*
 * Property of Neemworks Nigeria 
 * Copyright 2013 - 2015, all rights reserved
 */
package nw.commons;

// TODO: Auto-generated Javadoc
/**
 * Basic Utility for monitoring time spent by code.
 *
 * @author Ogwara O. Rowland
 * @version 1.0
 */

public class StopWatch {
	
	/** The start time. */
	private long startTime;
	
	/** The total time spent. */
	private long total;
	
	/** is the stopwatch running. */
	boolean running = false;

	/**
	 * Instantiates a new stop watch.
	 */
	public StopWatch() {
		this(true);
	}

	/**
	 * Instantiates a new stop watch.
	 *
	 * @param paramBoolean
	 *            the param boolean specifies whether the stopwatch should be started
	 *            or not
	 */
	public StopWatch(boolean paramBoolean) {
		if (paramBoolean)
			start();
	}

	/**
	 * Elapsed time.
	 *
	 * @return the elapsed time in millisecond
	 */
	public long elapsedTime() {
		if (this.running)
			return this.total + System.currentTimeMillis() - this.startTime;
		return this.total;
	}

	/**
	 * Current elapsed time.
	 *
	 * @return the long
	 */
	public long currentElapsedTime() {
		if (this.running)
			return System.currentTimeMillis() - this.startTime;
		return 0L;
	}

	/**
	 * Resets the total time to zeroo.
	 */
	public void zero() {
		this.total = 0L;
		start();
	}

	/**
	 * Starts the stopwatch.
	 */
	public void start() {
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}

	/**
	 * Stops the stop watch if it is already running.
	 */
	public void stop() {
		if (this.running) {
			this.total += System.currentTimeMillis() - this.startTime;
			this.running = false;
		}
	}

	/**
	 * Marks an interval.
	 */
	public void mark() {
		stop();
		start();
	}

	/**
	 * Elapsed time to message.
	 *
	 * @param paramString the param string
	 * @return the elapsed time with a message
	 */
	public String elapsedTimeToMessage(String paramString) {
		return paramString + " in " + elapsedTime() + " ms.";
	}

	/**
	 * Current elapsed time to message.
	 *
	 * @param paramString the param string
	 * @return the current elapsed time with message
	 */
	public String currentElapsedTimeToMessage(String paramString) {
		return paramString + " in " + currentElapsedTime() + " ms.";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return super.toString() + "[running=" + this.running + ", startTime="
				+ this.startTime + ", total=" + this.total + "]";
	}
}