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
package nw.commons;

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
	 * Instantiates a new stop watch. Counting starts automatically
	 */
	public StopWatch() {
		this(true);
	}

	/**
	 * Instantiates a new stop watch.
	 *
	 * @param start
	 *            Specifies whether the stopwatch should be started
	 *            or not
	 */
	public StopWatch(boolean start) {
		if (start)
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
		if (this.running){
			return System.currentTimeMillis() - this.startTime;
		}
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