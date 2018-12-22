
//import java.util.HashMap;
import java.util.HashSet;

public class Animal {
	private String name;
	private static int uniqueId = 0; //makes a new id for each animal
	private int animalId;
	private static HashSet<Integer> idSet = new HashSet<Integer>();
	
	public Animal(){
		name = "Dog";
		animalId = ++uniqueId;
		while(idSet.contains(animalId)){
			animalId = ++uniqueId;
		}
		idSet.add(animalId);
	}
	
	public Animal(String name){
		this.name = name;
		animalId = ++uniqueId;
		while(idSet.contains(animalId)){
			animalId = ++uniqueId;
		}
		idSet.add(animalId);
	}
	
	public Animal(String name, int givenId){
		this.name = name;
		animalId = givenId;
		while(idSet.contains(givenId)){
			System.out.println("Id (" + animalId + ") for " + name + " already exists");
			animalId = ++givenId;
		}
		idSet.add(animalId);
	}

	public int getAnimalId() {
		return animalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return this.name;
	}
	
	public String printId(){
		return " (" + this.animalId + ") ";
	}
}
