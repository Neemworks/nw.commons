package nw.commons;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class RCoderTest {

	@Test
	public void testEncode() {
		RCoder r = new RCoder();
		String encText = "";
		try {
			encText = r.encode("openminds");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("b3Blbm1pbmRz", encText);
	}

	@Test
	public void testDecode() {
		RCoder r = new RCoder();
		String decText = "";
		decText = r.decode("b3Blbm1pbmRz");
		assertEquals("openminds", decText);
	}

}
