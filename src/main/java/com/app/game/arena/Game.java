package com.app.game.arena;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Game {
	
	private Scanner scanner;
	private Battle battle;

	public Game() {
		this.scanner = new Scanner(System.in);
	}

	
	private void start() {
		if (isLoading()) {
			battle = load();
			if (battle != null) {
				battle.start(false);
			}
		} else {
			battle = new Battle();
			battle.start(true);
		}
	}


	private Battle load() {
        try (FileInputStream file = new FileInputStream(Battle.FILE_NAME);
             ObjectInputStream in = new ObjectInputStream(file)) {
        	    battle = (Battle) in.readObject();
            battle.showStats();
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("Game loading error : %s%n New game starting...%n", e.getMessage());
            battle = new Battle();
            battle.start(true);
        }
        return battle;
    }

	private boolean isLoading() {
		System.out.println("Do you want to load game ? [Y/N]");
		String input = scanner.nextLine();
		return input.toUpperCase().equals("Y");
	}
    
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
}
