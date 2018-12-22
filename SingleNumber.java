package john_test;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	public SingleNumber(){
		
	}
	
	public int findSingle(int[] array){
		/*
		 * the best solution for this is to use the ^ symbol to perform a bitwise XOR
		 * with XOR, if there's ever a number that appears twice, it will cancel out
		 * that's just a weird trick
		 */
//		int result = 0;
//		for(int a : array){
//			result = result ^ a;
//			System.out.print(result);
//		}
//		return result;
		Set<Integer> first = new HashSet<Integer>();
		//Set<Integer> second = new HashSet<Integer>();
		for(int a: array){
			if(first.contains(a)){
				first.remove(a);
			}
			else{
				first.add(a);
			}
		}
		for(Integer i: first){
			return i;
		}
		return Integer.MAX_VALUE;
	}
	
	public int findSingleII(int[] array){
		Set<Integer> first = new HashSet<Integer>();
		Set<Integer> second = new HashSet<Integer>();
		for(int a: array){
			if(first.contains(a) && second.contains(a)){
				first.remove(a);
				second.remove(a);
			}
			else if(first.contains(a)){
				second.add(a);
			}
			else{
				first.add(a);
			}
		}
		for(Integer i: first){
			return i;
		}
		return Integer.MAX_VALUE;
	}

}
