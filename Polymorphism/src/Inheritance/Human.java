package Inheritance;

public abstract class Human implements Character {
	// video game human
	// fields and methods
	private static int numCharacters = 0;

	public static int getNumCharacters() {
		return numCharacters;
	}

	int age;
	int height;
	int numHumansInWorld = Human.getNumCharacters();

	protected String name;
	protected double health = 100.0;
	protected long experience = 0;
	protected int attackPower = 1;
	protected Pet pet;

	public Human(String name, int age, int height) {
		this.name = name;
		this.age = age;
		this.height = height;
		gainExperience(1);
		numCharacters++;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public int getAge() {
		return this.age;
	}

	public double getHealth() {
		return this.health;
	}

	public long getExperience() {
		return this.experience;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
		System.out.printf("%s: I have a new pet. Hi %s!\n", name, pet.getName());
	}

	public Pet getPet() {
		return pet;
	}

	public double heal(double additionalHealth) {
		this.health += additionalHealth;
		return this.health;
	}

	public void speak() {
		System.out.println("Hi! I am " + this.name + ".");
	}

	public long gainExperience(long experience) {
		this.experience += experience;
		return experience;
	}

	public long addAttackPower(long attackPower) {
		this.attackPower += attackPower;
		return attackPower;
	}

	public double decreaseHealth(int opponentAttackPower) {
		this.health -= opponentAttackPower;
		System.out.println(name + ": I've been hit. My health now = " + health);
		return this.health;
	}

	public abstract void jump();

	public abstract int heal();

	public abstract void attack(Character opponent);

	public abstract void defend();
}