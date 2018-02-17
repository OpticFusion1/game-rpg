package com.app.game.arena;

import java.io.Serializable;

public interface Choice extends Serializable{
	Enum<?> getChoice();
	Enum<?> getAction();
	
}
