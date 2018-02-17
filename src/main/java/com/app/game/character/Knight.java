package com.app.game.character;

import com.app.game.utils.Limit;

public class Knight extends Character {

	private static final long serialVersionUID = 4639397451503985556L;
	
	public Knight() {
		super("Knight", 20, 250, new Limit(1,10));
	}
		
}
