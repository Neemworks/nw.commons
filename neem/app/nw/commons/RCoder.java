package nw.commons;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Ogwara O. Rowland
 * @version 0.1
 * @since 14th May, 2013
 *
 */
public class RCoder {

	/**
	 *
	 * @param text
	 *            <i> Plain string to be encoded </i>
	 * @return Base64 encoded string
	 */
	public String encode(String text) {
		return new BASE64Encoder().encode(text.getBytes());
	}

	/**
	 *
	 * @param coded
	 *            <i> Base 64 encoded string </i>
	 * @return plain text string
	 * @throws IOException
	 */
	public String decode(String coded) throws IOException {
		return new String(new BASE64Decoder().decodeBuffer(coded));
	}

}
