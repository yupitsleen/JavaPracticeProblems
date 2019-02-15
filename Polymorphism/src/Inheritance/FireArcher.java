package Inheritance;

public class FireArcher extends Archer {
	
	public FireArcher(String name) {
		super(name, 8);
	}
	int firePower = 1;
	
	public void attack(Character opponent) {
		System.out.println("Attacking " + opponent.getName() + "with fire arrows!");
		opponent.decreaseHealth(getAttackPower() + firePower);
	}
	
}
