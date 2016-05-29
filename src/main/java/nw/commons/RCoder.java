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

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import nw.commons.exception.NwException;

/**
 * The utility class for base encoding and decoding
 *
 * @author Ogwara O. Rowland
 */
public class RCoder {

	/**
	 * Encodes a plain text to base 64.
	 *
	 * @param text <i> Plain string to be encoded </i>
	 * @return Base64 encoded string
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public String base64encode(String text) {

		String encText = null;
		try {
			encText = new String(DatatypeConverter.printBase64Binary(text.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			throw new NwException("Provided encoding is unknown");
		}
		return encText;
	}

	/**
	 * Decodes a base 64 text to plain text.
	 *
	 * @param coded <i> Base 64 encoded string </i>
	 * @return plain text string
	 */
	public String base64decode(String coded) {
		String decText = new String(DatatypeConverter.parseBase64Binary(coded));
		return decText;
	}

}
