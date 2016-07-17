package nw.commons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nw.commons.beans.TestClazz;

public class NeemClazzTest {

	private TestClazz tp;

	@Before
	public void init(){
		tp = new TestClazz();
	}

	@Test
	public void testSetProperty(){
		tp.getProperties().setProperty("hell.cat", "holocaust", "Evil Springs");
		Assert.assertEquals(tp.getProperties().getProperty("hell.cat", "1"), "holocaust");

	}

	@Test
	public void testUpdateProperty(){
		tp.getProperties().setProperty("hell.cat", "holocaust evil", "Evil Springs");
		Assert.assertEquals(tp.getProperties().getProperty("hell.cat", "1"), "holocaust evil");
	}

	@Test
	public void testRemoveProperty(){
		tp.getProperties().removeProperty("hell.cat");
		Assert.assertEquals(tp.getProperties().getProperty("hell.cat", "-1"), "-1");
	}

}
