package nw.commons;

/**
 * Basic Utility for monitoring time spent by code
 * 
 * @author Ogwara O. Rowland
 * @version 1.0
 * 
 */

public class StopWatch {
    private long startTime;
    private long total;
    boolean running = false;

    public StopWatch() {
	this(true);
    }

    /**
     * Instantiates a new stop watch.
     * 
     * @param paramBoolean
     *            the param boolean specifies whether the stop should be started
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

    public long currentElapsedTime() {
	if (this.running)
	    return System.currentTimeMillis() - this.startTime;
	return 0L;
    }

    public void zero() {
	this.total = 0L;
	start();
    }

    public void start() {
	this.startTime = System.currentTimeMillis();
	this.running = true;
    }

    public void stop() {
	if (this.running) {
	    this.total += System.currentTimeMillis() - this.startTime;
	    this.running = false;
	}
    }

    public void mark() {
	stop();
	start();
    }

    public String elapsedTimeToMessage(String paramString) {
	return paramString + " in " + elapsedTime() + " ms.";
    }

    public String currentElapsedTimeToMessage(String paramString) {
	return paramString + " in " + currentElapsedTime() + " ms.";
    }

    public String toString() {
	return super.toString() + "[running=" + this.running + ", startTime="
		+ this.startTime + ", total=" + this.total + "]";
    }
}