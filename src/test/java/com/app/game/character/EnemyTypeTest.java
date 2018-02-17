package com.app.game.character;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnemyTypeTest {
	
	@Test
	public final void testGetChoice() {
		assertEquals(EnemyType.SKELETON,EnemyType.getChoice("1"));
		assertEquals(EnemyType.GREMLIN,EnemyType.getChoice("2"));
		assertEquals(EnemyType.ORC,EnemyType.getChoice("3"));
	}

}
