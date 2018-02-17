package com.app.game.character;

import java.io.Serializable;

import com.app.game.utils.Limit;

public class Archer extends Character implements Serializable{

	private static final long serialVersionUID = -2752682212595836582L;
	
	public Archer() {
		super("Archer", 15, 300, new Limit(1,7));
	}
	
	public Archer(String name, int damage, int health, Limit limit) {
		super(name, damage, health, limit);
	}

}
