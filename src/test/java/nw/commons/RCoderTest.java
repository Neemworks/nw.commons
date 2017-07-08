package nw.commons;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nimworks.RCoder;

public class RCoderTest {

	@Test
	public void testEncode() {
		RCoder r = new RCoder();
		String encText = "";
		encText = r.base64encode("openminds");
		assertEquals("b3Blbm1pbmRz", encText);
	}

	@Test
	public void testDecode() {
		RCoder r = new RCoder();
		String decText = "";
		decText = r.base64decode("b3Blbm1pbmRz");
		assertEquals("openminds", decText);
	}

}
