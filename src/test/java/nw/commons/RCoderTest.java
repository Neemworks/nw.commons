package nw.commons;

import static org.junit.Assert.*;

import org.junit.Test;

public class RCoderTest {

	@Test
	public void testEncode() {
		System.out.println("RCoder encode");
		RCoder r = new RCoder();
		String encText = "";
		encText = r.base64encode("openminds");
		assertEquals("b3Blbm1pbmRz", encText);
	}

	@Test
	public void testDecode() {
		System.out.println("RCoder decode");
		RCoder r = new RCoder();
		String decText = "";
		decText = r.base64decode("b3Blbm1pbmRz");
		assertEquals("openminds", decText);
	}

}
