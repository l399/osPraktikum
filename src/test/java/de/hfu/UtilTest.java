package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testWrongInput() {
		Util.istErstesHalbjahr(14);
	}
	@Test
	public void testNichtErstesHalbjahr() {
		assertEquals(false, Util.istErstesHalbjahr(12));
	}
	@Test
	public void testErstesHalbjahr() {
		assertEquals(true, Util.istErstesHalbjahr(1));
	}
}
