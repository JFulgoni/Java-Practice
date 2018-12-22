package john_test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UnitTestExample {

	public static int add(int x, int y) {
		return x + y;
	}

	@Test
	public static void testAdd(int x, int y, int expected) {
		try {
			assertEquals(expected, add(x, y));
		} catch (AssertionError a) {
			a.printStackTrace(System.out);
		}
	}

	public static void main(String[] args) {
		testAdd(1, 1, 3);
	}

}
