package com.app.game.character;

import java.io.Serializable;

public enum HeroType implements Serializable{
	KNIGHT("1"), ARCHER("2");
	
	HeroType(String num) {
		this.number = num;
	}
	
	private final String number;
	
	public static HeroType getChoice(String num) {
		for (HeroType type: HeroType.values()) {
			if(type.number.equals(num)) {
				return type;
			}
		}
		return null;
	}
}
