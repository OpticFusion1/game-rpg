package com.app.game.character;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EnemyFactoryTest {

	private EnemyFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = new EnemyFactory();
	}

	@Test
	public final void testCreateRandomEnemy() {
		Character enemy = factory.createRandomEnemy();
		assertTrue(enemy instanceof Orc || enemy instanceof Skeleton || enemy instanceof Gremlin);
	}

}
