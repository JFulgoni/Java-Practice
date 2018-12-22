import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MapFlipTest {
	
	private char[][] input;
	
	private int rows;
	private int cols;
	private int numFlips;
	
	@Before
	public void setup() {
		rows = 3;
		cols = 3;
		input = new char[rows][cols];
		input[0][0] = 'P';
		input[0][1] = 'P';
		input[0][2] = 'T';
		input[1][0] = 'T';
		input[1][1] = 'P';
		input[1][2] = 'P';
		input[2][0] = 'T';
		input[2][1] = 'T';
		input[2][2] = 'T';
		
		numFlips = 2;
		
		printMatrix(input);
	}
	
	private static void printMatrix(char[][] matrix) {
		for(int i = 0; i < matrix.length; i++){
			char[] row = matrix[i];
			for(int j = 0; j < row.length; j++){
				System.out.print(row[j] + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void testMapFlip() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < rows; i++){
			char[] row = input[i];
			int numberOfTsInRow = 0;
			for(char r : row){
				if(r == 'T') ++numberOfTsInRow;
			}
			
			//if the number of T's equals the number of available flips
			//or the there are more flips than the count AND there are an odd number of flips left
			if(numberOfTsInRow == numFlips || (numFlips - numberOfTsInRow >= 0 && (numFlips -numberOfTsInRow % 2 != 0))){
				String key = new String(row);
				if(map.containsKey(key)){
					map.put(key, map.get(key) + 1);
				}
				else{
					map.put(key, 1);
				}
			}
		}
		
		int max = 0;
		for(int value : map.values()){
			max = Math.max(value,  max);
		}
		assertEquals(1, max);
	}

}
