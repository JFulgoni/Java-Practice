public class Dog extends Animal{
	
	public static int numLegs = 4;

	public Dog(){
		super();
	}
	
	public Dog(String name){
		super(name);
	}
	
	public Dog(String name, int id){
		super(name, id);
	}
	
	@Override
	public String toString(){
		return this.getName() + " \"Woof!\"";
	}
	
	
}
