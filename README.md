# game-rpg

Console text-based RPG game

How to play:

1) there are 2 ways of start:
	-- start new game;
	-- load saved game;
	   --- if saved game does not exists, new game will be started;

2) choose a hero [1 = KNIGHT, 2 = ARCHER]
    -- KNIGHT has more damage but less health;
    -- ARCHER has less damage but more health;

3) enemies auto-generates in range between 7 and 20;
    
    
4) choose your action : [1 = ATTACK, 2 = CURE, 3 = SHOW_STATISITC, 4 = SAVE_GAME]
	-- ATTACK apply hero damage + random generated delta to first alive enemy from the list;
	-- CURE increase hero health on 20 points;
	-- SHOW_STATISITC show game statistics;
	-- SAVE_GAME;