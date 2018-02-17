package com.app.game.arena;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.app.game.character.Character;
import com.app.game.character.EnemyFactory;
import com.app.game.character.HeroFactory;
import com.app.game.character.HeroType;
import com.app.game.utils.Limit;

public class Battle implements Serializable{
	
	private static final long serialVersionUID = 4305831724714126438L;

	static final String FILE_NAME = '.' + File.separator + "saveGame.ser";

	private int enemiesCount;
	private List<Character> enemies;
	private Player player;
	private int numberOfBattles;
	private Character hero;
	private HeroFactory heroFactory;
	private EnemyFactory enemyFactory;
	private int cureTry;
	private int upgradesCount;

	public Battle() {
		this.player = new Player();
		this.heroFactory = new HeroFactory();
		this.enemyFactory = new EnemyFactory();
		this.enemies = new ArrayList<>();
		init();
	}

	private void init() {
		this.enemies.clear();
		this.enemiesCount = (new Limit(7, 20)).getRandom();
		this.enemies = Stream.generate(() -> enemyFactory.createRandomEnemy()).limit(enemiesCount).collect(Collectors.toList());
		numberOfBattles = 0;
		upgradesCount = 0;
		cureTry = 3;
	}

	private int getCountOfKilledEnemies() {
		return (int) enemies.stream().filter(p -> !p.isAlive()).count();
	}
	
	private List<Character> getAliveEnemies(){
		return enemies.stream().filter(p -> p.isAlive()).collect(Collectors.toList());
	}
	
	void showStats() {
		System.out.println("=========================================");
		System.out.printf("Number of battles: %s%n", numberOfBattles);
		System.out.printf("Number of enemies: %s%n", enemies.size());
		System.out.printf("Alive enemies: %s%n", getAliveEnemies());
		System.out.printf("Hero's health: %s%n", hero.getHealth());
		System.out.printf("Enemies killed: %s%n", getCountOfKilledEnemies());
		System.out.println("=========================================");
	}

	public void start(boolean isNew) {
		if(isNew) {
			System.out.println("New game started!");
			HeroType playerChoice = player.getChoice();
			hero = heroFactory.getHero(playerChoice);
			System.out.printf("Your choose : %s%n", playerChoice);
		}else {
			System.out.println("Game loaded!");
		}

		//if hero is alive or exists alive enemy
		while(hero.isAlive() || enemies.stream().filter(p -> p.isAlive()).count() > 0) {
			if(enemies.stream().filter(p -> p.isAlive()).count() == 0) {
				System.out.println("You win! All enemies are dead!");
				break;
			}
			if(!hero.isAlive()) {
				System.out.println("You loose!");
				break;
			}
			//for each 5 killed enemies hero earned +5 point to damage
			if(getCountOfKilledEnemies()/5 > upgradesCount) {
				System.out.println("You earned +5 points to damage!");
				hero.enhanceDamage(5);
				upgradesCount++;
			}
			Action action = player.getAction();			
			doAction(action);
		}
		
		if (player.playAgain()) {
			System.out.println();
			init();
			start(true);
		} else {
			showStats();
		}
	}

	private void doAction(Action action) {
		switch (action) {
		case ATTACK: //find first alive enemy and reduces his health
				enemies.stream()
						.filter(p -> p.isAlive())
						.findFirst()
						.get()
						.looseHealth(hero.fight());
				
				hero.looseHealth(enemies.stream()
										.filter(p -> p.isAlive())
										.map(p -> p.fight())
										.reduce(0, (a, b) -> a + b));
				numberOfBattles++;
				break;
		case CURE:
			if(cureTry > 0) {
				hero.enhanceHealth(20);
				cureTry--;
			}else {
				System.out.printf("You can't cure anymore!%n");
			}
			break;
		case SHOW_STATISTIC:
			showStats();
			break;
		case SAVE_GAME:
			saveGame();
			break;
		}

	}
	
    private void saveGame() {
        try (FileOutputStream file = new FileOutputStream(FILE_NAME);
             ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(this);
            System.out.println("Saved data to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Game saving error.");
            e.printStackTrace();
        }
    }
    
}
