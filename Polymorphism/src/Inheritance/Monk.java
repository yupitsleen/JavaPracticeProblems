package Inheritance;

public class Monk extends Human {
	
	public Monk (String name) {
		super(name, 20, 70);        
		System.out.println(name + ": Let's work some magic!");

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
		// TODO Auto-generated method stub
		        System.out.println("Attacking " + opponent.getName() + " with magical wand!");

	}

	@Override
	public void defend() {
		// TODO Auto-generated method stub
		
	}
}
