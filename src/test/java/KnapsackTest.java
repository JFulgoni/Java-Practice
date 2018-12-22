import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	@Test
	public void testBigDecimal(){
		List<String> stringList = new ArrayList<String>(Arrays.asList("12.31", "9", "-123.35", "00.000"));
		Collections.sort(stringList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				BigDecimal one = new BigDecimal(o1);
				BigDecimal two = new BigDecimal(o2);
				return two.compareTo(one);
			}
		});
		assertEquals("[12.31, 9, 00.000, -123.35]", stringList.toString());
		System.out.println(2014 % 4);
	}

}
