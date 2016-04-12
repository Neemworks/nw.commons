package nw.commons;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class StopWatchTest {

	@Test
	public void testElapsedTime() {
		Date now = new Date();

		sleep(10);
		StopWatch sw = new StopWatch();


		assertEquals(sw.elapsedTime(), new Date().getTime() - now.getTime());
	}

	@Test
	public void testCurrentElapsedTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testZero() {
		StopWatch sw = new StopWatch();
		System.out.println("Elapsed time: " + sw.elapsedTime());
		long elapsedTime = sw.elapsedTime();
		sleep(10);
		sw.zero();
		assertThat(elapsedTime, greaterThan(sw.elapsedTime()));
	}

	@Test
	public void testStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testStop() {
		fail("Not yet implemented");
	}

	@Test
	public void testMark() {
		fail("Not yet implemented");
	}

	@Test
	public void testElapsedTimeToMessage() {
		fail("Not yet implemented");
	}

	@Test
	public void testCurrentElapsedTimeToMessage() {
		fail("Not yet implemented");
	}

	private void sleep(long timeout){
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
