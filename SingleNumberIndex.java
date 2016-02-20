package john_test;

import java.util.Arrays;

public class SingleNumberIndex {
	
	public SingleNumberIndex(){
		
	}
	
	public int findSingleIndex(int[] myArray, int low, int high){
		if(low == high){
			System.out.println("Index is: " + low);
			return low; //now we're done
		}
		
		int midpoint = low + (high - low)/2;
		System.out.println(low + " " + high + " " + midpoint);
		
		if(midpoint % 2 == 0){
			if(myArray[midpoint] == myArray[midpoint + 1]){
				return 1 * findSingleIndex(myArray, midpoint + 2, high);
			}
			else{
				return 1 * findSingleIndex(myArray, low, midpoint);
			}
			
		}
		else{
			if(myArray[midpoint - 1] == myArray[midpoint]){
				return 1 * findSingleIndex(myArray, midpoint + 1, high);
			}
			else{
				return 1 * findSingleIndex(myArray, low, midpoint - 1);
			}			
		}		
	}
	
	public void printArray(int [] array){
		for(int i = 0; i < array.length; ++i){
			System.out.print(array[i] + " ");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		SingleNumberIndex s = new SingleNumberIndex();
		int[] testArray = new int[]{3, 3, 4, 5, 5, 6, 6, 7, 7};
		int result = s.findSingleIndex(testArray, 0, testArray.length - 1);
		System.out.println("Result is: " + result);
	}

}
