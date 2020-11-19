package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {
	@Test(expected=IllegalArgumentException.class)
	public void testWrongInputm() {
		Util.istErstesHalbjahr(13);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testWrongInputl() {
		Util.istErstesHalbjahr(0);
	}
	@Test
	public void testNichtErstesHalbjahr() {
		for(int i=7; i<13; i++) {
		assertFalse(Util.istErstesHalbjahr(i));
		}
	}
	@Test
	public void testErstesHalbjahr() {
		for(int i=1; i<7; i++) {
			assertEquals(true, Util.istErstesHalbjahr(i));
		}
	}
}
