package john_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class KnapsackTest {

	private Integer[] weightList;
	private Integer[] valueList;
	private final int capacity = 150;

	@Before
	public void setup() {
		weightList = (Integer[]) Arrays.asList(1, 56, 42, 78, 12, 0).toArray();
		valueList = (Integer[]) Arrays.asList(50, 30, 20, 10, 50, 42).toArray();
	}

	@Test
	public void testKnapsack() {
		int numberOfItems = valueList.length;
		assertEquals(weightList.length, numberOfItems);
		
		for(int item : weightList){
			assertTrue("Items can't have a negative weight", item >= 0);
		}

		int[][] map = new int[numberOfItems + 1][capacity + 1];

		for (int itemIndex = 0; itemIndex <= numberOfItems; itemIndex++) {
			for (int weightLimit = 0; weightLimit <= capacity; weightLimit++) {
				if (weightLimit == 0 || itemIndex == 0) {
					map[itemIndex][weightLimit] = 0;
				} else if (weightList[itemIndex - 1] <= weightLimit) {
					map[itemIndex][weightLimit] = Math.max(
							valueList[itemIndex - 1] + map[itemIndex - 1][weightLimit - weightList[itemIndex - 1]],
							map[itemIndex - 1][weightLimit]);
				} else {
					map[itemIndex][weightLimit] = map[itemIndex - 1][weightLimit];
				}
			}
		}

		assertEquals("The maximum value should be 192", 192, map[numberOfItems][capacity]);
	}

}
