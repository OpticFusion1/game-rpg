package com.app.game.character;

import java.io.Serializable;

import com.app.game.utils.Limit;

public class EnemyFactory implements Serializable{
	private static final long serialVersionUID = 3805695836021466091L;
	
	public Character createRandomEnemy() {
		Character enemy = null;
		int idx = (new Limit(1, EnemyType.values().length)).getRandom();
		EnemyType type = EnemyType.getChoice(String.valueOf(idx));
		
		if (type.equals(EnemyType.SKELETON)) {
			enemy = new Skeleton();
		} else if (type.equals(EnemyType.GREMLIN)) {
			enemy = new Gremlin();
		} else if (type.equals(EnemyType.ORC)) {
			enemy = new Orc();
		}
		return enemy;
	}
	
}
