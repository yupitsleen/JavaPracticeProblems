package Inheritance;

public class Main {

	public static void main(String[] args) {
		Human human = new Warrior("Lisa");
		Human archer = new Archer("Samuel", 60);
		FireArcher fireArcher = new FireArcher("Emmanuel");
		Warrior warrior = new Warrior("Carolyn");
		
		System.out.println("\nStart Game\n");
		
		human.attack(fireArcher);
		archer.attack(warrior);
		warrior.attack(archer);
		fireArcher.attack(human);
		
		Archer niceArcher = new Archer("Tom", 9);
		Human modernArcher = new Archer("Stacey", 5);
		
		Dog modernDog = new Dog("Hunter", modernArcher);
		Pet petDog = new Dog("Buddy", niceArcher);
		
		modernArcher.attack(niceArcher);
		niceArcher.getPet().attack(modernArcher);
		modernArcher.attack(niceArcher.getPet());
		modernDog.attack(petDog.getOwner());
		petDog.attack(modernArcher.getPet());
		
	}
}
