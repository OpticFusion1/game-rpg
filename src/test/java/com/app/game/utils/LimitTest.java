package com.app.game.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class LimitTest {
	
	private Limit limit;
	private ArrayList<Integer> list;

	@Before
	public void setUp() throws Exception {
		limit = new Limit(1,5);
		list = (ArrayList<Integer>) Stream.of(1,2,3,4,5).collect(Collectors.toList());
	}

	@Test
	public final void testGetRandom() {
		int val = limit.getRandom();
		assertTrue(list.contains(val));
		int val1 = limit.getRandom();
		assertTrue(list.contains(val1));
		int val2 = limit.getRandom();
		assertTrue(list.contains(val2));
		int val3 = limit.getRandom();
		assertTrue(list.contains(val3));
		int val4 = limit.getRandom();
		assertTrue(list.contains(val4));
	}

}
