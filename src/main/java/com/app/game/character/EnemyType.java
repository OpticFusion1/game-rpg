package com.app.game.character;

import java.io.Serializable;

public enum EnemyType implements Serializable{
	SKELETON("1"), GREMLIN("2"), ORC("3") ;
	
	EnemyType(String num) {
		this.number = num;
	}
	
	private final String number;
	
	public static EnemyType getChoice(String num) {
		for (EnemyType type: EnemyType.values()) {
			if(type.number.equals(num)) {
				return type;
			}
		}
		return null;
	}
}
