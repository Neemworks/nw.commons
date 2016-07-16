package nw.commons.props.text;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class LinePropertiesTest {
	
	private LineProperties props;
	
	@Before
	public void init(){
		props = new LineProperties("test.properties");
		props.set("props.1", "1", "property one");
		props.set("props.2", "2", "property two");
		props.set("props.3", "2", "property 3");
		props.set("props.4", "2", "property 4");
		props.set("props.5", "2", "property 5");
		props.set("props.6", "2", "property 6");
		props.set("props.7", "2", "property 7");
		props.set("props.8", "2", "property 8");
		props.set("props.9", "2", "property 9");
		props.set("props.10", "2", "property 10");
		props.set("props.11", "2", "property 11");
		props.set("props.12", "2", "property 12");
		props.set("props.13", "2", "property 13");
		props.set("props.14", "2", "property 14");
		props.set("props.15", "2", "property 15");
		props.set("props.16", "false", "property 16");
		props.set("props.17", " 2", "property 17");
		props.set("props-18", "2 ", "property 18");
		props.set("props-19", " true ", "property 19");
		props.set("props.20", "222", "property twenty");
		
	}

	@Test
	public void testSetProperty() {
		System.out.println("Testing LineProperties setProperty");
		props.set("dummy.key", "Dummy", "DUmmy Key");
		assertEquals(props.get("dummy.key"), "Dummy");
	}

	@Test
	public void testGetProperty() {
		System.out.println("Testing LineProperties getProperty");
		assertEquals(props.get("props.20"), "222");
	}

	@Test
	public void testRemoveProperty() {
		System.out.println("Testing LineProperties removeProperty");
		props.removeProperty("dummy.key");
		assertNull(props.get("dummy.key"));
	}

	@Test
	public void testGetInt() {
		System.out.println("Testing LineProperties getInt");
		assertEquals(props.getInt("props.20", -1), new Integer(222));
	}

	@Test
	public void testGetLong() {
		System.out.println("Testing LineProperties getLong");
		assertEquals(props.getLong("props.20", -1L), new Long(222));
	}

	@Test
	public void testGetBigDecimal() {
		System.out.println("Testing LineProperties getBigDecimal");
		assertEquals(props.getBigDecimal("props.20", new BigDecimal("0")), new BigDecimal(222));
	}

	@Test
	public void testGetDouble() {
		System.out.println("Testing LineProperties getDouble");
		assertEquals(props.getDouble("props.20", 0.0), new Double(222.0));
	}

	@Test
	public void testGetFloat() {
		System.out.println("Testing LineProperties getFloat");
		assertEquals(props.getFloat("props.20", -1.0f), new Float("222"));
	}

	@Test
	public void testGetBool() {
		System.out.println("Testing LineProperties getIBool");
		assertEquals(props.getBool("props.16", true), Boolean.FALSE);
	}
	
	@Test
	public void testValueTrimming() {
		System.out.println("Testing LineProperties Value Trimming");
		System.out.println(props.getBool("props-19", false));
		System.out.println(props.getInt("props-18", new Integer(12)));
		assertTrue(props.getBool("props-19", false));
	}

}
