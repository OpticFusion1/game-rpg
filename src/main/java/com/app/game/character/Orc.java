package com.app.game.character;

import com.app.game.utils.Limit;

public class Orc extends Character{

	private static final long serialVersionUID = 3928515042311199618L;

	public Orc() {
		super("Orc", 5, 25, new Limit(1,5));
	}
	
}
