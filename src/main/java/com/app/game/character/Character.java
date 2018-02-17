package com.app.game.character;

import java.io.Serializable;

import com.app.game.utils.Limit;

public abstract class Character implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String name;
    private int damage;
    private int health;
    private Limit limit;
    
    
    public Character(){
    }
    
	public Character(String name, int damage, int health, Limit limit) {
		super();
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.limit = limit;
	}

	public final String getName() {
		return name;
	}

	public final int getDamage() {
		return damage;
	}

	public final int getHealth() {
		return health;
	}
	
	public final void enhanceDamage(int damage) {
		this.damage += damage;
	}
	
	public final void enhanceHealth(int health) {
		this.health += health;
	}
	
	public final void looseHealth(int health) {
		this.health -= health;
	}
	
	public final Limit getLimit() {
		return limit;
	}

	public final int fight() {
		return damage + limit.getRandom();
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public String toString() {
		return String.format("%s H:%d ", getName(), getHealth());
	}
}
