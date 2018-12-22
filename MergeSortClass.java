package john_test;

import java.util.ArrayList;
import java.util.List;

public class MergeSortClass {
	public MergeSortClass(){
	}
	
	public List<Integer> mergeSort(List<Integer> myList){
		if(myList.size() < 2){
			return myList;
		}
		
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		for(int i = 0; i < myList.size(); ++i){
			if(i % 2 == 1){
				left.add(myList.get(i));
			}
			else{
				right.add(myList.get(i));
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	public List<Integer> merge(List<Integer> left, List<Integer> right){
		List<Integer> result = new ArrayList<Integer>();
		while(!left.isEmpty() && !right.isEmpty()){
			if(left.get(0) <= right.get(0)){
				result.add(left.get(0));
				left.remove(0);
			}
			else{
				result.add(right.get(0));
				right.remove(0);
			}
		}
		
		/*
		 * finish up whatever list isn't empty
		 */
		while(!left.isEmpty()){
			result.add(left.get(0));
			left.remove(0);
		}
		while(!right.isEmpty()){
			result.add(right.get(0));
			right.remove(0);
		}
		return result;
	}

	public static void main(String[] args){
		MergeSortClass ms = new MergeSortClass();
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(6);
		myList.add(3);
		myList.add(9);
		myList.add(1);
		myList.add(2);
		myList.add(3);
		System.out.println(myList);
		List<Integer> sortedList = ms.mergeSort(myList);
		System.out.println(sortedList);
	}
}
