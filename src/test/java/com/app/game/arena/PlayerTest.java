package com.app.game.arena;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

import com.app.game.character.HeroType;

public class PlayerTest {
	
	@Test
	public final void testGetChoice() {
		String choice = "1";
		System.setIn(new ByteArrayInputStream(choice.getBytes()));
		Scanner scanner = new Scanner(System.in);
		Player player = new Player(scanner);
		assertEquals(HeroType.KNIGHT, player.getChoice());
	}

	@Test
	public final void testGetAction() {
		String choice = "1";
		System.setIn(new ByteArrayInputStream(choice.getBytes()));
		Scanner scanner = new Scanner(System.in);
		Player player = new Player(scanner);
		assertEquals(Action.ATTACK, player.getAction());
	}

	@Test
	public final void testPlayAgain() {
		String choice = "y";
		System.setIn(new ByteArrayInputStream(choice.getBytes()));
		Scanner scanner = new Scanner(System.in);
		Player player = new Player(scanner);
		assertTrue(player.playAgain());
	}

}
