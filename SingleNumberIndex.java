package john_test;

import java.util.Arrays;

public class SingleNumberIndex {
	
	public SingleNumberIndex(){
		
	}
	
	/*
	 * This code returns the index of a singleton in an array of pairs
	 * Where the array is a sorted array of ints
	 * It is similar to SingleNumber.java, and can be modified to return the number
	 * Instead of just the index
	 */
	public int findSingleIndex(int[] myArray, int low, int high){
		if(low == high){
			System.out.println("Index is: " + low);
			return low; //now we're done
		}
		
		int midpoint = low + (high - low)/2;
		System.out.println(low + " " + high + " " + midpoint);
		
		if(midpoint % 2 == 0){
			//if the midpoint is an even index
			//compare it to the number to it's right
			if(myArray[midpoint] == myArray[midpoint + 1]){
				//if they are the same
				//take the right half
				return 1 * findSingleIndex(myArray, midpoint + 2, high);
			}
			else{
				//if they are different
				//then take the left half
				return 1 * findSingleIndex(myArray, low, midpoint);
			}
			
		}
		else{
			//if the midpoint is an odd index
			//compare it to the one on it's left
			if(myArray[midpoint - 1] == myArray[midpoint]){
				//if they are the same
				//then take the right half
				return 1 * findSingleIndex(myArray, midpoint + 1, high);
			}
			else{
				//if they are different
				//take the left half
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
