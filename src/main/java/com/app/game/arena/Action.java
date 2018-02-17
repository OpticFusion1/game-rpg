package com.app.game.arena;

import java.io.Serializable;

public enum Action implements Serializable{
	ATTACK("1"), CURE("2"), SHOW_STATISTIC("3"), SAVE_GAME("4");
	
	Action(String num) {
		this.number = num;
	}
	
	private final String number;
	
	public static Action getChoice(String num) {
		for (Action action: Action.values()) {
			if(action.number.equals(num)) {
				return action;
			}
		}
		return null;
	}
}
