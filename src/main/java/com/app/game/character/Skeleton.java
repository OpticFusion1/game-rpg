package com.app.game.character;

import com.app.game.utils.Limit;

public class Skeleton extends Character {

	private static final long serialVersionUID = 682762709557508514L;
	
	public Skeleton() {
		super("Skeleton", 1, 10, new Limit(1,3));
	}

}
