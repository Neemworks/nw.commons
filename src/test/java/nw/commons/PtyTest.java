package nw.commons;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nw.commons.beans.TestProperty;

public class PtyTest {

	private static TestProperty tp;

	@BeforeClass
	public static void init(){
		tp = new TestProperty();
	}

	@Test
	public void testSetProperty(){
		tp.getPropertie().setProperty("hell.cat", "holocaust", "Evil Springs");
		Assert.assertEquals(tp.getPropertie().getProperty("hell.cat", "1"), "holocaust");

	}

	@Test
	public void testUpdateProperty(){
		tp.getPropertie().setProperty("hell.cat", "holocaust evil", "Evil Springs");
		Assert.assertEquals(tp.getPropertie().getProperty("hell.cat", "1"), "holocaust evil");
	}

	@Test
	public void testRemoveProperty(){
		tp.getPropertie().removeProperty("hell.cat");
		Assert.assertEquals(tp.getPropertie().getProperty("hell.cat", "-1"), "-1");
	}

}
