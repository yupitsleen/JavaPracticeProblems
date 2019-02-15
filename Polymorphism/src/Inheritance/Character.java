package Inheritance;

import java.util.Random;

public interface Character {
	Random randomGenerator = new Random();
	
	String getName();
	double getHealth();
	long getExperience();
	int getAttackPower();
	
	void defend();
	void jump();
	int heal();
	void attack(Character opponent);
	double decreaseHealth(int opponentAttackPower);
	long gainExperience(long experience);
}
