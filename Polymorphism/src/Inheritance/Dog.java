package Inheritance;

public class Dog extends Pet {
	public Dog(String name, Human owner) {
		super(name, owner);
		bark();
	}

	public void bark() {
		System.out.println("Woof woof!");
	}

	@Override
	public void attack(Character opponent) {
		System.out.println(getName() + ": Biting " + opponent.getName());
		opponent.decreaseHealth(getAttackPower());
	}
	
	@Override
	public void cry() {
		System.out.println("Waaaa");
	}

	@Override
	public void defend() {

	}

	@Override
	public void jump() {

	}

	@Override
	public int heal() {
		return 0;
	}

}
