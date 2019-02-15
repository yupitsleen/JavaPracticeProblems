package Inheritance;


public class Archer extends Human {
	//inherits fields and methods of its Inheritance (humans) superclass
		//add more fields and methods
	private int numArrows = 0;
	
	
	public Archer(String name, int startingArrows) {
		super(name, 20, 50);
		findArrows();
		numArrows = startingArrows;
	}
	
	private void findArrows() {        
		int numArrowsFound = randomGenerator.nextInt(10) + 1;
        System.out.println(getName() + ": Found "
                + numArrowsFound + " arrows!");
        numArrows += numArrowsFound;
        System.out.println(getName() + ": I now have " + numArrows + " arrows.");
	}
	
	@Override
	public void defend() {
		
	}
	
	@Override
	public void jump() {
		
	}
	
	@Override
	public int heal() { return 0; }

	@Override
	public void attack(Character opponent) {
		 System.out.println(getName() + ": Attacking " + opponent.getName()
                + " with my arrows!");
        opponent.decreaseHealth(getAttackPower());
	}
	
}
