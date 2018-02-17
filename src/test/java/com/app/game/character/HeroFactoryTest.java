package com.app.game.character;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeroFactoryTest {

	private HeroFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = new HeroFactory();
	}

	@Test
	public final void testGetHero() {
		Character knight = factory.getHero(HeroType.KNIGHT);
		assertTrue(knight instanceof Knight);
		
		Character archer = factory.getHero(HeroType.ARCHER);
		assertTrue(archer instanceof Archer);
	}

}
