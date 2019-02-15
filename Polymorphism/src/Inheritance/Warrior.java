package Inheritance;

public class Warrior extends Human {
	
	public Warrior(String name) {
		super(name, 30, 50);
        System.out.println(name + ": Ready for battle!");

	}	
	

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int heal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void attack(Character opponent) {
		System.out.println("Attacking " + opponent.getName() + "with my sword!");
	}
	@Override
	public void defend() {
		// TODO Auto-generated method stub
		
	}
}
