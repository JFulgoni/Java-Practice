package john_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CollectionTest {
	
	public static void main(String[] args){
		/*
		 * HashMap is pretty standard. O(1) get, items are in arbitrary order
		 */
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1, "Steve");
		map1.put(2, "Bill");
		map1.put(3, "Uri");
		map1.put(1, "Not Steve");
		/*
		 * LinkedHashMap offers O(1) lookup and Insertion
		 * It will keep the order that the items were inserted in
		 */
		LinkedHashMap<Integer, String> map2 = new LinkedHashMap<Integer, String>();
		map2.put(1, "Steve");
		map2.put(3, "Uri");
		map2.put(2, "Bill");
		/*
		 * TreeMap is logn Lookup and Insertion, but the values are sorted, and can be iterated through
		 */
		TreeMap<Integer, String> map3 = new TreeMap<Integer, String>();
		map3.put(2, "Bill");
		map3.put(3, "Uri");
		map3.put(1, "Steve");
		
		Iterator<Entry<Integer, String>> iter = map1.entrySet().iterator();
		//iter = map1.values().iterator();
		System.out.println("With HashMap, order is arbitrary");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		iter = map2.entrySet().iterator();
		System.out.println("\nWith LinkedHashMap, it prints in order of insertion");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		iter = map3.entrySet().iterator();
		System.out.println("\nWith TreeMap, it prints in sorted order, at a slower price to enter and retrieve");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

}
