package nw.commons;

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

	}

	@Test
	public void testUpdateProperty(){
		tp.getPropertie().setProperty("hell.cat", "holocaust evil", "Evil Springs");
	}

	@Test
	public void testRemoveProperty(){
		tp.getPropertie().removeProperty("hell.cat");
	}

}
