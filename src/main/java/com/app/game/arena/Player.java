package com.app.game.arena;

import java.io.ObjectInputStream;
import java.util.Scanner;

import com.app.game.character.HeroType;

public class Player implements Choice {

	private static final long serialVersionUID = -3730603419253183082L;
	
	private transient Scanner scanner;

	public Player() {
		this.scanner = new Scanner(System.in);
	}

	public Player(Scanner scanner) {
		this.scanner = scanner;
	}
	
	@Override
	public HeroType getChoice() {
		System.out.println("Please, choose your hero : [1 = KNIGHT, 2 = ARCHER]");
		String input = scanner.nextLine();
		
		HeroType hero = HeroType.getChoice(input);
		
		if(hero != null)
			return hero;
		
		return getChoice();
	}

	@Override
	public Action getAction() {
		System.out.println("Please, choose your action : [1 = ATTACK, 2 = CURE, 3 = SHOW_STATISTIC, 4 = SAVE_GAME]");
		String input = scanner.nextLine();
		
		Action action = Action.getChoice(input);
		
		if(action != null)
			return action;
		
		return getAction();
	}
	
	public boolean playAgain() {
	    System.out.println("Do you want play again ? [Y/N]");
	    String input = scanner.nextLine();
	    return input.toUpperCase().equals("Y");
	}
	
	//restore scanner manually
	private void readObject(ObjectInputStream in) {
		try {
			in.defaultReadObject();
			scanner = new Scanner(System.in);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
