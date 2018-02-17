package com.app.game.character;

import java.io.Serializable;

public class HeroFactory implements Serializable{
	
	private static final long serialVersionUID = -5552380885829694756L;

	public Character getHero(HeroType type){
		Character hero = null;
		if(type.equals(HeroType.KNIGHT)) {
			hero = new Knight();
		} else if(type.equals(HeroType.ARCHER)) {
			hero = new Archer();
		} 
		return hero;
	}
	
}
